package com.rodrigodev.xgen.naming;

import com.rodrigodev.xgen.configuration.ErrorConfiguration;
import org.junit.Test;

import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 23/06/15.
 */
public class NamingTests {

    private void assert_errorNameMustNotBeginWithUpperCaseLetter(Consumer<String> methodCall) {
        String invalidCharacters = "a_1-$%";
        for (char invalidCharacter : invalidCharacters.toCharArray()) {
            String invalidName = invalidCharacter + "abcde";

            assertThatThrownBy(() -> methodCall.accept(invalidName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(String.format("Error name '%s' has invalid format.", invalidName));
        }
    }

    @Test
    public void errorNameMustNotBeginWithUpperCaseLetter() {
        assert_errorNameMustNotBeginWithUpperCaseLetter(ErrorConfiguration::baseError);
        assert_errorNameMustNotBeginWithUpperCaseLetter(ErrorConfiguration::commonError);
        assert_errorNameMustNotBeginWithUpperCaseLetter(ErrorConfiguration::error);
    }

    private void assert_errorNameHasOnlyValidCharacters(Consumer<String> methodCall) {
        String invalidCharacters = "!@#$%^&*()+";
        for (char invalidCharacter : invalidCharacters.toCharArray()) {
            String invalidName = "Name" + invalidCharacter;

            assertThatThrownBy(() -> methodCall.accept(invalidName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(String.format("Error name '%s' has invalid format.", invalidName));
        }
    }

    @Test
    public void errorNameMustHaveOnlyValidCharacters() {
        assert_errorNameHasOnlyValidCharacters(ErrorConfiguration::baseError);
        assert_errorNameHasOnlyValidCharacters(ErrorConfiguration::commonError);
        assert_errorNameHasOnlyValidCharacters(ErrorConfiguration::error);
    }
}
