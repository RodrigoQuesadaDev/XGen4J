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

package com.rodrigodev.xgen4j.model.error.configuration.definition.code;

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

        public boolean isRoot() {
            return !parent.isPresent();
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
            checkNameUniquenessAmongSiblings();
            checkNameNotEqualToRootName();
        }

        private void checkNameUniquenessAmongSiblings() {
            if (parent.isPresent()) {
                Set<String> parentChildrenNames = parent.get().childrenNames;
                checkState(
                        parentChildrenNames.add(name),
                        String.format("Duplicated code name '%s' for error code.", name)
                );
            }
        }

        private void checkNameNotEqualToRootName() {
            parent.ifPresent(p -> {
                if (p.isRoot()) {
                    checkState(
                            !name.equals(p.name),
                            String.format("Error code '%s' has same name as root error's code.", name)
                    );
                }
            });
        }

        private void checkNumber() {
            checkNumberPresence();
            checkNumberUniquenessAmongSiblings();
            checkNumberNotEqualToRootNumber();
        }

        private void checkNumberPresence() {
            parent.ifPresent(p -> {
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
            });
        }

        private void checkNumberUniquenessAmongSiblings() {
            if (number.isPresent() && parent.isPresent()) {
                Set<Integer> parentChildrenNumbers = parent.get().childrenNumbers;
                int number = this.number.get();
                checkState(
                        parentChildrenNumbers.add(number),
                        String.format("Duplicated code number '%d' for error code '%s'.", number, name)
                );
            }
        }

        private void checkNumberNotEqualToRootNumber() {
            parent.ifPresent(p -> {
                if (p.isRoot() && number.isPresent()) {
                    checkState(
                            !number.get().equals(p.number.get()),
                            String.format(
                                    "Number for error code '%s' is equal to root error's code's number."
                                    , name
                            )
                    );
                }
            });
        }
    }
}
