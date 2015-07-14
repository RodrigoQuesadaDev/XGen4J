package com.rodrigodev.xgen4j.test.throwing;

import com.rodrigodev.xgen4j.test.TestSpecification;
import com.rodrigodev.xgen4j.test.common.doubles.error.message.TestMessageGeneratorObject;
import com.rodrigodev.xgen4j.test.common.doubles.error.message.TestObject;
import com.rodrigodev.xgen4j.test.throwing.RootException.ExceptionType;
import com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_1.C3_1Error;
import com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_1.C3_1Exception;
import com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_2.C3_2Error;
import com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_2.C3_2Exception;
import com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_3.C3_3Error;
import com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_3.C3_3Exception;
import com.rodrigodev.xgen4j.test.throwing.e1.E1Exception;
import com.rodrigodev.xgen4j.test.throwing.e1.e2.E2Exception;
import com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_1.E3_1Error;
import com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_1.E3_1Exception;
import com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_2.E3_2Error;
import com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_2.E3_2Exception;
import com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_3.E3_3Error;
import com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_3.E3_3Exception;
import lombok.Value;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Test;

import java.io.IOException;

import static com.rodrigodev.xgen4j.model.error.configuration.ErrorConfiguration.*;
import static com.rodrigodev.xgen4j.model.error.configuration.definition.ParameterDefinition.p;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 03/07/15.
 */
public class ThrowTests extends TestSpecification {

    public ThrowTests() {
        generateErrorsForThrowTests();
    }

    private void generateErrorsForThrowTests() {
        // @formatter:off
        generator().generate(rootError("Root").errors(
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
        ).basePackage("com.rodrigodev.xgen4j.test.throwing").build());
        // @formatter:on
    }

    @Test
    public void errorsAreAbleToThrowCorrespondingExceptions() {

        // @formatter:off
        assertThatThrownBy(C3_1Error::throwException)
                .isInstanceOf(C3_1Exception.class);
        assertThatThrownBy(() -> C3_1Error.throwException(new NullPointerException()))
                .isInstanceOf(C3_1Exception.class);

        assertThatThrownBy(() -> C3_2Error.throwException("ABCDE", 1, new TestObject()))
                .isInstanceOf(C3_2Exception.class);
        assertThatThrownBy(() -> C3_2Error.throwException("ABCDE", 1, new TestObject(), new NullPointerException()))
                .isInstanceOf(C3_2Exception.class);

        assertThatThrownBy(() -> C3_3Error.throwException(new TestMessageGeneratorObject("ABCDE", 1)))
                .isInstanceOf(C3_3Exception.class);
        assertThatThrownBy(() -> C3_3Error.throwException(new TestMessageGeneratorObject("ABCDE", 1), new NullPointerException()))
                .isInstanceOf(C3_3Exception.class);

        assertThatThrownBy(E3_1Error::throwException)
                .isInstanceOf(E3_1Exception.class);
        assertThatThrownBy(E3_1Error::throwException)
                .isInstanceOf(E3_1Exception.class);

        assertThatThrownBy(() -> E3_2Error.throwException("ABCDE", 1, new TestObject()))
                .isInstanceOf(E3_2Exception.class);
        assertThatThrownBy(() -> E3_2Error.throwException("ABCDE", 1, new TestObject(), new NullPointerException()))
                .isInstanceOf(E3_2Exception.class);

        assertThatThrownBy(() -> E3_3Error.throwException(new TestMessageGeneratorObject("ABCDE", 1)))
                .isInstanceOf(E3_3Exception.class);
        assertThatThrownBy(() -> E3_3Error.throwException(new TestMessageGeneratorObject("ABCDE", 1), new NullPointerException()))
                .isInstanceOf(E3_3Exception.class);
        // @formatter:on
    }

    private void assert_commonErrorsCanThrowOtherExceptionTypes(
            ThrowingCallable throwExceptionMethodCall,
            Class<? extends RootException> expectedExceptionClass
    ) {
        assertThatThrownBy(throwExceptionMethodCall)
                .isInstanceOf(expectedExceptionClass);
    }

    private void assert_commonErrorsCanThrowOtherExceptionTypes1(
            ExceptionType exceptionType, Class<? extends RootException> expectedExceptionClass
    ) {
        assert_commonErrorsCanThrowOtherExceptionTypes(
                () -> C3_1Error.throwException(exceptionType), expectedExceptionClass
        );
        assert_commonErrorsCanThrowOtherExceptionTypes(
                () -> C3_1Error.throwException(exceptionType, new NullPointerException()), expectedExceptionClass
        );
    }

    private void assert_commonErrorsCanThrowOtherExceptionTypes2(
            ExceptionType exceptionType, Class<? extends RootException> expectedExceptionClass
    ) {
        assert_commonErrorsCanThrowOtherExceptionTypes(
                () -> C3_2Error.throwException(exceptionType, "ABCDE", 1, new TestObject()),
                expectedExceptionClass
        );
        assert_commonErrorsCanThrowOtherExceptionTypes(
                () -> C3_2Error.throwException(exceptionType, "ABCDE", 1, new TestObject(), new NullPointerException()),
                expectedExceptionClass
        );
    }

    private void assert_commonErrorsCanThrowOtherExceptionTypes3(
            ExceptionType exceptionType, Class<? extends RootException> expectedExceptionClass
    ) {
        assert_commonErrorsCanThrowOtherExceptionTypes(
                () -> C3_3Error.throwException(
                        exceptionType,
                        new TestMessageGeneratorObject("ABCDE", 1)
                ),
                expectedExceptionClass
        );
        assert_commonErrorsCanThrowOtherExceptionTypes(
                () -> C3_3Error.throwException(
                        exceptionType,
                        new TestMessageGeneratorObject("ABCDE", 1),
                        new NullPointerException()
                ),
                expectedExceptionClass
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
                new Argument(E3_1Exception.TYPE, E3_1Exception.class),
                new Argument(E3_2Exception.TYPE, E3_2Exception.class),
                new Argument(E3_3Exception.TYPE, E3_3Exception.class)
        };

        for (Argument argument : arguments) {
            // @formatter:off
            assert_commonErrorsCanThrowOtherExceptionTypes1(argument.exceptionType, argument.expectedExceptionClass);
            assert_commonErrorsCanThrowOtherExceptionTypes2(argument.exceptionType, argument.expectedExceptionClass);
            assert_commonErrorsCanThrowOtherExceptionTypes3(argument.exceptionType, argument.expectedExceptionClass);
            // @formatter:on
        }
    }

    private void assert_generatedThrowExceptionMethodChecksParamIsNoNull(
            ThrowingCallable methodCall, String paramName
    ) {
        assertThatThrownBy(methodCall).isInstanceOf(NullPointerException.class).hasMessage(paramName);
    }

    @Test
    public void generatedThrowExceptionMethodChecksParamsAreNoNull() {

        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_1.C3_1Error
                        .throwException((ExceptionType) null)
                , "exceptionType"
        );
        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_1.C3_1Error
                        .throwException(null, new NullPointerException())
                , "exceptionType"
        );
        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_2.C3_2Error
                        .throwException(null, "abc", 1, new TestObject())
                , "exceptionType"
        );
        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_2.C3_2Error
                        .throwException(null, "abc", 1, new TestObject(), new NullPointerException())
                , "exceptionType"
        );
        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_3.C3_3Error
                        .throwException(null, new TestMessageGeneratorObject("abc", 1))
                , "exceptionType"
        );
        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_3.C3_3Error
                        .throwException(null, new TestMessageGeneratorObject("abc", 1), new NullPointerException())
                , "exceptionType"
        );

        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_2.E3_2Error
                        .throwException(null, 1, new TestObject())
                , "param1"
        );
        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_2.E3_2Error
                        .throwException(null, 1, new TestObject(), new NullPointerException())
                , "param1"
        );
        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_2.C3_2Error
                        .throwException(E1Exception.TYPE, null, 1, new TestObject())
                , "param1"
        );
        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_2.C3_2Error
                        .throwException(E1Exception.TYPE, null, 1, new TestObject(), new NullPointerException())
                , "param1"
        );
        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_2.E3_2Error
                        .throwException("abc", 1, null)
                , "param3"
        );
        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_2.E3_2Error
                        .throwException("abc", 1, null, new NullPointerException())
                , "param3"
        );
        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_2.C3_2Error
                        .throwException(E1Exception.TYPE, "abc", 1, null)
                , "param3"
        );
        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_2.C3_2Error
                        .throwException(E1Exception.TYPE, "abc", 1, null, new NullPointerException())
                , "param3"
        );

        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_3.E3_3Error
                        .throwException(null)
                , "generator"
        );
        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_3.E3_3Error
                        .throwException(null, new NullPointerException())
                , "generator"
        );
        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_3.C3_3Error
                        .throwException(E1Exception.TYPE, null)
                , "generator"
        );
        assert_generatedThrowExceptionMethodChecksParamIsNoNull(
                () -> com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_3.C3_3Error
                        .throwException(E1Exception.TYPE, null, new NullPointerException())
                , "generator"
        );
    }

    @Test
    public void errorsAreAbleToThrowExceptionsSpecifyingACause() {
        Throwable expectedCause = new IOException("A message goes here.");

        // @formatter:off
        assertThatThrownBy(() -> E3_1Error.throwException(expectedCause))
                .hasCause(expectedCause);
        assertThatThrownBy(() -> C3_1Error.throwException(E1Exception.TYPE, expectedCause))
                .hasCause(expectedCause);
        assertThatThrownBy(() -> E3_2Error.throwException("abc", 1, new TestObject(), expectedCause))
                .hasCause(expectedCause);
        assertThatThrownBy(() -> C3_2Error.throwException(E1Exception.TYPE, "abc", 1, new TestObject(), expectedCause))
                .hasCause(expectedCause);
        assertThatThrownBy(() -> E3_3Error.throwException(new TestMessageGeneratorObject("abc", 1), expectedCause))
                .hasCause(expectedCause);
        assertThatThrownBy(() -> C3_3Error.throwException(E1Exception.TYPE, new TestMessageGeneratorObject("abc", 1), expectedCause))
                .hasCause(expectedCause);
        // @formatter:on
    }
}
