package com.rodrigodev.xgen.model.error.configuration.code;

import lombok.NonNull;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.*;

/**
 * Created by Rodrigo Quesada on 12/05/15.
 */
@Value
@Accessors(fluent = true)
public class ErrorCodeDefinition {

    private static final Pattern VALID_CODE_NAME_PATTERN
            = Pattern.compile("\\p{Lower}[\\p{Lower}\\d\\-]*", Pattern.UNICODE_CASE);

    @NonNull private String name;
    @NonNull private Optional<Integer> number;

    private ErrorCodeDefinition(@NonNull String name, @NonNull Optional<Integer> number) {
        checkArgument(
                VALID_CODE_NAME_PATTERN.matcher(name).matches(),
                String.format("Error code's name '%s' has invalid format.", name)
        );

        this.name = name;
        this.number = number;
    }

    public static ErrorCodeDefinitionBuilder builder() {
        return new ErrorCodeDefinitionBuilder();
    }

    @Accessors(fluent = true)
    public static class ErrorCodeDefinitionBuilder {

        private Optional<ErrorCodeDefinitionBuilder> parent;
        @Setter private String name;
        private Optional<Integer> number;

        private Set<Integer> childrenNumbers;
        private Set<String> childrenNames;

        private ErrorCodeDefinitionBuilder() {
            this.parent = Optional.empty();
            this.number = Optional.empty();
            this.childrenNumbers = new HashSet<>();
            this.childrenNames = new HashSet<>();
        }

        public ErrorCodeDefinitionBuilder parent(ErrorCodeDefinitionBuilder parent) {
            this.parent = Optional.of(parent);
            return this;
        }

        public void nameFromText(String text) {
            name = TextToCodeNameConverter.convert(text);
        }

        public boolean nameIsSet() {
            return name != null;
        }

        public ErrorCodeDefinitionBuilder number(Integer number) {
            this.number = Optional.of(number);
            return this;
        }

        public ErrorCodeDefinition build() {
            checkName();
            checkNumber();

            return new ErrorCodeDefinition(name, number);
        }

        private void checkName() {
            if (parent.isPresent()) {
                Set<String> parentChildrenNames = parent.get().childrenNames;
                checkState(
                        parentChildrenNames.add(name),
                        String.format("Duplicated code name '%s' for error code.", name)
                );
            }
        }

        private void checkNumber() {
            checkNumberPresence();
            checkNumberUniqueness();
        }

        private void checkNumberPresence() {
            parent.ifPresent(
                    p -> {
                        boolean codeNumberPresent = number.isPresent();
                        checkState(
                                codeNumberPresent == p.number.isPresent(),
                                String.format(
                                        codeNumberPresent
                                                ? "Error code '%s' can't have a code number."
                                                : "Code number is missing for error code '%s'."
                                        , name
                                )
                        );
                    }
            );
        }

        private void checkNumberUniqueness() {
            if (number.isPresent() && parent.isPresent()) {
                Set<Integer> parentChildrenNumbers = parent.get().childrenNumbers;
                int number = this.number.get();
                checkState(
                        parentChildrenNumbers.add(number),
                        String.format("Duplicated code number '%d' for error code '%s'.", number, name)
                );
            }
        }
    }
}
