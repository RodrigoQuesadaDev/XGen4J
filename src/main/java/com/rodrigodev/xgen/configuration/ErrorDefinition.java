package com.rodrigodev.xgen.configuration;

import com.google.common.base.CaseFormat;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.*;

/**
 * Created by Rodrigo Quesada on 12/05/15.
 */
@Value
@Accessors(fluent = true)
public class ErrorDefinition {

    private static final Pattern VALID_NAME_PATTERN = Pattern.compile("\\p{Upper}[\\w\\-]*", Pattern.UNICODE_CASE);

    @NonNull private String name;
    @NonNull private Optional<ErrorDescription> description;
    @NonNull private ErrorDefinition[] errors;
    @NonNull private String packagePath;

    private ErrorDefinition(
            @NonNull String name,
            @NonNull Optional<ErrorDescription> description,
            @NonNull ErrorDefinition[] errors,
            @NonNull String packagePath
    ) {
        this.name = name;
        this.description = description;
        this.errors = errors;
        this.packagePath = packagePath;
    }


    public static ErrorDefinitionBuilder builder() {
        return new ErrorDefinitionBuilder();
    }

    @Accessors(fluent = true)
    public static class ErrorDefinitionBuilder {

        private static final String DOT = ".";

        private String name;
        private Optional<ErrorDescription> description;
        private ErrorDefinitionBuilder[] errorBuilders;
        @Setter private String basePackage;

        public ErrorDefinitionBuilder() {
            description = Optional.empty();
            errorBuilders = new ErrorDefinitionBuilder[0];
        }

        public ErrorDefinition.ErrorDefinitionBuilder name(String name) {
            checkArgument(
                    VALID_NAME_PATTERN.matcher(name).matches(),
                    String.format("Error name '%s' has invalid format.", name)
            );

            this.name = name;
            return this;
        }

        public ErrorDefinition.ErrorDefinitionBuilder description(
                String descriptionFormat, ParameterDefinition... params
        ) {
            checkArgument(!descriptionFormat.isEmpty(), "descriptionFormat is empty");

            description = Optional.of(new ErrorDescription(descriptionFormat, params));
            return this;
        }

        public ErrorDefinition.ErrorDefinitionBuilder errors(ErrorDefinitionBuilder... errorBuilders) {
            this.errorBuilders = errorBuilders;
            return this;
        }

        public ErrorDefinition build() {
            return build(true);
        }

        private ErrorDefinition build(boolean isRoot) {
            String packagePath = generatePackagePath(isRoot);
            ErrorDefinition[] errors = Arrays.stream(errorBuilders)
                    .peek(e -> e.basePackage(packagePath))
                    .map(e -> e.build(false))
                    .toArray(ErrorDefinition[]::new);
            return new ErrorDefinition(name, description, errors, packagePath);
        }

        private String generatePackagePath(boolean isRoot) {
            StringBuilder stringBuilder = new StringBuilder(basePackage);
            if (!isRoot) {
                stringBuilder.append(DOT).append(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name));
            }
            return stringBuilder.toString();
        }
    }
}
