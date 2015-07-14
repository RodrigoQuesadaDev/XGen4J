package com.rodrigodev.xgen.test.generation_options;

import com.rodrigodev.xgen.ExceptionsGenerator;
import com.rodrigodev.xgen.GenerationOptions;
import com.rodrigodev.xgen.test.TestSpecification;
import com.rodrigodev.xgen.test.common.doubles.error.message.TestMessageGeneratorObject;
import com.rodrigodev.xgen.test.common.doubles.error.message.TestObject;
import com.rodrigodev.xgen.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.CRootException;
import com.rodrigodev.xgen.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.cc1.cc2.cc3_1.CC3_1Error;
import com.rodrigodev.xgen.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.cc1.cc2.cc3_2.CC3_2Error;
import com.rodrigodev.xgen.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.cc1.cc2.cc3_3.CC3_3Error;
import com.rodrigodev.xgen.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.ce3_1.CE3_1Error;
import com.rodrigodev.xgen.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.ce3_1.CE3_1Exception;
import com.rodrigodev.xgen.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.ce3_2.CE3_2Error;
import com.rodrigodev.xgen.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.ce3_3.CE3_3Error;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.URootException;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.uc1.uc2.uc3_1.UC3_1Error;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.uc1.uc2.uc3_2.UC3_2Error;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.uc1.uc2.uc3_3.UC3_3Error;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.ue1.ue2.ue3_1.UE3_1Error;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.ue1.ue2.ue3_1.UE3_1Exception;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.ue1.ue2.ue3_2.UE3_2Error;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.ue1.ue2.ue3_3.UE3_3Error;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.U2RootException;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2c1.u2c2.u2c3_1.U2C3_1Error;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2c1.u2c2.u2c3_2.U2C3_2Error;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2c1.u2c2.u2c3_3.U2C3_3Error;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_1.U2E3_1Error;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_1.U2E3_1Exception;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_2.U2E3_2Error;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_3.U2E3_3Error;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Test;

import static com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration.*;
import static com.rodrigodev.xgen.model.error.configuration.definition.ParameterDefinition.p;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 12/07/15.
 */
public class CheckedExceptionsOptionTests extends TestSpecification {

    private void assert_thrownExceptionIsUnchecked(
            ThrowingCallable throwingCallable, Class<? extends Exception> rootExceptionType
    ) {
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(rootExceptionType)
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSetOrIsSetAsFalse() {
        ExceptionsGenerator xgen = generator();
        // @formatter:off
        xgen.generate(rootError("URoot").errors(
                commonError("UC1").errors(
                        error("UC2").errors(
                                error("UC3_1").description("Message for C3_1 error."),
                                error("UC3_2").description("{param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                error("UC3_3").description(TestMessageGeneratorObject.class, "generator")
                        )
                ),
                error("UE1").errors(
                        error("UE2").errors(
                                error("UE3_1").description("Message for E3_1 error."),
                                error("UE3_2").description("{param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                error("UE3_3").description(TestMessageGeneratorObject.class, "generator")
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet").build());
        xgen.generate(rootError("U2Root").errors(
                commonError("U2C1").errors(
                        error("U2C2").errors(
                                error("U2C3_1").description("Message for C3_1 error."),
                                error("U2C3_2").description("{param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                error("U2C3_3").description(TestMessageGeneratorObject.class, "generator")
                        )
                ),
                error("U2E1").errors(
                        error("U2E2").errors(
                                error("U2E3_1").description("Message for E3_1 error."),
                                error("U2E3_2").description("{param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                error("U2E3_3").description(TestMessageGeneratorObject.class, "generator")
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse").build(),
                      GenerationOptions.builder().checkedExceptions(false).build()
        );

        assert_thrownExceptionIsUnchecked(UC3_1Error::throwException, URootException.class);
        assert_thrownExceptionIsUnchecked(() -> UC3_2Error.throwException("abc", 1, new TestObject()), URootException.class);
        assert_thrownExceptionIsUnchecked(() -> UC3_3Error.throwException(new TestMessageGeneratorObject("abc", 1)), URootException.class);
        assert_thrownExceptionIsUnchecked(() -> UC3_1Error.throwException(UE3_1Exception.TYPE), URootException.class);
        assert_thrownExceptionIsUnchecked(() -> UC3_2Error.throwException(UE3_1Exception.TYPE, "abc", 1, new TestObject()), URootException.class);
        assert_thrownExceptionIsUnchecked(() -> UC3_3Error.throwException(UE3_1Exception.TYPE, new TestMessageGeneratorObject("abc", 1)), URootException.class);
        assert_thrownExceptionIsUnchecked(UE3_1Error::throwException, URootException.class);
        assert_thrownExceptionIsUnchecked(() -> UE3_2Error.throwException("abc", 1, new TestObject()), URootException.class);
        assert_thrownExceptionIsUnchecked(() -> UE3_3Error.throwException(new TestMessageGeneratorObject("abc", 1)), URootException.class);

        assert_thrownExceptionIsUnchecked(() -> UC3_1Error.throwException(new NullPointerException()), URootException.class);
        assert_thrownExceptionIsUnchecked(() -> UC3_2Error.throwException("abc", 1, new TestObject(), new NullPointerException()), URootException.class);
        assert_thrownExceptionIsUnchecked(() -> UC3_3Error.throwException(new TestMessageGeneratorObject("abc", 1), new NullPointerException()), URootException.class);
        assert_thrownExceptionIsUnchecked(() -> UC3_1Error.throwException(UE3_1Exception.TYPE, new NullPointerException()), URootException.class);
        assert_thrownExceptionIsUnchecked(() -> UC3_2Error.throwException(UE3_1Exception.TYPE, "abc", 1, new TestObject(), new NullPointerException()), URootException.class);
        assert_thrownExceptionIsUnchecked(() -> UC3_3Error.throwException(UE3_1Exception.TYPE, new TestMessageGeneratorObject("abc", 1), new NullPointerException()), URootException.class);
        assert_thrownExceptionIsUnchecked(() -> UE3_1Error.throwException(new NullPointerException()), URootException.class);
        assert_thrownExceptionIsUnchecked(() -> UE3_2Error.throwException("abc", 1, new TestObject(), new NullPointerException()), URootException.class);
        assert_thrownExceptionIsUnchecked(() -> UE3_3Error.throwException(new TestMessageGeneratorObject("abc", 1), new NullPointerException()), URootException.class);

        assert_thrownExceptionIsUnchecked(U2C3_1Error::throwException, U2RootException.class);
        assert_thrownExceptionIsUnchecked(() -> U2C3_2Error.throwException("abc", 1, new TestObject()), U2RootException.class);
        assert_thrownExceptionIsUnchecked(() -> U2C3_3Error.throwException(new TestMessageGeneratorObject("abc", 1)), U2RootException.class);
        assert_thrownExceptionIsUnchecked(() -> U2C3_1Error.throwException(U2E3_1Exception.TYPE), U2RootException.class);
        assert_thrownExceptionIsUnchecked(() -> U2C3_2Error.throwException(U2E3_1Exception.TYPE, "abc", 1, new TestObject()), U2RootException.class);
        assert_thrownExceptionIsUnchecked(() -> U2C3_3Error.throwException(U2E3_1Exception.TYPE, new TestMessageGeneratorObject("abc", 1)), U2RootException.class);
        assert_thrownExceptionIsUnchecked(U2E3_1Error::throwException, U2RootException.class);
        assert_thrownExceptionIsUnchecked(() -> U2E3_2Error.throwException("abc", 1, new TestObject()), U2RootException.class);
        assert_thrownExceptionIsUnchecked(() -> U2E3_3Error.throwException(new TestMessageGeneratorObject("abc", 1)), U2RootException.class);

        assert_thrownExceptionIsUnchecked(() -> U2C3_1Error.throwException(new NullPointerException()), U2RootException.class);
        assert_thrownExceptionIsUnchecked(() -> U2C3_2Error.throwException("abc", 1, new TestObject(), new NullPointerException()), U2RootException.class);
        assert_thrownExceptionIsUnchecked(() -> U2C3_3Error.throwException(new TestMessageGeneratorObject("abc", 1), new NullPointerException()), U2RootException.class);
        assert_thrownExceptionIsUnchecked(() -> U2C3_1Error.throwException(U2E3_1Exception.TYPE, new NullPointerException()), U2RootException.class);
        assert_thrownExceptionIsUnchecked(() -> U2C3_2Error.throwException(U2E3_1Exception.TYPE, "abc", 1, new TestObject(), new NullPointerException()), U2RootException.class);
        assert_thrownExceptionIsUnchecked(() -> U2C3_3Error.throwException(U2E3_1Exception.TYPE, new TestMessageGeneratorObject("abc", 1), new NullPointerException()), U2RootException.class);
        assert_thrownExceptionIsUnchecked(() -> U2E3_1Error.throwException(new NullPointerException()), U2RootException.class);
        assert_thrownExceptionIsUnchecked(() -> U2E3_2Error.throwException("abc", 1, new TestObject(), new NullPointerException()), U2RootException.class);
        assert_thrownExceptionIsUnchecked(() -> U2E3_3Error.throwException(new TestMessageGeneratorObject("abc", 1), new NullPointerException()), U2RootException.class);
        // @formatter:on
    }

    private void assert_thrownExceptionIsChecked(
            ThrowingCallable throwingCallable, Class<? extends Exception> rootExceptionType
    ) {
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(rootExceptionType)
                .isInstanceOf(Exception.class)
                .isNotInstanceOf(RuntimeException.class);
    }

    @Test
    public void checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet() {
        // @formatter:off
        generator().generate(rootError("CRoot").errors(
                commonError("CC1").errors(
                        error("CC2").errors(
                                error("CC3_1").description("Message for C3_1 error."),
                                error("CC3_2").description("{param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                error("CC3_3").description(TestMessageGeneratorObject.class, "generator")
                        )
                ),
                error("CE1").errors(
                        error("CE2").errors(
                                error("CE3_1").description("Message for E3_1 error."),
                                error("CE3_2").description("{param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                error("CE3_3").description(TestMessageGeneratorObject.class, "generator")
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet").build(),
                      GenerationOptions.builder().checkedExceptions(true).build()
        );

        assert_thrownExceptionIsChecked(CC3_1Error::throwException, CRootException.class);
        assert_thrownExceptionIsChecked(() -> CC3_2Error.throwException("abc", 1, new TestObject()), CRootException.class);
        assert_thrownExceptionIsChecked(() -> CC3_3Error.throwException(new TestMessageGeneratorObject("abc", 1)), CRootException.class);
        assert_thrownExceptionIsChecked(() -> CC3_1Error.throwException(CE3_1Exception.TYPE), CRootException.class);
        assert_thrownExceptionIsChecked(() -> CC3_2Error.throwException(CE3_1Exception.TYPE, "abc", 1, new TestObject()), CRootException.class);
        assert_thrownExceptionIsChecked(() -> CC3_3Error.throwException(CE3_1Exception.TYPE, new TestMessageGeneratorObject("abc", 1)), CRootException.class);
        assert_thrownExceptionIsChecked(CE3_1Error::throwException, CRootException.class);
        assert_thrownExceptionIsChecked(() -> CE3_2Error.throwException("abc", 1, new TestObject()), CRootException.class);
        assert_thrownExceptionIsChecked(() -> CE3_3Error.throwException(new TestMessageGeneratorObject("abc", 1)), CRootException.class);

        assert_thrownExceptionIsChecked(() -> CC3_1Error.throwException(new NullPointerException()), CRootException.class);
        assert_thrownExceptionIsChecked(() -> CC3_2Error.throwException("abc", 1, new TestObject(), new NullPointerException()), CRootException.class);
        assert_thrownExceptionIsChecked(() -> CC3_3Error.throwException(new TestMessageGeneratorObject("abc", 1), new NullPointerException()), CRootException.class);
        assert_thrownExceptionIsChecked(() -> CC3_1Error.throwException(CE3_1Exception.TYPE, new NullPointerException()), CRootException.class);
        assert_thrownExceptionIsChecked(() -> CC3_2Error.throwException(CE3_1Exception.TYPE, "abc", 1, new TestObject(), new NullPointerException()), CRootException.class);
        assert_thrownExceptionIsChecked(() -> CC3_3Error.throwException(CE3_1Exception.TYPE, new TestMessageGeneratorObject("abc", 1), new NullPointerException()), CRootException.class);
        assert_thrownExceptionIsChecked(() -> CE3_1Error.throwException(new NullPointerException()), CRootException.class);
        assert_thrownExceptionIsChecked(() -> CE3_2Error.throwException("abc", 1, new TestObject(), new NullPointerException()), CRootException.class);
        assert_thrownExceptionIsChecked(() -> CE3_3Error.throwException(new TestMessageGeneratorObject("abc", 1), new NullPointerException()), CRootException.class);
        // @formatter:on
    }
}
