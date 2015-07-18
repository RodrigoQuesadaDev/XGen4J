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

package com.rodrigodev.xgen4j.test.message;

import com.rodrigodev.xgen4j.model.error.configuration.definition.ErrorDefinition.ErrorDefinitionBuilder;
import com.rodrigodev.xgen4j.test.TestSpecification;
import com.rodrigodev.xgen4j.test.common.doubles.error.message.TestMessageGeneratorObject;
import com.rodrigodev.xgen4j.test.common.doubles.error.message.TestObject;
import com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.c1.c2.c3.C3Error;
import com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.e1.e2.e3.E3Error;
import com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.e1.e2.e3.E3Exception;
import lombok.Value;
import org.junit.Test;

import java.util.function.Supplier;

import static com.rodrigodev.xgen4j.model.error.configuration.ErrorConfiguration.*;
import static com.rodrigodev.xgen4j.model.error.configuration.definition.ParameterDefinition.p;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
public class MessageTests extends TestSpecification {

    @Test
    public void descriptionMustNotBeEmpty() {
        assertThatThrownBy(
                () -> {
                    rootError("Root").errors(
                            error("E1").errors(
                                    error("E2").errors(
                                            error("E3").description("")
                                    )
                            )
                    );
                }
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("descriptionFormat is empty");
    }

    @Test
    public void descriptionWithNoParamsIsAllowed() {
        generator().generate(rootError("Root").errors(
                commonError("C1").errors(
                        error("C2").errors(
                                error("C3").description("Some description.")
                        )
                ),
                error("E1").errors(
                        error("E2").errors(
                                error("E3").description("Some description.")
                        )
                )
        ).basePackage("com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed").build());

        assertThatThrownBy(E3Error::throwException)
                .hasMessage("Some description.");
        assertThatThrownBy(() -> C3Error.throwException(E3Exception.TYPE))
                .hasMessage("Some description.");
        assertThatThrownBy(() -> E3Error.throwException(new NullPointerException()))
                .hasMessage("Some description.");
    }

    @Test
    public void descriptionWithMultipleParametersIsAllowed() {
        // @formatter:off
        generator().generate(rootError("Root").errors(
                commonError("C1").errors(
                        error("C2").errors(
                                error("C3").description("{param1: '%s', param2: %.3f, param3: '%s'}", p(String.class, "param1"), p(Double.class, "param2"), p(TestObject.class, "param3"))
                        )
                ),
                error("E1").errors(
                        error("E2").errors(
                                error("E3").description("{param1: '%s', param2: %.3f, param3: '%s'}", p(String.class, "param1"), p(Double.class, "param2"), p(TestObject.class, "param3"))
                        )
                )
        ).basePackage("com.rodrigodev.xgen4j.test.message.descriptionWithMultipleParametersIsAllowed").build());
        // @formatter:on
        String expectedMessage = "{param1: 'Abcde', param2: 123.456, param3: 'A test object.'}";

        assertThatThrownBy(
                () -> com.rodrigodev.xgen4j.test.message.descriptionWithMultipleParametersIsAllowed.e1.e2.e3.E3Error
                        .throwException("Abcde", 123.456, new TestObject())
        ).hasMessage(expectedMessage);
        assertThatThrownBy(
                () -> com.rodrigodev.xgen4j.test.message.descriptionWithMultipleParametersIsAllowed.c1.c2.c3.C3Error
                        .throwException(
                                com.rodrigodev.xgen4j.test.message.descriptionWithMultipleParametersIsAllowed.e1.e2.e3.E3Exception.TYPE,
                                "Abcde", 123.456, new TestObject()
                        )
        ).hasMessage(expectedMessage);
        assertThatThrownBy(
                () -> com.rodrigodev.xgen4j.test.message.descriptionWithMultipleParametersIsAllowed.e1.e2.e3.E3Error
                        .throwException("Abcde", 123.456, new TestObject(), new NullPointerException())
        ).hasMessage(expectedMessage);
    }

    @Test
    public void descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed() {
        // @formatter:off
        generator().generate(rootError("Root").errors(
                commonError("C1").errors(
                        error("C2").errors(
                                error("C3").description(TestMessageGeneratorObject.class, "generator")
                        )
                ),
                error("E1").errors(
                        error("E2").errors(
                                error("E3").description(TestMessageGeneratorObject.class, "generator")
                        )
                )
        ).basePackage("com.rodrigodev.xgen4j.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed").build());
        // @formatter:on
        String expectedMessage = "Custom Message: {value1: 'Some text goes here.', value2: 123}";

        assertThatThrownBy(
                () -> com.rodrigodev.xgen4j.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed.e1.e2.e3.E3Error
                        .throwException(new TestMessageGeneratorObject("Some text goes here.", 123))
        ).hasMessage(expectedMessage);
        assertThatThrownBy(
                () -> com.rodrigodev.xgen4j.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed.c1.c2.c3.C3Error
                        .throwException(
                                com.rodrigodev.xgen4j.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed.e1.e2.e3.E3Exception.TYPE,
                                new TestMessageGeneratorObject("Some text goes here.", 123)
                        )
        ).hasMessage(expectedMessage);
        assertThatThrownBy(
                () -> com.rodrigodev.xgen4j.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed.e1.e2.e3.E3Error
                        .throwException(
                                new TestMessageGeneratorObject("Some text goes here.", 123), new NullPointerException()
                        )
        ).hasMessage(expectedMessage);
    }

    public static class TestMessageGeneratorObjectChild extends TestMessageGeneratorObject {

        public TestMessageGeneratorObjectChild(String value1, int value2) {
            super(value1, value2);
        }
    }

    @Test
    public void descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation() {
        // @formatter:off
        generator().generate(rootError("Root").errors(
                commonError("C1").errors(
                        error("C2").errors(
                                error("C3").description(TestMessageGeneratorObjectChild.class, "generator")
                        )
                ),
                error("E1").errors(
                        error("E2").errors(
                                error("E3").description(TestMessageGeneratorObjectChild.class, "generator")
                        )
                )
        ).basePackage("com.rodrigodev.xgen4j.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation").build());
        // @formatter:on
        String expectedMessage = "Custom Message: {value1: 'Some text goes here.', value2: 123}";

        assertThatThrownBy(
                () -> com.rodrigodev.xgen4j.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.e1.e2.e3.E3Error
                        .throwException(new TestMessageGeneratorObjectChild("Some text goes here.", 123))
        ).hasMessage(expectedMessage);
        assertThatThrownBy(
                () -> com.rodrigodev.xgen4j.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.c1.c2.c3.C3Error
                        .throwException(
                                com.rodrigodev.xgen4j.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.e1.e2.e3.E3Exception.TYPE,
                                new TestMessageGeneratorObjectChild("Some text goes here.", 123)
                        )
        ).hasMessage(expectedMessage);
        assertThatThrownBy(
                () -> com.rodrigodev.xgen4j.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.e1.e2.e3.E3Error
                        .throwException(
                                new TestMessageGeneratorObjectChild("Some text goes here.", 123),
                                new NullPointerException()
                        )
        ).hasMessage(expectedMessage);
    }

    @Value
    public static class TestBadMessageGeneratorObject {

        private String value1;
        private int value2;
    }

    @Test
    public void customObjectThatGeneratesTheMessageForDescriptionMustHavePublicMessageMethod() {
        assertThatThrownBy(
                // @formatter:off
                () -> generator().generate(rootError("Root").errors(
                        error("E1").errors(
                                error("E2").errors(
                                        error("E3").description(TestBadMessageGeneratorObject.class, "generator")
                                )
                        )
                ).basePackage("com.rodrigodev.xgen4j.test.message.customObjectThatGeneratesTheMessageForDescriptionMustHavePublicMessageMethod").build())
                // @formatter:on
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Custom message generator doesn't implement a non-private 'message' method.");
    }

    public void assert_onlyTextBasedDescriptionOrCustomMessageGeneratorCanBeSpecifyNotBoth(
            Supplier<ErrorDefinitionBuilder> errorMethodCall
    ) {
        assertThatThrownBy(
                // @formatter:off
                () -> generator().generate(rootError("Root").errors(
                        error("E1").errors(
                                error("E2").errors(
                                        errorMethodCall.get()
                                )
                        )
                ).basePackage("com.rodrigodev.xgen4j.test.message.onlyTextBasedDescriptionOrCustomMessageGeneratorCanBeSpecifyNotBoth").build())
                // @formatter:on
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(
                        "Either specify a text-based description OR a custom message generator for it, but not both.");
    }

    @Test
    public void onlyTextBasedDescriptionOrCustomMessageGeneratorCanBeSpecifyNotBoth() {
        assert_onlyTextBasedDescriptionOrCustomMessageGeneratorCanBeSpecifyNotBoth(
                () -> error("E3").description("ABCDE").description(TestMessageGeneratorObject.class, "generator")
        );
        assert_onlyTextBasedDescriptionOrCustomMessageGeneratorCanBeSpecifyNotBoth(
                () -> error("E3").description(TestMessageGeneratorObject.class, "generator").description("ABCDE")
        );
    }
}
