package com.rodrigodev.xgen.test.naming;

import com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration;
import org.junit.Test;

import java.util.function.Consumer;

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
}
