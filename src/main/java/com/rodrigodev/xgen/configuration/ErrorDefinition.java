package com.rodrigodev.xgen.configuration;

import lombok.NonNull;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 12/05/15.
 */
@Value
@Accessors(fluent = true)
public class ErrorDefinition {

    @NonNull private String name;
    @NonNull private Optional<ErrorDescription> description;
    @NonNull private ErrorDefinition[] errors;
    @NonNull private String basePackage;

    public static ErrorDefinitionBuilder builder() {
        return new ErrorDefinitionBuilder();
    }

    @Accessors(fluent = true)
    public static class ErrorDefinitionBuilder {

        @Setter private String name;
        private Optional<ErrorDescription> description;
        private ErrorDefinitionBuilder[] errorBuilders;
        @Setter private String basePackage;

        public ErrorDefinitionBuilder() {
            description = Optional.empty();
            errorBuilders = new ErrorDefinitionBuilder[0];
        }

        public ErrorDefinition.ErrorDefinitionBuilder description(
                String descriptionFormat, ParameterDefinition... params
        ) {
            description = Optional.of(new ErrorDescription(descriptionFormat, params));
            return this;
        }

        public ErrorDefinition.ErrorDefinitionBuilder errors(ErrorDefinitionBuilder... errorBuilders) {
            this.errorBuilders = errorBuilders;
            return this;
        }

        public ErrorDefinition build() {
            ErrorDefinition[] errors = Arrays.stream(errorBuilders)
                    .peek(b -> b.basePackage(basePackage))
                    .map(ErrorDefinitionBuilder::build)
                    .toArray(ErrorDefinition[]::new);
            return new ErrorDefinition(name, description, errors, basePackage);
        }
    }
}
