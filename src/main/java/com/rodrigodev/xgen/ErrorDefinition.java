package com.rodrigodev.xgen;

import lombok.NonNull;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 12/05/15.
 */
@Value
public class ErrorDefinition {

    @NonNull private ErrorDescription description;
    @NonNull private ErrorDefinition[] errors;
    @NonNull private String basePackage;

    public static ErrorDefinitionBuilder builder() {
        return new ErrorDefinitionBuilder();
    }

    @Accessors(fluent = true)
    public static class ErrorDefinitionBuilder {

        private ErrorDescription description;
        private ErrorDefinition[] errors;
        @Setter private String basePackage;

        public ErrorDefinition.ErrorDefinitionBuilder description(String descriptionFormat, ParameterDefinition... params) {
            this.description = new ErrorDescription(descriptionFormat, params);
            return this;
        }

        public ErrorDefinition.ErrorDefinitionBuilder errors(ErrorDefinition... errors) {
            this.errors = errors;
            return this;
        }

        public ErrorDefinition build() {
            return new ErrorDefinition(description, errors, basePackage);
        }
    }
}
