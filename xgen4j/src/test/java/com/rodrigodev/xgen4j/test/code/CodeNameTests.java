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

package com.rodrigodev.xgen4j.test.code;

import com.rodrigodev.xgen4j.ExceptionsGenerator;
import com.rodrigodev.xgen4j.test.TestSpecification;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.Root9NameError;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common9_name1.Common9Name1Error;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common9_name1.common9_name2.Common9Name2Error;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common9_name1.common9_name2.common9_name3_1.Common9Name3_1Error;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common9_name1.common9_name2.common9_name3_2.Common9Name3_2Error;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common9_name1.common9_name2.common9_name3_3.Common9Name3_3Error;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error9_name1.Error9Name1Error;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error9_name1.error9_name2.Error9Name2Error;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error9_name1.error9_name2.error9_name3_1.Error9Name3_1Error;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error9_name1.error9_name2.error9_name3_2.Error9Name3_2Error;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error9_name1.error9_name2.error9_name3_3.Error9Name3_3Error;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases.*;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenSpecified.RootError;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenSpecified.code_9_name_c1.C1Error;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenSpecified.code_9_name_c1.code_9_name_c2.C2Error;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenSpecified.code_9_name_c1.code_9_name_c2.code_9_name_c3_1.C3_1Error;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenSpecified.code_9_name_c1.code_9_name_c2.code_9_name_c3_2.C3_2Error;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenSpecified.code_9_name_c1.code_9_name_c2.code_9_name_c3_3.C3_3Error;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenSpecified.code_9_name_e1.E1Error;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenSpecified.code_9_name_e1.code_9_name_e2.E2Error;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenSpecified.code_9_name_e1.code_9_name_e2.code_9_name_e3_1.E3_1Error;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenSpecified.code_9_name_e1.code_9_name_e2.code_9_name_e3_2.E3_2Error;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenSpecified.code_9_name_e1.code_9_name_e2.code_9_name_e3_3.E3_3Error;
import org.junit.Test;

import static com.rodrigodev.xgen4j.model.error.configuration.ErrorConfiguration.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 01/07/15.
 */
public class CodeNameTests extends TestSpecification {

    public CodeNameTests() {
        generateErrorsForCodeIdAndNameAreGeneratedWhenSpecifiedTests();
        generateErrorsForCodeIdAndNameAreGeneratedFromErrorNameWhenNotSpecifiedTests();
        generateErrorsForCodeIdAndNameAreGeneratedFromErrorNameWhenNotSpecifiedTests_specialCases();
        generateErrorsForCodeIdAndNameAreGeneratedOnAMixedSituationTests();
        generateErrorsForCodeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecifiedTests();
    }

    @Test
    public void nameMustBeginWithALowercaseLetter() {
        String invalidCharacters = "A_1-$%";
        for (char invalidCharacter : invalidCharacters.toCharArray()) {
            String invalidName = invalidCharacter + "abcde";

            assertThatThrownBy(() -> rootError("Root").code(invalidName).build())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(String.format("Error code's name '%s' has invalid format.", invalidName));
        }
    }

    @Test
    public void nameCanOnlyContainLowercaseLettersNumbersHyphensOrDots() {
        String invalidCharacters = "A!@#$%^&*()+_";
        for (char invalidCharacter : invalidCharacters.toCharArray()) {
            String invalidName = "name" + invalidCharacter;

            assertThatThrownBy(() -> rootError("Root").code(invalidName).build())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(String.format("Error code's name '%s' has invalid format.", invalidName));
        }
    }

    private void generateErrorsForCodeIdAndNameAreGeneratedWhenSpecifiedTests() {
        // @formatter:off
        generator().generate(rootError("Root").code("code-9-name-root").errors(
                commonError("C1").code("code-9-name-c1").errors(
                        error("C2").code("code-9-name-c2").errors(
                                error("C3_1").code("code-9-name-c3-1").description("ABCDE"),
                                error("C3_2").code("code-9-name-c3-2").description("ABCDE"),
                                error("C3_3").code("code-9-name-c3-3").description("ABCDE")
                        )
                ),
                error("E1").code("code-9-name-e1").errors(
                        error("E2").code("code-9-name-e2").errors(
                                error("E3_1").code("code-9-name-e3-1").description("ABCDE"),
                                error("E3_2").code("code-9-name-e3-2").description("ABCDE"),
                                error("E3_3").code("code-9-name-e3-3").description("ABCDE")
                        )
                )
        ).basePackage("com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenSpecified").build());
        // @formatter:on
    }

    @Test
    public void codeNameIsGeneratedWhenSpecified() {
        assertThat(RootError.CODE.name()).isEqualTo("code-9-name-root");

        assertThat(C1Error.CODE.name()).isEqualTo("code-9-name-c1");
        assertThat(C2Error.CODE.name()).isEqualTo("code-9-name-c2");
        assertThat(C3_1Error.CODE.name()).isEqualTo("code-9-name-c3-1");
        assertThat(C3_2Error.CODE.name()).isEqualTo("code-9-name-c3-2");
        assertThat(C3_3Error.CODE.name()).isEqualTo("code-9-name-c3-3");

        assertThat(E1Error.CODE.name()).isEqualTo("code-9-name-e1");
        assertThat(E2Error.CODE.name()).isEqualTo("code-9-name-e2");
        assertThat(E3_1Error.CODE.name()).isEqualTo("code-9-name-e3-1");
        assertThat(E3_2Error.CODE.name()).isEqualTo("code-9-name-e3-2");
        assertThat(E3_3Error.CODE.name()).isEqualTo("code-9-name-e3-3");
    }

    @Test
    public void codeIdIsGeneratedWhenSpecified() {
        assertThat(RootError.CODE.id()).isEqualTo("code-9-name-root");

        assertThat(C1Error.CODE.id()).isEqualTo("code-9-name-c1");
        assertThat(C2Error.CODE.id()).isEqualTo("code-9-name-c1.code-9-name-c2");
        assertThat(C3_1Error.CODE.id()).isEqualTo("code-9-name-c1.code-9-name-c2.code-9-name-c3-1");
        assertThat(C3_2Error.CODE.id()).isEqualTo("code-9-name-c1.code-9-name-c2.code-9-name-c3-2");
        assertThat(C3_3Error.CODE.id()).isEqualTo("code-9-name-c1.code-9-name-c2.code-9-name-c3-3");

        assertThat(E1Error.CODE.id()).isEqualTo("code-9-name-e1");
        assertThat(E2Error.CODE.id()).isEqualTo("code-9-name-e1.code-9-name-e2");
        assertThat(E3_1Error.CODE.id()).isEqualTo("code-9-name-e1.code-9-name-e2.code-9-name-e3-1");
        assertThat(E3_2Error.CODE.id()).isEqualTo("code-9-name-e1.code-9-name-e2.code-9-name-e3-2");
        assertThat(E3_3Error.CODE.id()).isEqualTo("code-9-name-e1.code-9-name-e2.code-9-name-e3-3");
    }

    private void generateErrorsForCodeIdAndNameAreGeneratedFromErrorNameWhenNotSpecifiedTests() {
        // @formatter:off
        generator().generate(rootError("Root9Name").errors(
                commonError("Common9Name1").errors(
                        error("Common9Name2").errors(
                                error("Common9Name3_1").description("ABCDE"),
                                error("Common9Name3_2").description("ABCDE"),
                                error("Common9Name3_3").description("ABCDE")
                        )
                ),
                error("Error9Name1").errors(
                        error("Error9Name2").errors(
                                error("Error9Name3_1").description("ABCDE"),
                                error("Error9Name3_2").description("ABCDE"),
                                error("Error9Name3_3").description("ABCDE")
                        )
                )
        ).basePackage("com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified").build());
        // @formatter:on
    }

    @Test
    public void codeNameIsGeneratedFromErrorNameWhenNotSpecified() {
        // @formatter:off
        assertThat(Root9NameError.CODE.name()).isEqualTo("root-9-name");

        assertThat(Common9Name1Error.CODE.name()).isEqualTo("common-9-name-1");
        assertThat(Common9Name2Error.CODE.name()).isEqualTo("common-9-name-2");
        assertThat(Common9Name3_1Error.CODE.name()).isEqualTo("common-9-name-3-1");
        assertThat(Common9Name3_2Error.CODE.name()).isEqualTo("common-9-name-3-2");
        assertThat(Common9Name3_3Error.CODE.name()).isEqualTo("common-9-name-3-3");

        assertThat(Error9Name1Error.CODE.name()).isEqualTo("error-9-name-1");
        assertThat(Error9Name2Error.CODE.name()).isEqualTo("error-9-name-2");
        assertThat(Error9Name3_1Error.CODE.name()).isEqualTo("error-9-name-3-1");
        assertThat(Error9Name3_2Error.CODE.name()).isEqualTo("error-9-name-3-2");
        assertThat(Error9Name3_3Error.CODE.name()).isEqualTo("error-9-name-3-3");
        // @formatter:on
    }

    @Test
    public void codeIdIsGeneratedFromErrorNameWhenNotSpecified() {
        // @formatter:off
        assertThat(Root9NameError.CODE.id()).isEqualTo("root-9-name");

        assertThat(Common9Name1Error.CODE.id()).isEqualTo("common-9-name-1");
        assertThat(Common9Name2Error.CODE.id()).isEqualTo("common-9-name-1.common-9-name-2");
        assertThat(Common9Name3_1Error.CODE.id()).isEqualTo("common-9-name-1.common-9-name-2.common-9-name-3-1");
        assertThat(Common9Name3_2Error.CODE.id()).isEqualTo("common-9-name-1.common-9-name-2.common-9-name-3-2");
        assertThat(Common9Name3_3Error.CODE.id()).isEqualTo("common-9-name-1.common-9-name-2.common-9-name-3-3");

        assertThat(Error9Name1Error.CODE.id()).isEqualTo("error-9-name-1");
        assertThat(Error9Name2Error.CODE.id()).isEqualTo("error-9-name-1.error-9-name-2");
        assertThat(Error9Name3_1Error.CODE.id()).isEqualTo("error-9-name-1.error-9-name-2.error-9-name-3-1");
        assertThat(Error9Name3_2Error.CODE.id()).isEqualTo("error-9-name-1.error-9-name-2.error-9-name-3-2");
        assertThat(Error9Name3_3Error.CODE.id()).isEqualTo("error-9-name-1.error-9-name-2.error-9-name-3-3");
        // @formatter:on
    }

    private void generateErrorsForCodeIdAndNameAreGeneratedFromErrorNameWhenNotSpecifiedTests_specialCases() {
        ExceptionsGenerator xgen = generator();
        // @formatter:off
        xgen.generate(rootError("Root_Name_9_Name1").basePackage("com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("Root-Name-9-Name2").basePackage("com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("Root__Name__9__Name3").basePackage("com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("Root--Name--9--Name4").basePackage("com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("Root_-_Name_-_9_-_Name5").basePackage("com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("RootName_6_").basePackage("com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("RootName-7-").basePackage("com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("RootName__8__").basePackage("com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("RootName--9--").basePackage("com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("RootName_-_10_-_").basePackage("com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("Root_name_9_name11").basePackage("com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        xgen.generate(rootError("Root-name_9_name12").basePackage("com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases").build());
        // @formatter:on
    }


    @Test
    public void codeNameIsGeneratedFromErrorNameWhenNotSpecified_specialCases() {
        assertThat(Root_Name_9_Name1Error.CODE.name()).isEqualTo("root-name-9-name-1");
        assertThat(Root_Name_9_Name2Error.CODE.name()).isEqualTo("root-name-9-name-2");
        assertThat(Root__Name__9__Name3Error.CODE.name()).isEqualTo("root-name-9-name-3");
        assertThat(Root__Name__9__Name4Error.CODE.name()).isEqualTo("root-name-9-name-4");
        assertThat(Root___Name___9___Name5Error.CODE.name()).isEqualTo("root-name-9-name-5");
        assertThat(RootName_6_Error.CODE.name()).isEqualTo("root-name-6");
        assertThat(RootName_7_Error.CODE.name()).isEqualTo("root-name-7");
        assertThat(RootName__8__Error.CODE.name()).isEqualTo("root-name-8");
        assertThat(RootName__9__Error.CODE.name()).isEqualTo("root-name-9");
        assertThat(RootName___10___Error.CODE.name()).isEqualTo("root-name-10");
        assertThat(Root_name_9_name11Error.CODE.name()).isEqualTo("root-name-9-name-11");
        assertThat(Root_name_9_name12Error.CODE.name()).isEqualTo("root-name-9-name-12");
    }

    @Test
    public void codeIdIsGeneratedFromErrorNameWhenNotSpecified_specialCases() {
        assertThat(Root_Name_9_Name1Error.CODE.id()).isEqualTo("root-name-9-name-1");
        assertThat(Root_Name_9_Name2Error.CODE.id()).isEqualTo("root-name-9-name-2");
        assertThat(Root__Name__9__Name3Error.CODE.id()).isEqualTo("root-name-9-name-3");
        assertThat(Root__Name__9__Name4Error.CODE.id()).isEqualTo("root-name-9-name-4");
        assertThat(Root___Name___9___Name5Error.CODE.id()).isEqualTo("root-name-9-name-5");
        assertThat(RootName_6_Error.CODE.id()).isEqualTo("root-name-6");
        assertThat(RootName_7_Error.CODE.id()).isEqualTo("root-name-7");
        assertThat(RootName__8__Error.CODE.id()).isEqualTo("root-name-8");
        assertThat(RootName__9__Error.CODE.id()).isEqualTo("root-name-9");
        assertThat(RootName___10___Error.CODE.id()).isEqualTo("root-name-10");
        assertThat(Root_name_9_name11Error.CODE.id()).isEqualTo("root-name-9-name-11");
        assertThat(Root_name_9_name12Error.CODE.id()).isEqualTo("root-name-9-name-12");
    }

    private void generateErrorsForCodeIdAndNameAreGeneratedOnAMixedSituationTests() {
        // @formatter:off
        generator().generate(rootError("RootName").errors(
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
        ).basePackage("com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation").build());
        // @formatter:on
    }

    @Test
    public void codeNameIsGeneratedOnAMixedSituation() {
        // @formatter:off
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.RootNameError.CODE.name())
                .isEqualTo("root-name");

        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_c1.C1Error.CODE.name())
                .isEqualTo("code-name-c1");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_c1.common_name2.CommonName2Error.CODE.name())
                .isEqualTo("common-name-2");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_c1.common_name2.common_name3_1.CommonName3_1Error.CODE.name())
                .isEqualTo("common-name-3-1");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_c1.common_name2.code_name_c3_2.C3_2Error.CODE.name())
                .isEqualTo("code-name-c3-2");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_c1.common_name2.common_name3_3.CommonName3_3Error.CODE.name())
                .isEqualTo("common-name-3-3");

        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_e1.E1Error.CODE.name())
                .isEqualTo("code-name-e1");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_e1.error_name2.ErrorName2Error.CODE.name())
                .isEqualTo("error-name-2");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_e1.error_name2.error_name3_1.ErrorName3_1Error.CODE.name())
                .isEqualTo("error-name-3-1");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_e1.error_name2.code_name_e3_2.E3_2Error.CODE.name())
                .isEqualTo("code-name-e3-2");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_e1.error_name2.error_name3_3.ErrorName3_3Error.CODE.name())
                .isEqualTo("error-name-3-3");
        // @formatter:on
    }

    @Test
    public void codeIdIsGeneratedOnAMixedSituation() {
        // @formatter:off
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.RootNameError.CODE.id())
                .isEqualTo("root-name");

        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_c1.C1Error.CODE.id())
                .isEqualTo("code-name-c1");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_c1.common_name2.CommonName2Error.CODE.id())
                .isEqualTo("code-name-c1.common-name-2");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_c1.common_name2.common_name3_1.CommonName3_1Error.CODE.id())
                .isEqualTo("code-name-c1.common-name-2.common-name-3-1");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_c1.common_name2.code_name_c3_2.C3_2Error.CODE.id())
                .isEqualTo("code-name-c1.common-name-2.code-name-c3-2");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_c1.common_name2.common_name3_3.CommonName3_3Error.CODE.id())
                .isEqualTo("code-name-c1.common-name-2.common-name-3-3");

        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_e1.E1Error.CODE.id())
                .isEqualTo("code-name-e1");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_e1.error_name2.ErrorName2Error.CODE.id())
                .isEqualTo("code-name-e1.error-name-2");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_e1.error_name2.error_name3_1.ErrorName3_1Error.CODE.id())
                .isEqualTo("code-name-e1.error-name-2.error-name-3-1");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_e1.error_name2.code_name_e3_2.E3_2Error.CODE.id())
                .isEqualTo("code-name-e1.error-name-2.code-name-e3-2");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_e1.error_name2.error_name3_3.ErrorName3_3Error.CODE.id())
                .isEqualTo("code-name-e1.error-name-2.error-name-3-3");
        // @formatter:on
    }

    public void generateErrorsForCodeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecifiedTests() {
        // @formatter:off
        generator().generate(rootError("Root").code("code-name-root", 1).errors(
                error("E1").code("code-name-e1", 2).errors(
                        error("E2").code("code-name-e2", 3).errors(
                                error("E3_1").code("code-name-e3-1", 4).description("ABCDE"),
                                error("E3_2").code("code-name-e3-2").code(5).description("ABCDE"),
                                error("E3_3").code(6).code("code-name-e3-3").description("ABCDE")
                        )
                )
        ).basePackage("com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified").build());
        // @formatter:on
    }

    @Test
    public void codeNameIsGeneratedWhenNumberIsAlsoSpecifiedSpecified() {
        // @formatter:off
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.RootError.CODE.name()).isEqualTo("code-name-root");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.code_name_e1.E1Error.CODE.name()).isEqualTo("code-name-e1");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.code_name_e1.code_name_e2.E2Error.CODE.name()).isEqualTo("code-name-e2");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.code_name_e1.code_name_e2.code_name_e3_1.E3_1Error.CODE.name()).isEqualTo("code-name-e3-1");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.code_name_e1.code_name_e2.code_name_e3_2.E3_2Error.CODE.name()).isEqualTo("code-name-e3-2");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.code_name_e1.code_name_e2.code_name_e3_3.E3_3Error.CODE.name()).isEqualTo("code-name-e3-3");
        // @formatter:on
    }

    @Test
    public void codeIdIsGeneratedWhenNumberIsAlsoSpecifiedSpecified() {
        // @formatter:off
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.RootError.CODE.id()).isEqualTo("code-name-root");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.code_name_e1.E1Error.CODE.id()).isEqualTo("code-name-e1");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.code_name_e1.code_name_e2.E2Error.CODE.id()).isEqualTo("code-name-e1.code-name-e2");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.code_name_e1.code_name_e2.code_name_e3_1.E3_1Error.CODE.id()).isEqualTo("code-name-e1.code-name-e2.code-name-e3-1");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.code_name_e1.code_name_e2.code_name_e3_2.E3_2Error.CODE.id()).isEqualTo("code-name-e1.code-name-e2.code-name-e3-2");
        assertThat(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.code_name_e1.code_name_e2.code_name_e3_3.E3_3Error.CODE.id()).isEqualTo("code-name-e1.code-name-e2.code-name-e3-3");
        // @formatter:on
    }
}
