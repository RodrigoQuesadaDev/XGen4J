package com.rodrigodev.xgen.test.naming;

import com.rodrigodev.xgen.ExceptionsGenerator;
import com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration;
import com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores.*;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;

import static com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 23/06/15.
 */
public class ErrorNamingTests {

    private void assert_errorNameHasInvalidFormat(Consumer<String> methodCall, String invalidName) {
        assertThatThrownBy(() -> methodCall.accept(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("Error name '%s' has invalid format.", invalidName));
    }

    private void assert_errorNameMustNotContainGivenCharacters(
            Consumer<String> methodCall, String invalidCharacters, Function<Character, String> invalidPartSupplier
    ) {
        for (char invalidCharacter : invalidCharacters.toCharArray()) {
            String invalidName = invalidPartSupplier.apply(invalidCharacter);

            assert_errorNameHasInvalidFormat(methodCall, invalidName);
        }
    }

    private void assert_errorNameMustNotStartWithGivenCharacters(Consumer<String> methodCall) {
        assert_errorNameMustNotContainGivenCharacters(methodCall, "a_1-!@#$%^&*()+.", c -> c + "abcde");
    }

    private void assert_errorNameCanBeginWithUpperCaseLetter() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
        // @formatter:off
        xgen.generate(rootError("RootName").basePackage("com.rodrigodev.xgen.test.naming.errorNameCanBeginWithUpperCaseLetter").build());
        // @formatter:on

        //Next code should compile
        com.rodrigodev.xgen.test.naming.errorNameCanBeginWithUpperCaseLetter.RootNameError.class.getName();
    }

    @Test
    public void errorNameMustBeginWithUpperCaseLetter() {
        assert_errorNameMustNotStartWithGivenCharacters(ErrorConfiguration::rootError);
        assert_errorNameMustNotStartWithGivenCharacters(ErrorConfiguration::commonError);
        assert_errorNameMustNotStartWithGivenCharacters(ErrorConfiguration::error);
        assert_errorNameCanBeginWithUpperCaseLetter();
    }

    private void assert_errorNameMustNotContainGivenCharacters(Consumer<String> methodCall) {
        assert_errorNameMustNotContainGivenCharacters(methodCall, "!@#$%^&*()+.", c -> "Name" + c);
    }

    private void assert_errorNameCanContainLettersNumbersHyphensOrUnderscores() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
        // @formatter:off
        xgen.generate(rootError("RootName").basePackage("com.rodrigodev.xgen.test.naming.errorNameCanContainLettersNumbersHyphensOrUnderscores").build());
        xgen.generate(rootError("Root1Name1").basePackage("com.rodrigodev.xgen.test.naming.errorNameCanContainLettersNumbersHyphensOrUnderscores").build());
        xgen.generate(rootError("Root-Name2-").basePackage("com.rodrigodev.xgen.test.naming.errorNameCanContainLettersNumbersHyphensOrUnderscores").build());
        xgen.generate(rootError("Root_Name3_").basePackage("com.rodrigodev.xgen.test.naming.errorNameCanContainLettersNumbersHyphensOrUnderscores").build());
        // @formatter:on

        //Next code should compile
        com.rodrigodev.xgen.test.naming.errorNameCanContainLettersNumbersHyphensOrUnderscores.RootNameError.class.getName();
        com.rodrigodev.xgen.test.naming.errorNameCanContainLettersNumbersHyphensOrUnderscores.Root1Name1Error.class.getName();
        com.rodrigodev.xgen.test.naming.errorNameCanContainLettersNumbersHyphensOrUnderscores.Root_Name2_Error.class.getName();
        com.rodrigodev.xgen.test.naming.errorNameCanContainLettersNumbersHyphensOrUnderscores.Root_Name3_Error.class.getName();
    }

    @Test
    public void errorNameMustOnlyContainLettersNumbersHyphensOrUnderscores() {
        assert_errorNameMustNotContainGivenCharacters(ErrorConfiguration::rootError);
        assert_errorNameMustNotContainGivenCharacters(ErrorConfiguration::commonError);
        assert_errorNameMustNotContainGivenCharacters(ErrorConfiguration::error);
        assert_errorNameCanContainLettersNumbersHyphensOrUnderscores();
    }

    @Test
    public void ifErrorNameHasHyphensTheyAreConvertedToUnderscores() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
        // @formatter:off
        xgen.generate(rootError("Root_Name1_").basePackage("com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores").build());
        xgen.generate(rootError("Root-Name2-").basePackage("com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores").build());
        xgen.generate(rootError("Root__Name3__").basePackage("com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores").build());
        xgen.generate(rootError("Root--Name4--").basePackage("com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores").build());
        xgen.generate(rootError("Root_-_Name5_-_").basePackage("com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores").build());
        xgen.generate(rootError("Root_name6").basePackage("com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores").build());
        xgen.generate(rootError("Root-name7").basePackage("com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores").build());
        // @formatter:on

        //Next code should compile
        Root_Name1_Error.class.getName();
        Root_Name2_Error.class.getName();
        Root__Name3__Error.class.getName();
        Root__Name4__Error.class.getName();
        Root___Name5___Error.class.getName();
        Root_name6Error.class.getName();
        Root_name7Error.class.getName();
    }

    @Test
    public void errorNameCannotBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesInTheSameHierarchyPath() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");

        assertThatThrownBy(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").errors(
                                error("EName1").errors(
                                        error("EName2").errors(
                                                error("EName3_1").description("ABCDE"),
                                                error("EName1").description("ABCDE"),
                                                error("EName3_3").description("ABCDE")
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen.test.naming.errorNameCannotBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesInTheSameHierarchyPath").build())
                        // @formatter:on
        ).isInstanceOf(IllegalStateException.class)
                .hasMessage("Error cannot have name 'EName1' because an ancestor error has 'EName1' as name.");
        assertThatThrownBy(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").errors(
                                error("EName1").errors(
                                        error("RootName").errors(
                                                error("EName3_1").description("ABCDE"),
                                                error("EName3_2").description("ABCDE"),
                                                error("EName3_3").description("ABCDE")
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen.test.naming.errorNameCannotBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesInTheSameHierarchyPath").build())
                        // @formatter:on
        ).isInstanceOf(IllegalStateException.class)
                .hasMessage("Error cannot have name 'RootName' because an ancestor error has 'RootName' as name.");
        assertThatThrownBy(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").errors(
                                error("E_Name1").errors(
                                        error("EName2").errors(
                                                error("EName3_1").description("ABCDE"),
                                                error("E-Name1").description("ABCDE"),
                                                error("EName3_3").description("ABCDE")
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen.test.naming.errorNameCannotBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesInTheSameHierarchyPath").build())
                        // @formatter:on
        ).isInstanceOf(IllegalStateException.class)
                .hasMessage("Error cannot have name 'E-Name1' because an ancestor error has 'E_Name1' as name.");
        assertThatThrownBy(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("Root_Name").errors(
                                error("EName1").errors(
                                        error("Root-Name").errors(
                                                error("EName3_1").description("ABCDE"),
                                                error("EName3_1").description("ABCDE"),
                                                error("EName3_3").description("ABCDE")
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen.test.naming.errorNameCannotBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesInTheSameHierarchyPath").build())
                        // @formatter:on
        ).isInstanceOf(IllegalStateException.class)
                .hasMessage("Error cannot have name 'Root-Name' because an ancestor error has 'Root_Name' as name.");
    }

    @Test
    public void errorNameCannotBeTheSameOrGenerateTheSamePackagePartForTwoGivenSiblingErrorClasses() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");

        assertThatThrownBy(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").errors(
                                error("EName1").errors(
                                        error("EName2").errors(
                                                error("EName3_1").description("ABCDE"),
                                                error("EName3_2").description("ABCDE"),
                                                error("EName3_1").description("ABCDE")
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen.test.naming.errorNameCannotBeTheSameOrGenerateTheSamePackagePartForTwoGivenSiblingErrorClasses").build())
                        // @formatter:on
        ).isInstanceOf(IllegalStateException.class)
                .hasMessage("Error cannot have name 'EName3_1' because a sibling error has 'EName3_1' as name.");
        assertThatThrownBy(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").errors(
                                error("EName1").errors(
                                        error("EName2").errors(
                                                error("EName3_1").description("ABCDE"),
                                                error("EName3_2").description("ABCDE"),
                                                error("EName3_3").description("ABCDE")
                                        ),
                                        error("EName2").errors(
                                                error("EName4_1").description("ABCDE"),
                                                error("EName4_2").description("ABCDE"),
                                                error("EName4_3").description("ABCDE")
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen.test.naming.errorNameCannotBeTheSameOrGenerateTheSamePackagePartForTwoGivenSiblingErrorClasses").build())
                        // @formatter:on
        ).isInstanceOf(IllegalStateException.class)
                .hasMessage("Error cannot have name 'EName2' because a sibling error has 'EName2' as name.");
        assertThatThrownBy(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").errors(
                                error("EName1").errors(
                                        error("EName2").errors(
                                                error("EName3_1").description("ABCDE"),
                                                error("EName3_2").description("ABCDE"),
                                                error("EName3-1").description("ABCDE")
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen.test.naming.errorNameCannotBeTheSameOrGenerateTheSamePackagePartForTwoGivenSiblingErrorClasses").build())
                        // @formatter:on
        ).isInstanceOf(IllegalStateException.class)
                .hasMessage("Error cannot have name 'EName3-1' because a sibling error has 'EName3_1' as name.");
        assertThatThrownBy(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").errors(
                                error("EName1").errors(
                                        error("E_Name2").errors(
                                                error("EName3_1").description("ABCDE"),
                                                error("EName3_2").description("ABCDE"),
                                                error("EName3_3").description("ABCDE")
                                        ),
                                        error("E-Name2").errors(
                                                error("EName4_1").description("ABCDE"),
                                                error("EName4_2").description("ABCDE"),
                                                error("EName4_3").description("ABCDE")
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen.test.naming.errorNameCannotBeTheSameOrGenerateTheSamePackagePartForTwoGivenSiblingErrorClasses").build())
                        // @formatter:on
        ).isInstanceOf(IllegalStateException.class)
                .hasMessage("Error cannot have name 'E-Name2' because a sibling error has 'E_Name2' as name.");
    }

    @Test
    public void errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
        // @formatter:off
        xgen.generate(rootError("RootName").errors(
                commonError("CName1").errors(
                        error("SameName2").errors(
                                error("SameName3_1").description("ABCDE"),
                                error("SameName3_2").description("ABCDE"),
                                error("SameName3_3").description("ABCDE"),
                                error("SameName3_4").description("ABCDE")
                        )
                ),
                error("SameName3_4").errors(
                        error("SameName2").errors(
                                error("SameName3_1").description("ABCDE"),
                                error("SameName3_2").description("ABCDE"),
                                error("SameName3_3").description("ABCDE")
                        )
                ),
                error("E2Name1").errors(
                        error("SameName2").errors(
                                error("SameName3_1").description("ABCDE"),
                                error("SameName3_2").description("ABCDE"),
                                error("SameName3_3").description("ABCDE")
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship").build());

        //Next code should compile
        com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.RootNameError.class.getName();
        com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.cname1.CName1Error.class.getName();
        com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.cname1.same_name2.SameName2Error.class.getName();
        com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.cname1.same_name2.same_name3_1.SameName3_1Error.class.getName();
        com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.cname1.same_name2.same_name3_2.SameName3_2Error.class.getName();
        com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.cname1.same_name2.same_name3_3.SameName3_3Error.class.getName();
        com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.cname1.same_name2.same_name3_4.SameName3_4Error.class.getName();
        com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.same_name3_4.SameName3_4Error.class.getName();
        com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.same_name3_4.same_name2.SameName2Error.class.getName();
        com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.same_name3_4.same_name2.same_name3_1.SameName3_1Error.class.getName();
        com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.same_name3_4.same_name2.same_name3_2.SameName3_2Error.class.getName();
        com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.same_name3_4.same_name2.same_name3_3.SameName3_3Error.class.getName();
        com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.e2name1.E2Name1Error.class.getName();
        com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.e2name1.same_name2.SameName2Error.class.getName();
        com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.e2name1.same_name2.same_name3_1.SameName3_1Error.class.getName();
        com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.e2name1.same_name2.same_name3_2.SameName3_2Error.class.getName();
        com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.e2name1.same_name2.same_name3_3.SameName3_3Error.class.getName();
        // @formatter:on
    }
}
