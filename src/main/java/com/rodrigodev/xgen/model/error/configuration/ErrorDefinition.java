package com.rodrigodev.xgen.model.error.configuration;

import com.rodrigodev.xgen.model.error.configuration.code.ErrorCodeDefinition;
import com.rodrigodev.xgen.model.error.configuration.code.ErrorCodeDefinition.ErrorCodeDefinitionBuilder;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.*;
import static com.rodrigodev.xgen.model.error.configuration.code.ErrorCodeDefinition.codeNameFrom;

/**
 * Created by Rodrigo Quesada on 12/05/15.
 */
@Value
@Accessors(fluent = true)
public class ErrorDefinition {

    private static final Pattern VALID_NAME_PATTERN = Pattern.compile("\\p{Upper}[\\w\\-]*", Pattern.UNICODE_CASE);
    private static final String VALID_PACKAGE_PART_REGEX = "[\\p{Alpha}_][\\w]*";
    private static final Pattern VALID_PACKAGE_PATTERN = Pattern.compile(
            String.format("%1$s(?:\\.%1$s)*", VALID_PACKAGE_PART_REGEX), Pattern.UNICODE_CASE);

    @NonNull private String name;
    @NonNull private ErrorCodeDefinition code;
    @NonNull private Optional<ErrorDescriptionDefinition> description;
    @NonNull private Optional<CustomMessageGeneratorDefinition> customMessageGenerator;
    @NonNull private ErrorDefinition[] errors;
    @NonNull private String packagePath;
    private boolean isCommon;
    @NonNull private boolean isRoot;

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

    public static ErrorDefinitionBuilder builder() {
        return new ErrorDefinitionBuilder();
    }

    @Accessors(fluent = true)
    public static class ErrorDefinitionBuilder {

        private static final String DOT = ".";

        private String name;
        //TODO remove initialization (temporary while adding more features)
        private ErrorCodeDefinitionBuilder codeBuilder;
        private Optional<ErrorDescriptionDefinition> description;
        private Optional<CustomMessageGeneratorDefinition> customMessageGenerator;
        private ErrorDefinitionBuilder[] errorBuilders;
        @NonNull private String packagePath;
        boolean isCommon;
        @NonNull private Optional<ErrorDefinitionBuilder> parent;

        public ErrorDefinitionBuilder() {
            codeBuilder = ErrorCodeDefinition.builder();
            description = Optional.empty();
            customMessageGenerator = Optional.empty();
            errorBuilders = new ErrorDefinitionBuilder[0];
            parent = Optional.empty();
        }

        public ErrorDefinitionBuilder name(String name) {
            checkArgument(
                    VALID_NAME_PATTERN.matcher(name).matches(),
                    String.format("Error name '%s' has invalid format.", name)
            );

            this.name = name;
            if (!codeBuilder.nameIsSet()) codeBuilder.name(codeNameFrom(name));
            //TODO name generation when code number specified but name is not
            return this;
        }

        public ErrorDefinitionBuilder code(String codeName) {
            codeBuilder.name(codeName);
            return this;
        }

        public ErrorDefinitionBuilder code(int codeNumber) {
            codeBuilder.number(codeNumber);
            return this;
        }

        public ErrorDefinitionBuilder code(String codeName, int codeNumber) {
            codeBuilder.name(codeName).number(codeNumber);
            return this;
        }

        public ErrorDefinitionBuilder description(
                String descriptionFormat, ParameterDefinition... params
        ) {
            checkArgument(!descriptionFormat.isEmpty(), "descriptionFormat is empty");

            description = Optional.of(new ErrorDescriptionDefinition(descriptionFormat, params));
            return this;
        }

        public ErrorDefinitionBuilder description(Class<?> customMessageGeneratorType, String name) {
            customMessageGenerator = Optional.of(
                    new CustomMessageGeneratorDefinition(customMessageGeneratorType, name));
            return this;
        }

        public ErrorDefinitionBuilder errors(ErrorDefinitionBuilder... errorBuilders) {
            this.errorBuilders = errorBuilders;
            return this;
        }

        public ErrorDefinitionBuilder basePackage(String basePackage) {
            checkArgument(
                    VALID_PACKAGE_PATTERN.matcher(basePackage).matches(),
                    String.format("Base package '%s' has invalid format.", basePackage)
            );

            packagePath = basePackage;
            return this;
        }

        public ErrorDefinitionBuilder isCommon(boolean isCommon) {
            this.isCommon = isCommon;
            return this;
        }

        public ErrorDefinitionBuilder parent(ErrorDefinitionBuilder parent) {
            this.parent = Optional.of(parent);
            return this;
        }

        public ErrorDefinition build() {
            parent.ifPresent(p -> {
                codeBuilder.parent(p.codeBuilder);
                packagePath = generatePackagePath(p);
                isCommon = isCommon || p.isCommon;
            });
            ErrorDefinition[] errors = Arrays.stream(errorBuilders)
                    .peek(e -> e.parent(this))
                    .map(ErrorDefinitionBuilder::build)
                    .toArray(ErrorDefinition[]::new);

            return new ErrorDefinition(
                    name,
                    codeBuilder.build(),
                    description,
                    customMessageGenerator,
                    errors,
                    packagePath,
                    isCommon,
                    !parent.isPresent()
            );
        }

        private String generatePackagePath(ErrorDefinitionBuilder parent) {
            return parent.packagePath + DOT + ErrorNameToPackagePartConverter.convert(name);
        }
    }
}
