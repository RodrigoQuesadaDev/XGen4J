/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Rodrigo Quesada <rodrigoquesada.dev@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.rodrigodev.xgen4j.model.error.configuration.definition.name;

import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.*;
import static com.rodrigodev.xgen4j.model.error.configuration.definition.package_path.PackagePathConverter.errorNameToPackagePart;

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
        this.ancestorNamesMap = new HashMap<>();
        this.childrenNamesMap = new HashMap<>();
        this.parent = Optional.empty();
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
            return errorNameToPackagePart(name);
        }
    }
}
