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
