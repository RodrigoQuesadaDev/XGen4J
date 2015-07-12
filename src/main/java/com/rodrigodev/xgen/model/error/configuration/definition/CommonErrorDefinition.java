package com.rodrigodev.xgen.model.error.configuration.definition;

/**
 * Created by Rodrigo Quesada on 12/07/15.
 */
public class CommonErrorDefinition extends ErrorDefinition {

    protected CommonErrorDefinition(ErrorDefinitionBuilder<?> builder) {
        super(builder);
    }

    public static CommonErrorDefinitionBuilder builder(String name) {
        return new CommonErrorDefinitionBuilder(name);
    }

    public static class CommonErrorDefinitionBuilder extends ErrorDefinitionBuilder<CommonErrorDefinitionBuilder> {

        protected CommonErrorDefinitionBuilder(String name) {
            super(name);
            isCommon(true);
        }

        @Override
        protected CommonErrorDefinitionBuilder self() {
            return this;
        }
    }
}
