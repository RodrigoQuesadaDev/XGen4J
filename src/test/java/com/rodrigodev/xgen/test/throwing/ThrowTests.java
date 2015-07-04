package com.rodrigodev.xgen.test.throwing;

import com.rodrigodev.xgen.ExceptionsGenerator;
import com.rodrigodev.xgen.test.throwing.RootException.ExceptionType;
import com.rodrigodev.xgen.test.throwing.c1.c2.c3_1.C3_1Error;
import com.rodrigodev.xgen.test.throwing.c1.c2.c3_1.C3_1Exception;
import com.rodrigodev.xgen.test.throwing.c1.c2.c3_2.C3_2Error;
import com.rodrigodev.xgen.test.throwing.c1.c2.c3_3.C3_3Error;
import com.rodrigodev.xgen.test.throwing.e1.E1Exception;
import com.rodrigodev.xgen.test.throwing.e1.e2.E2Exception;
import com.rodrigodev.xgen.test.throwing.e1.e2.e3.E3Error;
import com.rodrigodev.xgen.test.throwing.e1.e2.e3.E3Exception;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Test;

import static com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration.*;
import static com.rodrigodev.xgen.model.error.configuration.ParameterDefinition.p;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 03/07/15.
 */
public class ThrowTests {

    public ThrowTests() {
        generateErrorsForThrowTests();
    }

    public static class TestObject {
        @Override
        public String toString() {
            return "A test object.";
        }
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

    private void generateErrorsForThrowTests() {

        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");

        // @formatter:off
        xgen.generate(rootError("Root").errors(
                commonError("C1").errors(
                        error("C2").errors(
                                error("C3_1").description("Message for C3_1 error."),
                                error("C3_2").description("{param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                error("C3_3").description(TestMessageGeneratorObject.class, "generator")
                        )
                ),
                error("E1").errors(
                        error("E2").errors(
                                error("E3").description("Message for E3 error.")
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.throwing").build());
        // @formatter:on
    }

    @Test
    public void errorsAreAbleToThrowCorrespondingExceptionsWithCorrectMessage() {

        assertThatThrownBy(() -> C3_1Error.throwException())
                .isInstanceOf(C3_1Exception.class).hasMessage("Message for C3_1 error.");

        assertThatThrownBy(() -> E3Error.throwException())
                .isInstanceOf(E3Exception.class).hasMessage("Message for E3 error.");
    }

    private void assert_commonErrorsCanThrowOtherExceptionsUsingOwnMessage(
            ThrowingCallable throwExceptionMethodCall,
            Class<? extends RootException> expectedExceptionClass,
            String expectedMessage
    ) {
        assertThatThrownBy(throwExceptionMethodCall)
                .isInstanceOf(expectedExceptionClass)
                .hasMessage(expectedMessage);
    }

    private void assert_commonErrorsCanThrowOtherExceptionsUsingOwnMessage1(
            ExceptionType exceptionType, Class<? extends RootException> expectedExceptionClass
    ) {
        assert_commonErrorsCanThrowOtherExceptionsUsingOwnMessage(
                () -> C3_1Error.throwException(exceptionType), expectedExceptionClass, "Message for C3_1 error."
        );
    }

    private void assert_commonErrorsCanThrowOtherExceptionsUsingOwnMessage2(
            ExceptionType exceptionType, Class<? extends RootException> expectedExceptionClass
    ) {
        assert_commonErrorsCanThrowOtherExceptionsUsingOwnMessage(
                () -> C3_2Error.throwException(exceptionType, "ABCDE", 123, new TestObject()),
                expectedExceptionClass,
                "{param1: 'ABCDE', param2: 123, param3: 'A test object.'}"
        );
    }

    private void assert_commonErrorsCanThrowOtherExceptionsUsingOwnMessage3(
            ExceptionType exceptionType, Class<? extends RootException> expectedExceptionClass
    ) {
        assert_commonErrorsCanThrowOtherExceptionsUsingOwnMessage(
                () -> C3_3Error.throwException(
                        exceptionType,
                        new TestMessageGeneratorObject("Some text goes here.", 123)
                ),
                expectedExceptionClass,
                "Custom Message: {value1: 'Some text goes here.', value2: 123}"
        );
    }

    @Test
    public void commonErrorsCanThrowOtherExceptionsUsingOwnMessage() {
        @Value
        class Argument {
            ExceptionType exceptionType;
            Class<? extends RootException> expectedExceptionClass;
        }
        Argument[] arguments = {
                new Argument(E1Exception.TYPE, E1Exception.class),
                new Argument(E2Exception.TYPE, E2Exception.class),
                new Argument(E3Exception.TYPE, E3Exception.class)
        };

        for (Argument argument : arguments) {
            // @formatter:off
            assert_commonErrorsCanThrowOtherExceptionsUsingOwnMessage1(argument.exceptionType, argument.expectedExceptionClass);
            assert_commonErrorsCanThrowOtherExceptionsUsingOwnMessage2(argument.exceptionType, argument.expectedExceptionClass);
            assert_commonErrorsCanThrowOtherExceptionsUsingOwnMessage3(argument.exceptionType, argument.expectedExceptionClass);
            // @formatter:on
        }
    }
}
