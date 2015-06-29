package com.rodrigodev.xgen.test.naming;

import com.rodrigodev.xgen.ExceptionsGenerator;
import com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration;
import com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores.*;
import org.junit.Test;

import java.util.function.Consumer;

import static com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration.rootError;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 23/06/15.
 */
public class NamingTests {

    private void assert_errorNameMustBeginWithUpperCaseLetter(Consumer<String> methodCall) {
        String invalidCharacters = "a_1-$%";
        for (char invalidCharacter : invalidCharacters.toCharArray()) {
            String invalidName = invalidCharacter + "abcde";

            assertThatThrownBy(() -> methodCall.accept(invalidName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(String.format("Error name '%s' has invalid format.", invalidName));
        }
    }

    @Test
    public void errorNameMustBeginWithUpperCaseLetter() {
        assert_errorNameMustBeginWithUpperCaseLetter(ErrorConfiguration::rootError);
        assert_errorNameMustBeginWithUpperCaseLetter(ErrorConfiguration::commonError);
        assert_errorNameMustBeginWithUpperCaseLetter(ErrorConfiguration::error);
    }

    private void assert_errorNameMustOnlyHaveLettersNumbersHyphensOrUnderscores(Consumer<String> methodCall) {
        String invalidCharacters = "!@#$%^&*()+";
        for (char invalidCharacter : invalidCharacters.toCharArray()) {
            String invalidName = "Name" + invalidCharacter;

            assertThatThrownBy(() -> methodCall.accept(invalidName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(String.format("Error name '%s' has invalid format.", invalidName));
        }
    }

    @Test
    public void errorNameMustOnlyHaveLettersNumbersHyphensOrUnderscores() {
        assert_errorNameMustOnlyHaveLettersNumbersHyphensOrUnderscores(ErrorConfiguration::rootError);
        assert_errorNameMustOnlyHaveLettersNumbersHyphensOrUnderscores(ErrorConfiguration::commonError);
        assert_errorNameMustOnlyHaveLettersNumbersHyphensOrUnderscores(ErrorConfiguration::error);
    }

    @Test
    public void ifErrorNameHasHyphensTheyAreConvertedToUnderscores() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
        // @formatter:off
        xgen.generate(rootError("Root_Name1").basePackage("com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores").build());
        xgen.generate(rootError("Root-Name2").basePackage("com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores").build());
        xgen.generate(rootError("Root__Name3").basePackage("com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores").build());
        xgen.generate(rootError("Root--Name4").basePackage("com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores").build());
        xgen.generate(rootError("Root_-_Name5").basePackage("com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores").build());
        xgen.generate(rootError("RootName6_").basePackage("com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores").build());
        xgen.generate(rootError("RootName7-").basePackage("com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores").build());
        xgen.generate(rootError("RootName8__").basePackage("com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores").build());
        xgen.generate(rootError("RootName9--").basePackage("com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores").build());
        xgen.generate(rootError("RootName10_-_").basePackage("com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores").build());
        xgen.generate(rootError("Root_name11").basePackage("com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores").build());
        xgen.generate(rootError("Root-name12").basePackage("com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores").build());
        // @formatter:on

        //Next code should compile
        Root_Name1Error.class.getName();
        Root_Name2Error.class.getName();
        Root__Name3Error.class.getName();
        Root__Name4Error.class.getName();
        Root___Name5Error.class.getName();
        RootName6_Error.class.getName();
        RootName7_Error.class.getName();
        RootName8__Error.class.getName();
        RootName9__Error.class.getName();
        RootName10___Error.class.getName();
        Root_name11Error.class.getName();
        Root_name12Error.class.getName();
    }
}
