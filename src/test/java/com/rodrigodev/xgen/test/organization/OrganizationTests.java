package com.rodrigodev.xgen.test.organization;

import com.rodrigodev.xgen.ExceptionsGenerator;
import com.rodrigodev.xgen.test.organization.hierarchy.RootError;
import com.rodrigodev.xgen.test.organization.hierarchy.RootException;
import com.rodrigodev.xgen.test.organization.hierarchy.c1.C1Error;
import com.rodrigodev.xgen.test.organization.hierarchy.c1.C1Exception;
import com.rodrigodev.xgen.test.organization.hierarchy.c1.c2.C2Error;
import com.rodrigodev.xgen.test.organization.hierarchy.c1.c2.C2Exception;
import com.rodrigodev.xgen.test.organization.hierarchy.c1.c2.c3_1.C3_1Error;
import com.rodrigodev.xgen.test.organization.hierarchy.c1.c2.c3_1.C3_1Exception;
import com.rodrigodev.xgen.test.organization.hierarchy.c1.c2.c3_2.C3_2Error;
import com.rodrigodev.xgen.test.organization.hierarchy.c1.c2.c3_2.C3_2Exception;
import com.rodrigodev.xgen.test.organization.hierarchy.c1.c2.c3_3.C3_3Error;
import com.rodrigodev.xgen.test.organization.hierarchy.c1.c2.c3_3.C3_3Exception;
import com.rodrigodev.xgen.test.organization.hierarchy.e1.E1Error;
import com.rodrigodev.xgen.test.organization.hierarchy.e1.E1Exception;
import com.rodrigodev.xgen.test.organization.hierarchy.e1.e2.E2Error;
import com.rodrigodev.xgen.test.organization.hierarchy.e1.e2.E2Exception;
import com.rodrigodev.xgen.test.organization.hierarchy.e1.e2.e3_1.E3_1Error;
import com.rodrigodev.xgen.test.organization.hierarchy.e1.e2.e3_1.E3_1Exception;
import com.rodrigodev.xgen.test.organization.hierarchy.e1.e2.e3_2.E3_2Error;
import com.rodrigodev.xgen.test.organization.hierarchy.e1.e2.e3_2.E3_2Exception;
import com.rodrigodev.xgen.test.organization.hierarchy.e1.e2.e3_3.E3_3Error;
import com.rodrigodev.xgen.test.organization.hierarchy.e1.e2.e3_3.E3_3Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.RootNameError;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.RootNameException;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.CommonName1Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.CommonName1Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.CommonName2Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.CommonName2Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.common_name3_1.CommonName3_1Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.common_name3_1.CommonName3_1Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.common_name3_2.CommonName3_2Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.common_name3_2.CommonName3_2Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.common_name3_3.CommonName3_3Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.common_name3_3.CommonName3_3Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.ErrorName1Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.ErrorName1Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.error_name2.ErrorName2Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.error_name2.ErrorName2Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.error_name2.error_name3_1.ErrorName3_1Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.error_name2.error_name3_1.ErrorName3_1Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.error_name2.error_name3_2.ErrorName3_2Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.error_name2.error_name3_2.ErrorName3_2Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.error_name2.error_name3_3.ErrorName3_3Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.error_name2.error_name3_3.ErrorName3_3Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error___name3_5___.Error___Name3_5___Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error___name3_5___.Error___Name3_5___Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error__name3_3__.Error__Name3_3__Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error__name3_3__.Error__Name3_3__Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error__name3_4__.Error__Name3_4__Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error__name3_4__.Error__Name3_4__Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name3_1_.Error_Name3_1_Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name3_1_.Error_Name3_1_Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name3_2_.Error_Name3_2_Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name3_2_.Error_Name3_2_Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name3_6.Error_name3_6Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name3_6.Error_name3_6Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name3_7.Error_name3_7Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name3_7.Error_name3_7Exception;
import org.junit.Test;

import java.util.function.Function;

import static com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
public class OrganizationTests {

    public static class HierarchyTests {

        public HierarchyTests() {
            generateErrorsForHierarchyTests();
        }

        private void generateErrorsForHierarchyTests() {

            ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");

            // @formatter:off
            xgen.generate(rootError("Root").errors(
                    commonError("C1").errors(
                            error("C2").errors(
                                    error("C3_1").description("ABCDE"),
                                    error("C3_2").description("ABCDE"),
                                    error("C3_3").description("ABCDE")
                            )
                    ),
                    error("E1").errors(
                            error("E2").errors(
                                    error("E3_1").description("ABCDE"),
                                    error("E3_2").description("ABCDE"),
                                    error("E3_3").description("ABCDE")
                            )
                    )
            ).basePackage("com.rodrigodev.xgen.test.organization.hierarchy").build());
            // @formatter:on
        }

        @Test
        public void errorClassesHaveCorrectHierarchy() {
            assertThat(RootError.class).isAssignableFrom(C1Error.class);
            assertThat(C1Error.class).isAssignableFrom(C2Error.class);
            assertThat(C2Error.class).isAssignableFrom(C3_1Error.class);
            assertThat(C2Error.class).isAssignableFrom(C3_2Error.class);
            assertThat(C2Error.class).isAssignableFrom(C3_3Error.class);

            assertThat(RootError.class).isAssignableFrom(E1Error.class);
            assertThat(E1Error.class).isAssignableFrom(E2Error.class);
            assertThat(E2Error.class).isAssignableFrom(E3_1Error.class);
            assertThat(E2Error.class).isAssignableFrom(E3_2Error.class);
            assertThat(E2Error.class).isAssignableFrom(E3_3Error.class);
        }

        @Test
        public void exceptionClassesHaveCorrectHierarchy() {
            assertThat(RootException.class).isAssignableFrom(C1Exception.class);
            assertThat(C1Exception.class).isAssignableFrom(C2Exception.class);
            assertThat(C2Exception.class).isAssignableFrom(C3_1Exception.class);
            assertThat(C2Exception.class).isAssignableFrom(C3_2Exception.class);
            assertThat(C2Exception.class).isAssignableFrom(C3_3Exception.class);

            assertThat(RootException.class).isAssignableFrom(E1Exception.class);
            assertThat(E1Exception.class).isAssignableFrom(E2Exception.class);
            assertThat(E2Exception.class).isAssignableFrom(E3_1Exception.class);
            assertThat(E2Exception.class).isAssignableFrom(E3_2Exception.class);
            assertThat(E2Exception.class).isAssignableFrom(E3_3Exception.class);
        }
    }

    public static class PackageTests {

        public PackageTests() {
            generateErrorsForPackageGeneratedFromErrorNameTests();
            generateErrorsForPackageGeneratedFromErrorNameTests_specialCases();
        }

        private void assert_basePackageHasInvalidFormat(String invalidPackage) {
            assertThatThrownBy(() -> rootError("Root").basePackage(invalidPackage))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(String.format("Base package '%s' has invalid format.", invalidPackage));
        }

        private void assert_basePackagePartsMustNotContainGivenCharacters(
                String invalidCharacters, Function<Character, String> invalidPartSupplier
        ) {
            for (char invalidCharacter : invalidCharacters.toCharArray()) {
                String invalidPart = invalidPartSupplier.apply(invalidCharacter);

                assert_basePackageHasInvalidFormat(
                        String.format("com.rodrigodev.xgen.test.organization.packages.%s", invalidPart));
                assert_basePackageHasInvalidFormat(
                        String.format("com.rodrigodev.xgen.test.organization.packages.%s.something", invalidPart));
                assert_basePackageHasInvalidFormat(
                        String.format("%s.com.rodrigodev.xgen.test.organization.packages", invalidPart));
            }
        }

        private void assert_basePackagePartsCanBeginWithLetterOrUnderscore() {
            ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
            // @formatter:off
            xgen.generate(rootError("Root").basePackage("com.rodrigodev.xgen.test.organization.packages.BasePackagePartsCanBeginWithLetterOrUnderscore").build());
            xgen.generate(rootError("Root").basePackage("com.rodrigodev.xgen.test.organization.packages.basePackagePartsCanBeginWithLetterOrUnderscore").build());
            xgen.generate(rootError("Root").basePackage("com.rodrigodev.xgen.test.organization.packages._basePackagePartsCanBeginWithLetterOrUnderscore").build());
            // @formatter:on

            //Next code should compile
            com.rodrigodev.xgen.test.organization.packages.BasePackagePartsCanBeginWithLetterOrUnderscore.RootError.class.getName();
            com.rodrigodev.xgen.test.organization.packages.basePackagePartsCanBeginWithLetterOrUnderscore.RootError.class.getName();
            com.rodrigodev.xgen.test.organization.packages._basePackagePartsCanBeginWithLetterOrUnderscore.RootError.class.getName();
        }

        @Test
        public void basePackagePartsMustBeginWithLetterOrUnderscore() {
            assert_basePackagePartsMustNotContainGivenCharacters("1-!@#$%^&*()+.", c -> c + "abcde");
            assert_basePackagePartsCanBeginWithLetterOrUnderscore();
        }

        private void assert_basePackagePartsCanContainLettersNumbersOrUnderscores() {
            ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
            // @formatter:off
            xgen.generate(rootError("Root").basePackage("com.rodrigodev.xgen.test.organization.packages.basePackagePartsCanContainLettersNumbersOrUnderscores").build());
            xgen.generate(rootError("Root").basePackage("com.rodrigodev.xgen.test.organization.packages.basePackagePartsCanContain1LettersNumbersOrUnderscores1").build());
            xgen.generate(rootError("Root").basePackage("com.rodrigodev.xgen.test.organization.packages.basePackagePartsCanContain_LettersNumbersOrUnderscores_").build());
            // @formatter:on

            //Next code should compile
            com.rodrigodev.xgen.test.organization.packages.basePackagePartsCanContainLettersNumbersOrUnderscores.RootError.class.getName();
            com.rodrigodev.xgen.test.organization.packages.basePackagePartsCanContain1LettersNumbersOrUnderscores1.RootError.class.getName();
            com.rodrigodev.xgen.test.organization.packages.basePackagePartsCanContain_LettersNumbersOrUnderscores_.RootError.class.getName();
        }

        @Test
        public void basePackagePartsMustOnlyContainLettersNumbersOrUnderscores() {
            assert_basePackagePartsMustNotContainGivenCharacters("-!@#$%^&*()+.", c -> "name" + c);
            assert_basePackagePartsMustNotContainGivenCharacters("-!@#$%^&*()+", c -> "name" + c + "suffix");
            assert_basePackagePartsCanContainLettersNumbersOrUnderscores();
        }

        private void generateErrorsForPackageGeneratedFromErrorNameTests() {

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
            ).basePackage("com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames").build());
            // @formatter:on
        }

        @Test
        public void noCodeNameIsProvided_packagesForErrorsAreGeneratedFromErrorNames() {
            assertThat(RootNameError.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames");

            assertThat(CommonName1Error.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1");
            assertThat(CommonName2Error.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2");
            assertThat(CommonName3_1Error.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.common_name3_1");
            assertThat(CommonName3_2Error.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.common_name3_2");
            assertThat(CommonName3_3Error.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.common_name3_3");

            assertThat(ErrorName1Error.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1");
            assertThat(ErrorName2Error.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.error_name2");
            assertThat(ErrorName3_1Error.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.error_name2.error_name3_1");
            assertThat(ErrorName3_2Error.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.error_name2.error_name3_2");
            assertThat(ErrorName3_3Error.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.error_name2.error_name3_3");
        }

        @Test
        public void noCodeNameIsProvided_packagesForExceptionsAreGeneratedFromErrorNames() {
            assertThat(RootNameException.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames");

            assertThat(CommonName1Exception.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1");
            assertThat(CommonName2Exception.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2");
            assertThat(CommonName3_1Exception.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.common_name3_1");
            assertThat(CommonName3_2Exception.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.common_name3_2");
            assertThat(CommonName3_3Exception.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.common_name3_3");

            assertThat(ErrorName1Exception.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1");
            assertThat(ErrorName2Exception.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.error_name2");
            assertThat(ErrorName3_1Exception.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.error_name2.error_name3_1");
            assertThat(ErrorName3_2Exception.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.error_name2.error_name3_2");
            assertThat(ErrorName3_3Exception.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.error_name2.error_name3_3");
        }

        private void generateErrorsForPackageGeneratedFromErrorNameTests_specialCases() {

            ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");

            // @formatter:off
            xgen.generate(rootError("RootName").errors(
                    error("ErrorName1").errors(
                            error("ErrorName2").errors(
                                    error("Error_Name3_1_"),
                                    error("Error-Name3_2-"),
                                    error("Error__Name3_3__"),
                                    error("Error--Name3_4--"),
                                    error("Error_-_Name3_5_-_"),
                                    error("Error_name3_6"),
                                    error("Error-name3_7")
                            )
                    )
            ).basePackage("com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases").build());
            // @formatter:on
        }

        @Test
        public void noCodeNameIsProvided_packagesForErrorsAreGeneratedFromErrorNames_specialCases() {

            assertThat(Error_Name3_1_Error.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name3_1_");
            assertThat(Error_Name3_2_Error.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name3_2_");
            assertThat(Error__Name3_3__Error.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error__name3_3__");
            assertThat(Error__Name3_4__Error.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error__name3_4__");
            assertThat(Error___Name3_5___Error.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error___name3_5___");
            assertThat(Error_name3_6Error.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name3_6");
            assertThat(Error_name3_7Error.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name3_7");
        }

        @Test
        public void noCodeNameIsProvided_packagesForExceptionsAreGeneratedFromErrorNames_specialCases() {

            assertThat(Error_Name3_1_Exception.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name3_1_");
            assertThat(Error_Name3_2_Exception.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name3_2_");
            assertThat(Error__Name3_3__Exception.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error__name3_3__");
            assertThat(Error__Name3_4__Exception.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error__name3_4__");
            assertThat(Error___Name3_5___Exception.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error___name3_5___");
            assertThat(Error_name3_6Exception.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name3_6");
            assertThat(Error_name3_7Exception.class.getPackage().getName()).isEqualTo(
                    "com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name3_7");
        }
    }
}
