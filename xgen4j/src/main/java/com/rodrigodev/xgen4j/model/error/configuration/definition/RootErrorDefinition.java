package com.rodrigodev.xgen.model.error.configuration.definition;

import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.*;

/**
 * Created by Rodrigo Quesada on 12/07/15.
 */
public class RootErrorDefinition extends ErrorDefinition {

    private static final String VALID_PACKAGE_PART_REGEX = "[\\p{Alpha}_][\\w]*";
    private static final Pattern VALID_PACKAGE_PATTERN = Pattern.compile(
            String.format("%1$s(?:\\.%1$s)*", VALID_PACKAGE_PART_REGEX), Pattern.UNICODE_CASE);

    protected RootErrorDefinition(ErrorDefinitionBuilder<?, ?> builder) {
        super(builder);
    }

    public static RootErrorDefinitionBuilder builder(String name) {
        return new RootErrorDefinitionBuilder(name);
    }

    public static class RootErrorDefinitionBuilder extends ErrorDefinitionBuilder<RootErrorDefinition, RootErrorDefinitionBuilder> {

        protected RootErrorDefinitionBuilder(String name) {
            super(name);
        }

        @Override
        protected RootErrorDefinitionBuilder self() {
            return this;
        }

        public RootErrorDefinitionBuilder basePackage(String basePackage) {
            checkArgument(
                    VALID_PACKAGE_PATTERN.matcher(basePackage).matches(),
                    String.format("Base package '%s' has invalid format.", basePackage)
            );

            packagePath(basePackage);
            return this;
        }

        @Override
        protected RootErrorDefinition createErrorDefinition() {
            return new RootErrorDefinition(this);
        }

        @Override
        public RootErrorDefinition build() {
            return super.build();
        }
    }
}
