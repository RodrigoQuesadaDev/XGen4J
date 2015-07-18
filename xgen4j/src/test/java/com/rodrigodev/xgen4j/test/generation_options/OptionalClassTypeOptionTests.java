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

package com.rodrigodev.xgen4j.test.generation_options;

import com.rodrigodev.xgen4j.ExceptionsGenerator;
import com.rodrigodev.xgen4j.ExceptionsGeneratorComponent;
import com.rodrigodev.xgen4j.GenerationOptions;
import com.rodrigodev.xgen4j.MainModule;
import com.rodrigodev.xgen4j.model.common.file.FileService;
import com.rodrigodev.xgen4j.model.error.configuration.definition.RootErrorDefinition;
import com.rodrigodev.xgen4j.model.support.optional.OptionalClassType;
import com.rodrigodev.xgen4j.test.TestSpecification;
import com.rodrigodev.xgen4j.test.common.doubles.error.message.TestMessageGeneratorObject;
import com.rodrigodev.xgen4j.test.common.doubles.error.message.TestObject;
import com.rodrigodev.xgen4j.test.common.doubles.file.InMemoryFileModule;
import com.rodrigodev.xgen4j.test.common.doubles.file.InMemoryFileService;
import dagger.Component;
import org.assertj.core.api.Condition;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

import static com.rodrigodev.xgen4j.model.error.configuration.ErrorConfiguration.*;
import static com.rodrigodev.xgen4j.model.error.configuration.definition.ParameterDefinition.p;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
public class OptionalClassTypeOptionTests extends TestSpecification {

    @Singleton
    @Component(modules = {MainModule.class})
    public interface TestExceptionsGeneratorComponent extends ExceptionsGeneratorComponent {

        void inject(OptionalClassTypeOptionTests testClass);
    }

    private TestExceptionsGeneratorComponent exceptionsGeneratorComponent;
    private InMemoryFileService fileService;

    public OptionalClassTypeOptionTests() {
        exceptionsGeneratorComponent = DaggerOptionalClassTypeOptionTests_TestExceptionsGeneratorComponent.builder()
                .mainModule(new MainModule(SRC_DIR_PATH))
                .fileModule(new InMemoryFileModule())
                .build();
        exceptionsGeneratorComponent.inject(this);
    }

    @Inject
    public void setFileService(FileService fileService) {
        this.fileService = (InMemoryFileService) fileService;
    }

    @Before
    public void setUp() {
        fileService.reset();
    }

    private static void generateClasses(
            ExceptionsGenerator xgen,
            RootErrorDefinition rootError,
            Optional<OptionalClassType> optionalClassType
    ) {
        if (optionalClassType.isPresent()) {
            xgen.generate(rootError, GenerationOptions.builder().optionalClassType(optionalClassType.get()).build());
        }
        else {
            xgen.generate(rootError);
        }
    }

    private void assert_correctOptionalClassWasWrittenToGeneratedFiles(
            RootErrorDefinition rootError,
            Optional<OptionalClassType> optionalClassType
    ) {
        try {
            //generate for testing compilation
            generateClasses(generator(), rootError, optionalClassType);

            //verify correct Optional class was written
            generateClasses(exceptionsGeneratorComponent.generator(), rootError, optionalClassType);
            assertThat(fileService.files()).have(new DoesNotContainNonSelectedOptionalTypes(optionalClassType));
            assertThat(fileService.files()).haveAtLeastOne(new ContainsSelectedOptionalType(optionalClassType));
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void assert_correctOptionalClassIsUsed(Optional<OptionalClassType> optionalClassType, String namespace) {
        try {
            setUp();
            String basePackage = "com.rodrigodev.xgen4j.test.generation_options." + namespace;
            // @formatter:off
            assert_correctOptionalClassWasWrittenToGeneratedFiles(rootError("Root").errors(
                    commonError("C1").errors(
                            error("C2").errors(
                                    error("C3_1").description("Message for C3_1 error."),
                                    error("C3_2").description("{param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                    error("C3_3").description(TestMessageGeneratorObject.class, "generator")
                            )
                    ),
                    error("E1").errors(
                            error("E2").errors(
                                    error("E3_1").description("Message for E3_1 error."),
                                    error("E3_2").description("{param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                    error("E3_3").description(TestMessageGeneratorObject.class, "generator")
                            )
                    )
            ).basePackage(basePackage).build(), optionalClassType);
            // @formatter:on

            //Next code should not throw exception
            assertThatErrorAndExceptionClassExist(basePackage, "Root");
            assertThatErrorAndExceptionClassExist(basePackage, "c1.C1");
            assertThatErrorAndExceptionClassExist(basePackage, "c1.c2.C2");
            assertThatErrorAndExceptionClassExist(basePackage, "c1.c2.c3_1.C3_1");
            assertThatErrorAndExceptionClassExist(basePackage, "c1.c2.c3_2.C3_2");
            assertThatErrorAndExceptionClassExist(basePackage, "c1.c2.c3_3.C3_3");
            assertThatErrorAndExceptionClassExist(basePackage, "e1.E1");
            assertThatErrorAndExceptionClassExist(basePackage, "e1.e2.E2");
            assertThatErrorAndExceptionClassExist(basePackage, "e1.e2.e3_1.E3_1");
            assertThatErrorAndExceptionClassExist(basePackage, "e1.e2.e3_2.E3_2");
            assertThatErrorAndExceptionClassExist(basePackage, "e1.e2.e3_3.E3_3");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void correctOptionalClassIsUsedForCorrespondingOption() {
        // @formatter:off
        assert_correctOptionalClassIsUsed(Optional.empty(), "java8OptionalClassIsUsedWhenNoOptionIsSet");
        assert_correctOptionalClassIsUsed(Optional.of(OptionalClassType.JAVA_8), "java8OptionalClassIsUsedWhenCorrespondingOptionIsSet");
        assert_correctOptionalClassIsUsed(Optional.of(OptionalClassType.GUAVA), "guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet");
        assert_correctOptionalClassIsUsed(Optional.of(OptionalClassType.CUSTOM), "customOptionalClassIsUsedWhenCorrespondingOptionIsSet");
        // @formatter:on
    }

    private abstract class SelectedOptionalCondition extends Condition<StringBuffer> {

        protected TestOptionalClassType selectedOptionalClassType;

        public SelectedOptionalCondition(Optional<OptionalClassType> selectedOptionalClassType) {
            this.selectedOptionalClassType = TestOptionalClassType.from(selectedOptionalClassType);
        }

        @Override
        abstract public boolean matches(StringBuffer file);
    }

    private class ContainsSelectedOptionalType extends SelectedOptionalCondition {

        public ContainsSelectedOptionalType(Optional<OptionalClassType> selectedOptionalClassType) {
            super(selectedOptionalClassType);
        }

        @Override
        public boolean matches(StringBuffer file) {
            return file.toString().contains(selectedOptionalClassType.fullQualifiedName());
        }
    }

    private class DoesNotContainNonSelectedOptionalTypes extends SelectedOptionalCondition {

        public DoesNotContainNonSelectedOptionalTypes(Optional<OptionalClassType> selectedOptionalClassType) {
            super(selectedOptionalClassType);
        }

        @Override
        public boolean matches(StringBuffer file) {
            boolean result = true;
            for (TestOptionalClassType type : TestOptionalClassType.values()) {
                if (type != selectedOptionalClassType) {
                    if (file.toString().contains(type.fullQualifiedName())) {
                        result = false;
                        break;
                    }
                }
            }
            return result;
        }
    }

    private enum TestOptionalClassType {
        JAVA_8(Optional.class),
        GUAVA(com.google.common.base.Optional.class),
        CUSTOM(com.rodrigodev.xgen4j.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.Optional.class);

        private Class<?> type;

        TestOptionalClassType(Class<?> type) {
            this.type = type;
        }

        public String fullQualifiedName() {
            return type.getName();
        }

        public static TestOptionalClassType from(Optional<OptionalClassType> optionalClassType) {
            return valueOf(
                    optionalClassType.isPresent()
                            ? optionalClassType.get().name()
                            : TestOptionalClassType.JAVA_8.name()
            );
        }
    }
}
