package com.rodrigodev.xgen.test.code;

import com.rodrigodev.xgen.ExceptionsGenerator;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.RootNameError;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.CommonName1Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.CommonName2Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.common_name3_1.CommonName3_1Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.common_name3_2.CommonName3_2Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.common_name3_3.CommonName3_3Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.ErrorName1Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.ErrorName2Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_1.ErrorName3_1Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_2.ErrorName3_2Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_3.ErrorName3_3Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases.*;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified.RootError;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified.c1.C1Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified.c1.c2.C2Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified.c1.c2.c3_1.C3_1Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified.c1.c2.c3_2.C3_2Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified.c1.c2.c3_3.C3_3Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified.e1.E1Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified.e1.e2.E2Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified.e1.e2.e3_1.E3_1Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified.e1.e2.e3_2.E3_2Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified.e1.e2.e3_3.E3_3Error;
import org.junit.Test;

import static com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration.commonError;
import static com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration.error;
import static com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration.rootError;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by Rodrigo Quesada on 01/07/15.
 */
public class CodeNameTests {

    public CodeNameTests() {
        generateErrorsForCodeIdAndNameAreGeneratedWhenSpecifiedTests();
        generateErrorsForCodeIdAndNameAreGeneratedFromErrorNameWhenNotSpecifiedTests();
        generateErrorsForCodeIdAndNameAreGeneratedFromErrorNameWhenNotSpecifiedTests_specialCases();
        generateErrorsForCodeIdAndNameAreGeneratedOnAMixedSituationTests();
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

    private void generateErrorsForCodeIdAndNameAreGeneratedWhenSpecifiedTests() {
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
        ).basePackage("com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified").build());
        // @formatter:on
    }

    @Test
    public void codeNameIsGeneratedWhenSpecified() {
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
    public void codeIdIsGeneratedWhenSpecified() {
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

    private void generateErrorsForCodeIdAndNameAreGeneratedFromErrorNameWhenNotSpecifiedTests() {
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
        ).basePackage("com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified").build());
        // @formatter:on
    }

    @Test
    public void codeNameIsGeneratedFromErrorNameWhenNotSpecified() {
        // @formatter:off
        assertThat(RootNameError.CODE.name()).isEqualTo("root-name");

        assertThat(CommonName1Error.CODE.name()).isEqualTo("common-name-1");
        assertThat(CommonName2Error.CODE.name()).isEqualTo("common-name-2");
        assertThat(CommonName3_1Error.CODE.name()).isEqualTo("common-name-3-1");
        assertThat(CommonName3_2Error.CODE.name()).isEqualTo("common-name-3-2");
        assertThat(CommonName3_3Error.CODE.name()).isEqualTo("common-name-3-3");

        assertThat(ErrorName1Error.CODE.name()).isEqualTo("error-name-1");
        assertThat(ErrorName2Error.CODE.name()).isEqualTo("error-name-2");
        assertThat(ErrorName3_1Error.CODE.name()).isEqualTo("error-name-3-1");
        assertThat(ErrorName3_2Error.CODE.name()).isEqualTo("error-name-3-2");
        assertThat(ErrorName3_3Error.CODE.name()).isEqualTo("error-name-3-3");
        // @formatter:on
    }

    @Test
    public void codeIdIsGeneratedFromErrorNameWhenNotSpecified() {
        // @formatter:off
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

    private void generateErrorsForCodeIdAndNameAreGeneratedFromErrorNameWhenNotSpecifiedTests_specialCases() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
        // @formatter:off
        xgen.generate(rootError("Root_Name1").basePackage("com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("Root-Name2").basePackage("com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("Root__Name3").basePackage("com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("Root--Name4").basePackage("com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("Root_-_Name5").basePackage("com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("RootName6_").basePackage("com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("RootName7-").basePackage("com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("RootName8__").basePackage("com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("RootName9--").basePackage("com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("RootName10_-_").basePackage("com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("Root_name11").basePackage("com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("Root-name12").basePackage("com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        // @formatter:on
    }


    @Test
    public void codeNameIsGeneratedFromErrorNameWhenNotSpecified_specialCases() {
        assertThat(Root_Name1Error.CODE.name()).isEqualTo("root-name-1");
        assertThat(Root_Name2Error.CODE.name()).isEqualTo("root-name-2");
        assertThat(Root__Name3Error.CODE.name()).isEqualTo("root-name-3");
        assertThat(Root__Name4Error.CODE.name()).isEqualTo("root-name-4");
        assertThat(Root___Name5Error.CODE.name()).isEqualTo("root-name-5");
        assertThat(RootName6_Error.CODE.name()).isEqualTo("root-name-6");
        assertThat(RootName7_Error.CODE.name()).isEqualTo("root-name-7");
        assertThat(RootName8__Error.CODE.name()).isEqualTo("root-name-8");
        assertThat(RootName9__Error.CODE.name()).isEqualTo("root-name-9");
        assertThat(RootName10___Error.CODE.name()).isEqualTo("root-name-10");
        assertThat(Root_name11Error.CODE.name()).isEqualTo("root-name-11");
        assertThat(Root_name12Error.CODE.name()).isEqualTo("root-name-12");
    }

    @Test
    public void codeIdIsGeneratedFromErrorNameWhenNotSpecified_specialCases() {
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

    private void generateErrorsForCodeIdAndNameAreGeneratedOnAMixedSituationTests() {
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
        ).basePackage("com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation").build());
        // @formatter:on
    }

    @Test
    public void codeNameIsGeneratedOnAMixedSituation() {
        // @formatter:off
        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.RootNameError.CODE.name())
                .isEqualTo("root-name");

        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.C1Error.CODE.name())
                .isEqualTo("code-name-c1");
        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.CommonName2Error.CODE.name())
                .isEqualTo("common-name-2");
        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.common_name3_1.CommonName3_1Error.CODE.name())
                .isEqualTo("common-name-3-1");
        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.c3_2.C3_2Error.CODE.name())
                .isEqualTo("code-name-c3-2");
        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.common_name3_3.CommonName3_3Error.CODE.name())
                .isEqualTo("common-name-3-3");

        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.E1Error.CODE.name())
                .isEqualTo("code-name-e1");
        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.ErrorName2Error.CODE.name())
                .isEqualTo("error-name-2");
        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.error_name3_1.ErrorName3_1Error.CODE.name())
                .isEqualTo("error-name-3-1");
        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.e3_2.E3_2Error.CODE.name())
                .isEqualTo("code-name-e3-2");
        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.error_name3_3.ErrorName3_3Error.CODE.name())
                .isEqualTo("error-name-3-3");
        // @formatter:on
    }

    @Test
    public void codeIdIsGeneratedOnAMixedSituation() {
        // @formatter:off
        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.RootNameError.CODE.id())
                .isEqualTo("root-name");

        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.C1Error.CODE.id())
                .isEqualTo("root-name.code-name-c1");
        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.CommonName2Error.CODE.id())
                .isEqualTo("root-name.code-name-c1.common-name-2");
        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.common_name3_1.CommonName3_1Error.CODE.id())
                .isEqualTo("root-name.code-name-c1.common-name-2.common-name-3-1");
        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.c3_2.C3_2Error.CODE.id())
                .isEqualTo("root-name.code-name-c1.common-name-2.code-name-c3-2");
        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.common_name3_3.CommonName3_3Error.CODE.id())
                .isEqualTo("root-name.code-name-c1.common-name-2.common-name-3-3");

        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.E1Error.CODE.id())
                .isEqualTo("root-name.code-name-e1");
        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.ErrorName2Error.CODE.id())
                .isEqualTo("root-name.code-name-e1.error-name-2");
        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.error_name3_1.ErrorName3_1Error.CODE.id())
                .isEqualTo("root-name.code-name-e1.error-name-2.error-name-3-1");
        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.e3_2.E3_2Error.CODE.id())
                .isEqualTo("root-name.code-name-e1.error-name-2.code-name-e3-2");
        assertThat(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.error_name3_3.ErrorName3_3Error.CODE.id())
                .isEqualTo("root-name.code-name-e1.error-name-2.error-name-3-3");
        // @formatter:on
    }
}