package com.rodrigodev.xgen.test.code;

import com.rodrigodev.xgen.ExceptionsGenerator;
import com.rodrigodev.xgen.test.code.codeIdIsGenerated.RootError;
import com.rodrigodev.xgen.test.code.codeIdIsGenerated.c1.C1Error;
import com.rodrigodev.xgen.test.code.codeIdIsGenerated.c1.c2.C2Error;
import com.rodrigodev.xgen.test.code.codeIdIsGenerated.c1.c2.c3_1.C3_1Error;
import com.rodrigodev.xgen.test.code.codeIdIsGenerated.c1.c2.c3_2.C3_2Error;
import com.rodrigodev.xgen.test.code.codeIdIsGenerated.c1.c2.c3_3.C3_3Error;
import com.rodrigodev.xgen.test.code.codeIdIsGenerated.e1.E1Error;
import com.rodrigodev.xgen.test.code.codeIdIsGenerated.e1.e2.E2Error;
import com.rodrigodev.xgen.test.code.codeIdIsGenerated.e1.e2.e3_1.E3_1Error;
import com.rodrigodev.xgen.test.code.codeIdIsGenerated.e1.e2.e3_2.E3_2Error;
import com.rodrigodev.xgen.test.code.codeIdIsGenerated.e1.e2.e3_3.E3_3Error;
import com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified.RootNameError;
import com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified.common_name1.CommonName1Error;
import com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.CommonName2Error;
import com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.common_name3_1.CommonName3_1Error;
import com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.common_name3_2.CommonName3_2Error;
import com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.common_name3_3.CommonName3_3Error;
import com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified.error_name1.ErrorName1Error;
import com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.ErrorName2Error;
import com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_1.ErrorName3_1Error;
import com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_2.ErrorName3_2Error;
import com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_3.ErrorName3_3Error;
import com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_specialCases.*;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Test;

import static com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 25/06/15.
 */
public class CodeTests {

    public static class CodeNameTests {

        public CodeNameTests(){
            generateErrorsForCodeIdAndNameTests();
        }

        private void generateErrorsForCodeIdAndNameTests(){
            ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
            // @formatter:off
            xgen.generate(rootError("Root").code("code-name-root").errors(
                    error("C1").code("code-name-c1").errors(
                            error("C2").code("code-name-c2").errors(
                                    error("C3_1").code("code-name-c3-1").description("ABCDE"),
                                    error("C3_2").code("code-name-c3-2").description("ABCDE"),
                                    error("C3_3").code("code-name-c3-3").description("ABCDE")
                            )
                    ),
                    error("E1").code("code-name-e1").errors(
                            error("E2").code("code-name-e2").errors(
                                    error("E3_1").code("code-name-e3-1").description("ABCDE"),
                                    error("E3_2").code("code-name-e3-2").description("ABCDE"),
                                    error("E3_3").code("code-name-e3-3").description("ABCDE")
                            )
                    )
            ).basePackage("com.rodrigodev.xgen.test.code.codeIdIsGenerated").build());
            // @formatter:on
        }

        @Test
        public void codeNameIsGenerated() {
            assertThat(RootError.CODE.name()).isEqualTo("code-name-root");

            assertThat(C1Error.CODE.name()).isEqualTo("code-name-c1");
            assertThat(C2Error.CODE.name()).isEqualTo("code-name-c2");
            assertThat(C3_1Error.CODE.name()).isEqualTo("code-name-c3-1");
            assertThat(C3_2Error.CODE.name()).isEqualTo("code-name-c3-2");
            assertThat(C3_3Error.CODE.name()).isEqualTo("code-name-c3-3");

            assertThat(E1Error.CODE.name()).isEqualTo("code-name-e1");
            assertThat(E2Error.CODE.name()).isEqualTo("code-name-e2");
            assertThat(E3_1Error.CODE.name()).isEqualTo("code-name-e3-1");
            assertThat(E3_2Error.CODE.name()).isEqualTo("code-name-e3-2");
            assertThat(E3_3Error.CODE.name()).isEqualTo("code-name-e3-3");
        }

        @Test
        public void codeIdIsGenerated() {
            assertThat(RootError.CODE.id()).isEqualTo("code-name-root");

            assertThat(C1Error.CODE.id()).isEqualTo("code-name-root.code-name-c1");
            assertThat(C2Error.CODE.id()).isEqualTo("code-name-root.code-name-c1.code-name-c2");
            assertThat(C3_1Error.CODE.id()).isEqualTo("code-name-root.code-name-c1.code-name-c2.code-name-c3-1");
            assertThat(C3_2Error.CODE.id()).isEqualTo("code-name-root.code-name-c1.code-name-c2.code-name-c3-2");
            assertThat(C3_3Error.CODE.id()).isEqualTo("code-name-root.code-name-c1.code-name-c2.code-name-c3-3");

            assertThat(E1Error.CODE.id()).isEqualTo("code-name-root.code-name-e1");
            assertThat(E2Error.CODE.id()).isEqualTo("code-name-root.code-name-e1.code-name-e2");
            assertThat(E3_1Error.CODE.id()).isEqualTo("code-name-root.code-name-e1.code-name-e2.code-name-e3-1");
            assertThat(E3_2Error.CODE.id()).isEqualTo("code-name-root.code-name-e1.code-name-e2.code-name-e3-2");
            assertThat(E3_3Error.CODE.id()).isEqualTo("code-name-root.code-name-e1.code-name-e2.code-name-e3-3");
        }

        @Test
        public void nameMustBeginWithALowercaseLetter() {
            String invalidCharacters = "A_1-$%";
            for (char invalidCharacter : invalidCharacters.toCharArray()) {
                String invalidName = invalidCharacter + "abcde";

                assertThatThrownBy(() -> rootError("Root").code(invalidName))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(String.format("Error code's name '%s' has invalid format.", invalidName));
            }
        }

        @Test
        public void nameCanOnlyContainLowercaseLettersNumbersHyphensOrDots() {
            String invalidCharacters = "A!@#$%^&*()+_";
            for (char invalidCharacter : invalidCharacters.toCharArray()) {
                String invalidName = "name" + invalidCharacter;

                assertThatThrownBy(() -> rootError("Root").code(invalidName))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(String.format("Error code's name '%s' has invalid format.", invalidName));
            }
        }

        @Test
        public void codeIdIsGeneratedFromErrorNameWhenNotSpecified() {
            ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
            // @formatter:off
            xgen.generate(rootError("RootName").errors(
                    commonError("CommonName1").errors(
                            error("CommonName2").errors(
                                    error("CommonName3_1").description("ABCDE"),
                                    error("CommonName3_2").description("ABCDE"),
                                    error("CommonName3_3").description("ABCDE")
                            )
                    ),
                    error("ErrorName1").errors(
                            error("ErrorName2").errors(
                                    error("ErrorName3_1").description("ABCDE"),
                                    error("ErrorName3_2").description("ABCDE"),
                                    error("ErrorName3_3").description("ABCDE")
                            )
                    )
            ).basePackage("com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified").build());

            assertThat(RootNameError.CODE.id()).isEqualTo("root-name");

            assertThat(CommonName1Error.CODE.id()).isEqualTo("root-name.common-name-1");
            assertThat(CommonName2Error.CODE.id()).isEqualTo("root-name.common-name-1.common-name-2");
            assertThat(CommonName3_1Error.CODE.id()).isEqualTo("root-name.common-name-1.common-name-2.common-name-3-1");
            assertThat(CommonName3_2Error.CODE.id()).isEqualTo("root-name.common-name-1.common-name-2.common-name-3-2");
            assertThat(CommonName3_3Error.CODE.id()).isEqualTo("root-name.common-name-1.common-name-2.common-name-3-3");

            assertThat(ErrorName1Error.CODE.id()).isEqualTo("root-name.error-name-1");
            assertThat(ErrorName2Error.CODE.id()).isEqualTo("root-name.error-name-1.error-name-2");
            assertThat(ErrorName3_1Error.CODE.id()).isEqualTo("root-name.error-name-1.error-name-2.error-name-3-1");
            assertThat(ErrorName3_2Error.CODE.id()).isEqualTo("root-name.error-name-1.error-name-2.error-name-3-2");
            assertThat(ErrorName3_3Error.CODE.id()).isEqualTo("root-name.error-name-1.error-name-2.error-name-3-3");
            // @formatter:on
        }

        @Test
        public void codeIdIsGeneratedFromErrorNameWhenNotSpecified_specialCases() {
            ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
            // @formatter:off
            xgen.generate(rootError("Root_Name1").basePackage("com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
            xgen.generate(rootError("Root-Name2").basePackage("com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
            xgen.generate(rootError("Root__Name3").basePackage("com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
            xgen.generate(rootError("Root--Name4").basePackage("com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
            xgen.generate(rootError("Root_-_Name5").basePackage("com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
            xgen.generate(rootError("RootName6_").basePackage("com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
            xgen.generate(rootError("RootName7-").basePackage("com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
            xgen.generate(rootError("RootName8__").basePackage("com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
            xgen.generate(rootError("RootName9--").basePackage("com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
            xgen.generate(rootError("RootName10_-_").basePackage("com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
            xgen.generate(rootError("Root_name11").basePackage("com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
            xgen.generate(rootError("Root-name12").basePackage("com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
            // @formatter:on

            assertThat(Root_Name1Error.CODE.id()).isEqualTo("root-name-1");
            assertThat(Root_Name2Error.CODE.id()).isEqualTo("root-name-2");
            assertThat(Root__Name3Error.CODE.id()).isEqualTo("root-name-3");
            assertThat(Root__Name4Error.CODE.id()).isEqualTo("root-name-4");
            assertThat(Root___Name5Error.CODE.id()).isEqualTo("root-name-5");
            assertThat(RootName6_Error.CODE.id()).isEqualTo("root-name-6");
            assertThat(RootName7_Error.CODE.id()).isEqualTo("root-name-7");
            assertThat(RootName8__Error.CODE.id()).isEqualTo("root-name-8");
            assertThat(RootName9__Error.CODE.id()).isEqualTo("root-name-9");
            assertThat(RootName10___Error.CODE.id()).isEqualTo("root-name-10");
            assertThat(Root_name11Error.CODE.id()).isEqualTo("root-name-11");
            assertThat(Root_name12Error.CODE.id()).isEqualTo("root-name-12");
        }

        @Test
        public void codeIdIsGeneratedFromErrorNameWhenNotSpecified_mixedCase() {
            ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
            // @formatter:off
            xgen.generate(rootError("RootName").errors(
                    commonError("C1").code("code-name-c1").errors(
                            error("CommonName2").errors(
                                    error("CommonName3_1").description("ABCDE"),
                                    error("C3_2").code("code-name-c3-2").description("ABCDE"),
                                    error("CommonName3_3").description("ABCDE")
                            )
                    ),
                    error("E1").code("code-name-e1").errors(
                            error("ErrorName2").errors(
                                    error("ErrorName3_1").description("ABCDE"),
                                    error("E3_2").code("code-name-e3-2").description("ABCDE"),
                                    error("ErrorName3_3").description("ABCDE")
                            )
                    )
            ).basePackage("com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_mixedCase").build());

            assertThat(com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.RootNameError.CODE.id())
                    .isEqualTo("root-name");

            assertThat(com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.c1.C1Error.CODE.id())
                    .isEqualTo("root-name.code-name-c1");
            assertThat(com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.c1.common_name2.CommonName2Error.CODE.id())
                    .isEqualTo("root-name.code-name-c1.common-name-2");
            assertThat(com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.c1.common_name2.common_name3_1.CommonName3_1Error.CODE.id())
                    .isEqualTo("root-name.code-name-c1.common-name-2.common-name-3-1");
            assertThat(com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.c1.common_name2.c3_2.C3_2Error.CODE.id())
                    .isEqualTo("root-name.code-name-c1.common-name-2.code-name-c3-2");
            assertThat(com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.c1.common_name2.common_name3_3.CommonName3_3Error.CODE.id())
                    .isEqualTo("root-name.code-name-c1.common-name-2.common-name-3-3");

            assertThat(com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.e1.E1Error.CODE.id())
                    .isEqualTo("root-name.code-name-e1");
            assertThat(com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.e1.error_name2.ErrorName2Error.CODE.id())
                    .isEqualTo("root-name.code-name-e1.error-name-2");
            assertThat(com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.e1.error_name2.error_name3_1.ErrorName3_1Error.CODE.id())
                    .isEqualTo("root-name.code-name-e1.error-name-2.error-name-3-1");
            assertThat(com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.e1.error_name2.e3_2.E3_2Error.CODE.id())
                    .isEqualTo("root-name.code-name-e1.error-name-2.code-name-e3-2");
            assertThat(com.rodrigodev.xgen.test.code.codeIdIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.e1.error_name2.error_name3_3.ErrorName3_3Error.CODE.id())
                    .isEqualTo("root-name.code-name-e1.error-name-2.error-name-3-3");
            // @formatter:on
        }
    }

    public static class CodeNumberTests {

        private void assert_ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt(ThrowingCallable methodCall) {
            assertThatThrownBy(methodCall)
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessage("Code number is missing for error definition 'AnErrorName'.");
        }

        @Test
        public void ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt() {
            ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");

            assert_ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt(
                    () ->
                            // @formatter:off
                            xgen.generate(rootError("RootName").code(1).errors(
                                    commonError("AnErrorName")
                            ).basePackage("com.rodrigodev.xgen.test.code.ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt").build())
                            // @formatter:on
            );
            assert_ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt(
                    () ->
                            // @formatter:off
                            xgen.generate(rootError("RootName").code(1).errors(
                                    commonError("C1").code(1).errors(
                                            error("AnErrorName")
                                    )
                            ).basePackage("com.rodrigodev.xgen.test.code.ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt").build())
                            // @formatter:on
            );
            assert_ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt(
                    () ->
                            // @formatter:off
                            xgen.generate(rootError("RootName").code(1).errors(
                                    commonError("C1").code(1).errors(
                                            error("C2").code(1).errors(
                                                    error("C3_1").code(1),
                                                    error("AnErrorName"),
                                                    error("C3_3").code(3)
                                            )
                                    )
                            ).basePackage("com.rodrigodev.xgen.test.code.ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt").build())
                            // @formatter:on
            );
            assert_ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt(
                    () ->
                            // @formatter:off
                            xgen.generate(rootError("RootName").code(1).errors(
                                    error("AnErrorName")
                            ).basePackage("com.rodrigodev.xgen.test.code.ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt").build())
                            // @formatter:on
            );
            assert_ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt(
                    () ->
                            // @formatter:off
                            xgen.generate(rootError("RootName").code(1).errors(
                                    error("E1").code(1).errors(
                                            error("AnErrorName")
                                    )
                            ).basePackage("com.rodrigodev.xgen.test.code.ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt").build())
                            // @formatter:on
            );
            assert_ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt(
                    () ->
                            // @formatter:off
                            xgen.generate(rootError("RootName").code(1).errors(
                                    error("E1").code(1).errors(
                                            error("E2").code(1).errors(
                                                    error("E3_1").code(1),
                                                    error("AnErrorName"),
                                                    error("E3_3").code(3)
                                            )
                                    )
                            ).basePackage("com.rodrigodev.xgen.test.code.ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt").build())
                            // @formatter:on
            );
        }

        private void assert_ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither(
                ThrowingCallable methodCall) {
            assertThatThrownBy(methodCall)
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessage("Error definition 'AnErrorName' can't have a code number.");
        }

        @Test
        public void ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither() {
            ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");

            assert_ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither(
                    () ->
                            // @formatter:off
                            xgen.generate(rootError("RootName").errors(
                                    commonError("AnErrorName").code(1)
                            ).basePackage("com.rodrigodev.xgen.test.code.ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither").build())
                            // @formatter:on
            );
            assert_ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither(
                    () ->
                            // @formatter:off
                            xgen.generate(rootError("RootName").errors(
                                    commonError("C1").errors(
                                            error("AnErrorName").code(1)
                                    )
                            ).basePackage("com.rodrigodev.xgen.test.code.ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither").build())
                            // @formatter:on
            );
            assert_ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither(
                    () ->
                            // @formatter:off
                            xgen.generate(rootError("RootName").errors(
                                    commonError("C1").errors(
                                            error("C2").errors(
                                                    error("C3_1"),
                                                    error("AnErrorName").code(1),
                                                    error("C3_3")
                                            )
                                    )
                            ).basePackage("com.rodrigodev.xgen.test.code.ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither").build())
                            // @formatter:on
            );
            assert_ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither(
                    () ->
                            // @formatter:off
                            xgen.generate(rootError("RootName").errors(
                                    error("AnErrorName").code(1)
                            ).basePackage("com.rodrigodev.xgen.test.code.ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither").build())
                            // @formatter:on
            );
            assert_ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither(
                    () ->
                            // @formatter:off
                            xgen.generate(rootError("RootName").errors(
                                    error("E1").errors(
                                            error("AnErrorName").code(1)
                                    )
                            ).basePackage("com.rodrigodev.xgen.test.code.ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither").build())
                            // @formatter:on
            );
            assert_ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither(
                    () ->
                            // @formatter:off
                            xgen.generate(rootError("RootName").errors(
                                    error("E1").errors(
                                            error("E2").errors(
                                                    error("E3_1"),
                                                    error("AnErrorName").code(1),
                                                    error("E3_3")
                                            )
                                    )
                            ).basePackage("com.rodrigodev.xgen.test.code.ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither").build())
                            // @formatter:on
            );
        }
    }
}
