package com.rodrigodev.xgen.test.message;

import com.rodrigodev.xgen.ExceptionsGenerator;
import com.rodrigodev.xgen.model.error.configuration.ErrorDefinition.ErrorDefinitionBuilder;
import com.rodrigodev.xgen.test.message.descriptionWithNoParamsIsAllowed.e1.e2.e3.E3Error;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Test;

import java.util.function.Supplier;

import static com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration.error;
import static com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration.rootError;
import static com.rodrigodev.xgen.model.error.configuration.ParameterDefinition.p;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
public class MessageTests {

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
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
        xgen.generate(rootError("Root").errors(
                error("E1").errors(
                        error("E2").errors(
                                error("E3").description("Some description.")
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.message.descriptionWithNoParamsIsAllowed").build());

        assertThatThrownBy(E3Error::throwException)
                .hasMessage("Some description.");
    }

    public static class TestObject {
        @Override
        public String toString() {
            return "A test object.";
        }
    }

    @Test
    public void descriptionWithMultipleParametersIsAllowed() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
        // @formatter:off
        xgen.generate(rootError("Root").errors(
                error("E1").errors(
                        error("E2").errors(
                                error("E3").description("{param1: '%s', param2: %.3f, param3: '%s'}", p(String.class, "param1"), p(Double.class, "param2"), p(TestObject.class, "param3"))
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.message.descriptionWithMultipleParametersIsAllowed").build());
        // @formatter:on

        assertThatThrownBy(
                () -> com.rodrigodev.xgen.test.message.descriptionWithMultipleParametersIsAllowed.e1.e2.e3.E3Error
                        .throwException("Abcde", 123.456, new TestObject())
        ).hasMessage("{param1: 'Abcde', param2: 123.456, param3: 'A test object.'}");
    }

    @Value
    @NonFinal
    public static class TestMessageGeneratorObject {

        private String value1;
        private int value2;

        public String message() {
            return String.format("Custom Message: {value1: '%s', value2: %d}", value1, value2);
        }
    }

    @Test
    public void descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
        // @formatter:off
        xgen.generate(rootError("Root").errors(
                error("E1").errors(
                        error("E2").errors(
                                error("E3").description(TestMessageGeneratorObject.class, "generator")
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed").build());
        // @formatter:on

        assertThatThrownBy(
                () -> com.rodrigodev.xgen.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed.e1.e2.e3.E3Error
                        .throwException(new TestMessageGeneratorObject("Some text goes here.", 123))
        ).hasMessage("Custom Message: {value1: 'Some text goes here.', value2: 123}");
    }

    public static class TestMessageGeneratorObjectChild extends TestMessageGeneratorObject {

        public TestMessageGeneratorObjectChild(String value1, int value2) {
            super(value1, value2);
        }
    }

    @Test
    public void descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
        // @formatter:off
        xgen.generate(rootError("Root").errors(
                error("E1").errors(
                        error("E2").errors(
                                error("E3").description(TestMessageGeneratorObjectChild.class, "generator")
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation").build());
        // @formatter:on

        assertThatThrownBy(
                () -> com.rodrigodev.xgen.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.e1.e2.e3.E3Error
                        .throwException(new TestMessageGeneratorObjectChild("Some text goes here.", 123))
        ).hasMessage("Custom Message: {value1: 'Some text goes here.', value2: 123}");
    }

    @Value
    public static class TestBadMessageGeneratorObject {

        private String value1;
        private int value2;
    }

    @Test
    public void customObjectThatGeneratesTheMessageForDescriptionMustHavePublicMessageMethod() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
        assertThatThrownBy(
                // @formatter:off
                () -> xgen.generate(rootError("Root").errors(
                        error("E1").errors(
                                error("E2").errors(
                                        error("E3").description(TestBadMessageGeneratorObject.class, "generator")
                                )
                        )
                ).basePackage("com.rodrigodev.xgen.test.message.customObjectThatGeneratesTheMessageForDescriptionMustHavePublicMessageMethod").build())
                // @formatter:on
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Custom message generator doesn't implement a non-private 'message' method.");
    }

    public void assert_onlyTextBasedDescriptionOrCustomMessageGeneratorCanBeSpecifyNotBoth(
            Supplier<ErrorDefinitionBuilder> errorMethodCall
    ) {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
        assertThatThrownBy(
                // @formatter:off
                () -> xgen.generate(rootError("Root").errors(
                        error("E1").errors(
                                error("E2").errors(
                                        errorMethodCall.get()
                                )
                        )
                ).basePackage("com.rodrigodev.xgen.test.message.onlyTextBasedDescriptionOrCustomMessageGeneratorCanBeSpecifyNotBoth").build())
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

    private void assert_generatedThrowExceptionMethodChecksParamIsNoNull(
            ThrowingCallable methodCall, String paramName
    ) {
        assertThatThrownBy(methodCall).isInstanceOf(NullPointerException.class).hasMessage(paramName);
    }

    @Test
    public void generatedThrowExceptionMethodChecksParamsAreNoNull() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
        // @formatter:off
        xgen.generate(rootError("Root").errors(
                error("E1").errors(
                        error("E2").errors(
                                error("E3_1").description("{param1: '%s', param2: %.3f, param3: '%s'}", p(String.class, "param1"), p(Double.class, "param2"), p(TestObject.class, "param3")),
                                error("E3_2").description(TestMessageGeneratorObject.class, "generator")
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.message.generatedThrowExceptionMethodChecksParamsAreNoNull").build());
        // @formatter:on

        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen.test.message.generatedThrowExceptionMethodChecksParamsAreNoNull.e1.e2.e3_1.E3_1Error
                        .throwException(null, 1.0, new TestObject())
                , "param1"
        );
        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen.test.message.generatedThrowExceptionMethodChecksParamsAreNoNull.e1.e2.e3_1.E3_1Error
                        .throwException("abc", null, new TestObject())
                , "param2"
        );
        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen.test.message.generatedThrowExceptionMethodChecksParamsAreNoNull.e1.e2.e3_1.E3_1Error
                        .throwException("abc", 1.0, null)
                , "param3"
        );
        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen.test.message.generatedThrowExceptionMethodChecksParamsAreNoNull.e1.e2.e3_2.E3_2Error
                        .throwException(null)
                , "generator"
        );
    }
}
