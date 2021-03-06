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

package com.rodrigodev.xgen4j.model.error.configuration.definition;

import com.rodrigodev.xgen4j.common.lang.PackageUtil;
import com.rodrigodev.xgen4j.model.error.configuration.definition.code.ErrorCodeDefinition;
import com.rodrigodev.xgen4j.model.error.configuration.definition.code.ErrorCodeDefinition.ErrorCodeDefinitionBuilder;
import com.rodrigodev.xgen4j.model.error.configuration.definition.description.CustomMessageGeneratorDefinition;
import com.rodrigodev.xgen4j.model.error.configuration.definition.description.ErrorDescriptionDefinition;
import com.rodrigodev.xgen4j.model.error.configuration.definition.name.ErrorNameChecker;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.experimental.NonFinal;

import java.util.Arrays;
import java.util.Optional;

import static com.google.common.base.Preconditions.*;
import static com.rodrigodev.xgen4j.model.error.configuration.definition.package_path.PackagePathConverter.codeNameToPackagePart;
import static com.rodrigodev.xgen4j.model.error.configuration.definition.package_path.PackagePathConverter.errorNameToPackagePart;

/**
 * Created by Rodrigo Quesada on 12/05/15.
 */
@Value
@Accessors(fluent = true)
@NonFinal
public class ErrorDefinition {

    @NonNull private String name;
    @NonNull private ErrorCodeDefinition code;
    @NonNull private Optional<ErrorDescriptionDefinition> description;
    @NonNull private Optional<CustomMessageGeneratorDefinition> customMessageGenerator;
    @NonNull private ErrorDefinition[] errors;
    @NonNull private String packagePath;
    private boolean isCommon;
    private boolean isRoot;

    private ErrorDefinition(
            @NonNull String name,
            @NonNull ErrorCodeDefinition code,
            @NonNull Optional<ErrorDescriptionDefinition> description,
            @NonNull Optional<CustomMessageGeneratorDefinition> customMessageGenerator,
            @NonNull ErrorDefinition[] errors,
            @NonNull String packagePath,
            boolean isCommon,
            boolean isRoot
    ) {
        checkArgument(
                !description.isPresent() || description.isPresent() ^ customMessageGenerator.isPresent(),
                "Either specify a text-based description OR a custom message generator for it, but not both."
        );

        this.name = name;
        this.code = code;
        this.description = description;
        this.customMessageGenerator = customMessageGenerator;
        this.errors = errors;
        this.packagePath = packagePath;
        this.isCommon = isCommon;
        this.isRoot = isRoot;
    }

    protected ErrorDefinition(ErrorDefinitionBuilder<?, ?> builder) {
        this(builder.name,
             builder.codeBuilder.build(),
             builder.description,
             builder.customMessageGenerator,
             builder.errors,
             builder.packagePath.get(),
             builder.isCommon,
             !builder.parent.isPresent());
    }

    public static ErrorDefinitionBuilder<?, ?> builder(String name) {
        return new NormalErrorDefinitionBuilder(name);
    }

    @Accessors(fluent = true)
    public static abstract class ErrorDefinitionBuilder<D extends ErrorDefinition, B extends ErrorDefinitionBuilder<D, B>> {

        private String name;
        private ErrorCodeDefinitionBuilder codeBuilder;
        private Optional<ErrorDescriptionDefinition> description;
        private Optional<CustomMessageGeneratorDefinition> customMessageGenerator;
        private ErrorDefinitionBuilder<?, ?>[] errorBuilders;
        private ErrorDefinition[] errors;
        @NonNull private Optional<String> packagePath;
        @Setter(AccessLevel.PROTECTED) private boolean isCommon;
        @NonNull private Optional<ErrorDefinitionBuilder<?, ?>> parent;
        private ErrorNameChecker nameChecker;

        protected ErrorDefinitionBuilder(String name) {
            codeBuilder = ErrorCodeDefinition.builder();
            description = Optional.empty();
            customMessageGenerator = Optional.empty();
            errorBuilders = new ErrorDefinitionBuilder[0];
            packagePath = Optional.empty();
            parent = Optional.empty();
            nameChecker = new ErrorNameChecker(name);
            setName(name);
        }

        protected abstract B self();

        private void setName(String name) {
            nameChecker.checkIsValid();

            this.name = name;
            if (!codeBuilder.nameIsSet()) codeBuilder.nameFromText(name);
        }

        public B code(String codeName) {
            codeBuilder.name(codeName);
            packagePath = Optional.of(codeNameToPackagePart(codeName));
            return self();
        }

        public B code(int codeNumber) {
            codeBuilder.number(codeNumber);
            return self();
        }

        public B code(String codeName, int codeNumber) {
            code(codeName);
            codeBuilder.number(codeNumber);
            return self();
        }

        public B description(
                String descriptionFormat, ParameterDefinition... params
        ) {
            checkArgument(!descriptionFormat.isEmpty(), "descriptionFormat is empty");

            description = Optional.of(new ErrorDescriptionDefinition(descriptionFormat, params));
            return self();
        }

        public B description(Class<?> customMessageGeneratorType, String name) {
            customMessageGenerator = Optional.of(
                    new CustomMessageGeneratorDefinition(customMessageGeneratorType, name));
            return self();
        }

        public B errors(ErrorDefinitionBuilder<?, ?>... errorBuilders) {
            this.errorBuilders = errorBuilders;
            return self();
        }

        protected void packagePath(String packagePath) {
            this.packagePath = Optional.of(packagePath);
        }

        private void parent(ErrorDefinitionBuilder<?, ?> parent) {
            this.parent = Optional.of(parent);
        }

        protected D build() {
            nameChecker.checkIsNotDuplicate();
            parent.ifPresent(p -> {
                codeBuilder.parent(p.codeBuilder);
                packagePath = Optional.of(PackageUtil.join(
                        p.packagePath.get(), packagePath.orElse(errorNameToPackagePart(name))
                ));
                isCommon = isCommon || p.isCommon;
            });
            errors = Arrays.stream(errorBuilders)
                    .peek(e -> {
                        e.parent(this);
                        e.nameChecker.setParent(nameChecker);
                    })
                    .map(ErrorDefinitionBuilder::build)
                    .toArray(ErrorDefinition[]::new);

            return createErrorDefinition();
        }

        protected abstract D createErrorDefinition();
    }

    private static class NormalErrorDefinitionBuilder extends ErrorDefinitionBuilder<ErrorDefinition, NormalErrorDefinitionBuilder> {

        protected NormalErrorDefinitionBuilder(String name) {
            super(name);
        }

        @Override
        protected NormalErrorDefinitionBuilder self() {
            return this;
        }

        @Override
        protected ErrorDefinition createErrorDefinition() {
            return new ErrorDefinition(this);
        }
    }
}
