package com.rodrigodev.xgen.model.error.configuration.definition.name;

import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.*;

/**
 * Created by Rodrigo Quesada on 12/07/15.
 */
public class ErrorNameChecker {

    private static final Pattern VALID_NAME_PATTERN = Pattern.compile("\\p{Upper}[\\w\\-]*", Pattern.UNICODE_CASE);
    private static final String DUPLICATED_NAME_ANCESTOR_DESCENDANT = "Error cannot have name '%s' because an ancestor error has '%s' as name.";
    private static final String DUPLICATED_NAME_SIBLINGS = "Error cannot have name '%s' because a sibling error has '%s' as name.";

    final private NameContainer nameContainer;
    private Map<String, NameContainer> ancestorNamesMap;
    private Map<String, NameContainer> childrenNamesMap;
    private Optional<ErrorNameChecker> parent;

    public ErrorNameChecker(String name) {
        this.nameContainer = new NameContainer(name);
        ancestorNamesMap = new HashMap<>();
        childrenNamesMap = new HashMap<>();
        parent = Optional.empty();
    }

    public void setParent(ErrorNameChecker parent) {
        this.parent = Optional.of(parent);
        addAncestorFromParent();
    }

    private void addAncestorFromParent() {
        this.ancestorNamesMap.putAll(parent.get().ancestorNamesMap);
    }

    public void checkIsValid() {
        checkArgument(
                VALID_NAME_PATTERN.matcher(nameContainer.name).matches(),
                String.format("Error name '%s' has invalid format.", nameContainer.name)
        );
    }

    public void checkIsNotDuplicate() {
        checkNotDuplicateOnMap(ancestorNamesMap, DUPLICATED_NAME_ANCESTOR_DESCENDANT);
        parent.ifPresent(p -> checkNotDuplicateOnMap(p.childrenNamesMap, DUPLICATED_NAME_SIBLINGS));
    }

    private void checkNotDuplicateOnMap(Map<String, NameContainer> map, String errorMessageFormat) {
        checkState(
                map.putIfAbsent(nameContainer.normalizedName, nameContainer) == null,
                String.format(errorMessageFormat,
                              nameContainer.name, map.get(nameContainer.normalizedName).name
                )
        );
    }

    @FieldDefaults(makeFinal = true)
    private static class NameContainer {

        private String name;
        private String normalizedName;

        public NameContainer(@NonNull String name) {
            this.name = name;
            this.normalizedName = normalizeName(name);
        }

        private String normalizeName(String name) {
            return ErrorNameConverter.convertToPackagePart(name);
        }
    }
}
