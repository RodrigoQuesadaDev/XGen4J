package com.rodrigodev.xgen4j.test.info_generation;

import com.rodrigodev.xgen4j.test.TestSpecification;
import com.rodrigodev.xgen4j.test.common.assertion.clazz.conditions.MethodNamed;
import com.rodrigodev.xgen4j.test.common.doubles.error.message.TestObject;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.*;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.ErrorInfo.CustomMessageGeneratorErrorDescription;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.ErrorInfo.ErrorDescription;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.ErrorInfo.PlainTextErrorDescription;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.c1.C1Error;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.c1.C1Exception;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.c1.c2.C2Error;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.c1.c2.C2Exception;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.c1.c2.c3_1.C3_1Error;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.c1.c2.c3_1.C3_1Exception;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.c1.c2.c3_2.C3_2Error;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.c1.c2.c3_2.C3_2Exception;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.c1.c2.c3_3.C3_3Error;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.c1.c2.c3_3.C3_3Exception;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.ea1.EA1Error;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.ea1.EA1Exception;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.ea1.ea2.EA2Error;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.ea1.ea2.EA2Exception;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.ea1.ea2.ea3_1.EA3_1Error;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.ea1.ea2.ea3_1.EA3_1Exception;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.ea1.ea2.ea3_2.EA3_2Error;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.ea1.ea2.ea3_2.EA3_2Exception;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.ea1.ea2.ea3_3.EA3_3Error;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.ea1.ea2.ea3_3.EA3_3Exception;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.eb1.EB1Error;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.eb1.EB1Exception;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.eb1.eb2.EB2Error;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.eb1.eb2.EB2Exception;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.eb1.eb2.eb3_1.EB3_1Error;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.eb1.eb2.eb3_1.EB3_1Exception;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.eb1.eb2.eb3_2.EB3_2Error;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.eb1.eb2.eb3_2.EB3_2Exception;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.eb1.eb2.eb3_3.EB3_3Error;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.eb1.eb2.eb3_3.EB3_3Exception;
import lombok.Value;
import org.junit.Test;

import java.util.Comparator;

import static com.rodrigodev.xgen4j.model.error.configuration.ErrorConfiguration.*;
import static com.rodrigodev.xgen4j.model.error.configuration.definition.ParameterDefinition.p;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 09/07/15.
 */
public class InfoGenerationTests extends TestSpecification {

    private ErrorInfo[] expectedErrorInfos;

    public InfoGenerationTests() {
        generateErrors();
        setUpExpectedErrorInfos();
    }

    private void setUpExpectedErrorInfos() {
        expectedErrorInfos = new ErrorInfo[]{
                new ErrorInfo(
                        RootError.class,
                        new ExceptionInfo(RootException.class),
                        RootError.CODE,
                        false
                ),
                new ErrorInfo(
                        C1Error.class,
                        new ExceptionInfo(C1Exception.class),
                        C1Error.CODE,
                        new PlainTextErrorDescription("Message for C1 error."),
                        true
                ),
                new ErrorInfo(
                        C2Error.class,
                        new ExceptionInfo(C2Exception.class),
                        C2Error.CODE,
                        true
                ),
                new ErrorInfo(
                        C3_1Error.class,
                        new ExceptionInfo(C3_1Exception.class),
                        C3_1Error.CODE,
                        new PlainTextErrorDescription("Message for C3_1 error."),
                        true
                ),
                new ErrorInfo(
                        C3_2Error.class,
                        new ExceptionInfo(C3_2Exception.class),
                        C3_2Error.CODE,
                        new PlainTextErrorDescription("C3_2: {param1: '%s', param2: %d, param3: '%s'}"),
                        true
                ),
                new ErrorInfo(
                        C3_3Error.class,
                        new ExceptionInfo(C3_3Exception.class),
                        C3_3Error.CODE,
                        new CustomMessageGeneratorErrorDescription<>(TestMessageGeneratorObject1.class),
                        true
                ),
                new ErrorInfo(
                        EA1Error.class,
                        new ExceptionInfo(EA1Exception.TYPE, EA1Exception.class),
                        EA1Error.CODE,
                        new PlainTextErrorDescription("Message for EA1 error."),
                        false
                ),
                new ErrorInfo(
                        EA2Error.class,
                        new ExceptionInfo(EA2Exception.TYPE, EA2Exception.class),
                        EA2Error.CODE,
                        false
                ),
                new ErrorInfo(
                        EA3_1Error.class,
                        new ExceptionInfo(EA3_1Exception.TYPE, EA3_1Exception.class),
                        EA3_1Error.CODE,
                        new PlainTextErrorDescription("Message for EA3_1 error."),
                        false
                ),
                new ErrorInfo(
                        EA3_2Error.class,
                        new ExceptionInfo(EA3_2Exception.TYPE, EA3_2Exception.class),
                        EA3_2Error.CODE,
                        new PlainTextErrorDescription("EA3_2: {param1: '%s', param2: %d, param3: '%s'}"),
                        false
                ),
                new ErrorInfo(
                        EA3_3Error.class,
                        new ExceptionInfo(EA3_3Exception.TYPE, EA3_3Exception.class),
                        EA3_3Error.CODE,
                        new CustomMessageGeneratorErrorDescription<>(TestMessageGeneratorObject2.class),
                        false
                ),
                new ErrorInfo(
                        EB1Error.class,
                        new ExceptionInfo(EB1Exception.TYPE, EB1Exception.class),
                        EB1Error.CODE,
                        new PlainTextErrorDescription("Message for EB1 error."),
                        false
                ),
                new ErrorInfo(
                        EB2Error.class,
                        new ExceptionInfo(EB2Exception.TYPE, EB2Exception.class),
                        EB2Error.CODE,
                        false
                ),
                new ErrorInfo(
                        EB3_1Error.class,
                        new ExceptionInfo(EB3_1Exception.TYPE, EB3_1Exception.class),
                        EB3_1Error.CODE,
                        new PlainTextErrorDescription("Message for EB3_1 error."),
                        false
                ),
                new ErrorInfo(
                        EB3_2Error.class,
                        new ExceptionInfo(EB3_2Exception.TYPE, EB3_2Exception.class),
                        EB3_2Error.CODE,
                        new PlainTextErrorDescription("EB3_2: {param1: '%s', param2: %d, param3: '%s'}"),
                        false
                ),
                new ErrorInfo(
                        EB3_3Error.class,
                        new ExceptionInfo(EB3_3Exception.TYPE, EB3_3Exception.class),
                        EB3_3Error.CODE,
                        new CustomMessageGeneratorErrorDescription<>(TestMessageGeneratorObject3.class),
                        false
                )
        };
    }

    private void generateErrors() {
        // @formatter:off
        generator().generate(rootError("Root").code(123).errors(
                commonError("C1").code(234).description("Message for C1 error.").errors(
                        error("C2").code(345).errors(
                                error("C3_1").code(456).description("Message for C3_1 error."),
                                error("C3_2").code(567).description("C3_2: {param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                error("C3_3").code(678).description(TestMessageGeneratorObject1.class, "generator")
                        )
                ),
                error("EA1").code(789).description("Message for EA1 error.").errors(
                        error("EA2").code(890).errors(
                                error("EA3_1").code(1234).description("Message for EA3_1 error."),
                                error("EA3_2").code(2345).description("EA3_2: {param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                error("EA3_3").code(3456).description(TestMessageGeneratorObject2.class, "generator")
                        )
                ),
                error("EB1").code(4567).description("Message for EB1 error.").errors(
                        error("EB2").code(5678).errors(
                                error("EB3_1").code(6789).description("Message for EB3_1 error."),
                                error("EB3_2").code(7890).description("EB3_2: {param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                error("EB3_3").code(12345).description(TestMessageGeneratorObject3.class, "generator")
                        )
                )
        ).basePackage("com.rodrigodev.xgen4j.test.info_generation.regularTest").build());
        // @formatter:on
    }

    @Test
    public void informationForAllErrorsIsListed() {
        assertThat(Information.list())
                .usingElementComparator(new ErrorInfoTestComparator())
                .containsOnly(expectedErrorInfos)
                .doesNotHaveDuplicates();
    }

    @Test
    public void errorInfoEqualityIsBasedOnCode() {
        ErrorInfo errorInfo = new ErrorInfo(
                C1Error.class,
                new ExceptionInfo(C1Exception.class),
                C1Error.CODE,
                new PlainTextErrorDescription("Message for C1 error."),
                true
        );

        assertThat(errorInfo).isNotEqualTo(
                new ErrorInfo(
                        C1Error.class,
                        new ExceptionInfo(C1Exception.class),
                        EA1Error.CODE,
                        new PlainTextErrorDescription("Message for C1 error."),
                        true
                )
        );
        assertThat(errorInfo).isEqualTo(
                new ErrorInfo(
                        EA1Error.class,
                        new ExceptionInfo(EA1Exception.class),
                        C1Error.CODE,
                        new PlainTextErrorDescription("Message for EA1 error."),
                        false
                )
        );
    }

    @Test
    public void informationForAParticularErrorCanBeRetrievedByItsId() {
        for (ErrorInfo expectedErrorInfo : expectedErrorInfos) {
            assertThat(Information.forId(expectedErrorInfo.code().id()))
                    .usingComparator(new ErrorInfoTestComparator())
                    .isEqualTo(expectedErrorInfo);
        }
    }

    @Test
    public void informationForAParticularErrorCanBeRetrievedByItsNumericId() {
        for (ErrorInfo expectedErrorInfo : expectedErrorInfos) {
            assertThat(Information.forNumericId(expectedErrorInfo.code().numericId()))
                    .usingComparator(new ErrorInfoTestComparator())
                    .isEqualTo(expectedErrorInfo);
        }
    }

    @Test
    public void methodForRetrievingErrorInfoByItsNumericIdIsNotGeneratedWhenErrorCodeDoesNotHaveNumericId() {
        // @formatter:off
        generator().generate(rootError("Root").errors(
                commonError("C1").errors(
                        error("C2").errors(
                                error("C3_1").description("ABCDE")
                        )
                )
        ).basePackage("com.rodrigodev.xgen4j.test.info_generation.methodForRetrievingErrorInfoByItsNumericIdIsNotGeneratedWhenErrorCodeDoesNotHaveNumericId").build());

        assertThat(com.rodrigodev.xgen4j.test.info_generation.methodForRetrievingErrorInfoByItsNumericIdIsNotGeneratedWhenErrorCodeDoesNotHaveNumericId.Information.class.getDeclaredMethods())
                .doNotHave(new MethodNamed("forNumericId"));
        // @formatter:on
    }

    public static class ErrorInfoTestComparator implements Comparator<ErrorInfo> {

        @Override
        public int compare(ErrorInfo info1, ErrorInfo info2) {

            boolean result = info1.clazz() == info2.clazz()
                    && info1.code().equals(info2.code())
                    && info1.isCommon() == info2.isCommon()
                    && info1.description().isPresent() == info2.description().isPresent();

            if (result && info1.description().isPresent()) {
                ErrorDescription description1 = info1.description().get();
                ErrorDescription description2 = info2.description().get();
                result = description1.description().equals(description2.description());
            }

            if (result) {
                ExceptionInfo exceptionInfo1 = info1.exceptionInfo();
                ExceptionInfo exceptionInfo2 = info2.exceptionInfo();
                result = exceptionInfo1.clazz() == exceptionInfo2.clazz()
                        && exceptionInfo1.type().equals(exceptionInfo2.type());
            }

            return result ? 0 : 1;
        }
    }

    @Value
    public static class TestMessageGeneratorObject1 {

        private String value1;
        private int value2;

        public String message() {
            return String.format("Custom Message1: {value1: '%s', value2: %d}", value1, value2);
        }
    }

    @Value
    public static class TestMessageGeneratorObject2 {

        private String value1;
        private int value2;

        public String message() {
            return String.format("Custom Message2: {value1: '%s', value2: %d}", value1, value2);
        }
    }

    @Value
    public static class TestMessageGeneratorObject3 {

        private String value1;
        private int value2;

        public String message() {
            return String.format("Custom Message3: {value1: '%s', value2: %d}", value1, value2);
        }
    }
}
