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

package com.rodrigodev.xgen4j.test;

import com.rodrigodev.xgen4j.DaggerExceptionsGeneratorComponent;
import com.rodrigodev.xgen4j.ExceptionsGenerator;
import com.rodrigodev.xgen4j.ExceptionsGeneratorComponent;
import com.rodrigodev.xgen4j.MainModule;
import com.rodrigodev.xgen4j.model.error.configuration.definition.ErrorDefinition.ErrorDefinitionBuilder;
import com.rodrigodev.xgen4j.service.time.TimeService;
import com.rodrigodev.xgen4j.test.common.doubles.service.time.FakeTimeModule;
import com.rodrigodev.xgen4j.test.common.doubles.service.time.FakeTimeService;

import static com.rodrigodev.xgen4j.common.lang.PackageUtil.join;

/**
 * Created by Rodrigo Quesada on 14/07/15.
 */
public class TestSpecification {

    protected static final String SRC_DIR_PATH = "src/test-gen/java";
    protected static final String ERROR_SUFFIX = "Error";
    protected static final String EXCEPTION_SUFFIX = "Exception";

    private ExceptionsGeneratorComponent exceptionsGeneratorComponent;

    public TestSpecification() {
        FakeTimeService timeService = new FakeTimeService();
        timeService.setupConstant();

        DaggerExceptionsGeneratorComponent.Builder componentBuilder = DaggerExceptionsGeneratorComponent.builder()
                .mainModule(new MainModule(SRC_DIR_PATH))
                .timeModule(new FakeTimeModule(timeService));

        customizeComponent(componentBuilder);
        this.exceptionsGeneratorComponent = componentBuilder.build();
    }

    protected void customizeComponent(DaggerExceptionsGeneratorComponent.Builder componentBuilder) {
    }

    protected ExceptionsGenerator generator() {
        return exceptionsGeneratorComponent.generator();
    }

    protected static void assertThatClassExists(String basePackage, String classPath) {
        try {
            Class.forName(join(basePackage, classPath));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //TODO use this method for asserting whenever possible
    protected static void assertThatErrorAndExceptionClassExist(String basePackage, String baseClassPath) {
        assertThatClassExists(basePackage, baseClassPath + ERROR_SUFFIX);
        assertThatClassExists(basePackage, baseClassPath + EXCEPTION_SUFFIX);
    }

    @SuppressWarnings("unchecked")
    protected <B extends ErrorDefinitionBuilder<?, ?>> B code(
            B errorBuilder, String name, int number, boolean withNumericId
    ) {
        return (B) (withNumericId ? errorBuilder.code(name, number) : errorBuilder.code(name));
    }
}
