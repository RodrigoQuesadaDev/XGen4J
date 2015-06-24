package com.rodrigodev.xgen.naming;

import com.rodrigodev.xgen.configuration.ErrorConfiguration;
import org.junit.Test;

import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 23/06/15.
 */
public class NamingTests {

    private void assert_errorNameDoesNotBeginWithUpperCaseLetter(Consumer<String> methodCall) {
        String invalidCharacters = "a_1-$%";
        for (char invalidCharacter : invalidCharacters.toCharArray()) {
            String invalidName = invalidCharacter + "abcde";

            assertThatThrownBy(() -> methodCall.accept(invalidName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(String.format("Error name '%s' has invalid format.", invalidName));
        }
    }

    @Test
    public void errorNameDoesNotBeginWithUpperCaseLetter() {
        assert_errorNameDoesNotBeginWithUpperCaseLetter(ErrorConfiguration::baseError);
        assert_errorNameDoesNotBeginWithUpperCaseLetter(ErrorConfiguration::commonError);
        assert_errorNameDoesNotBeginWithUpperCaseLetter(ErrorConfiguration::error);
    }

    private void assert_errorNameHasInvalidCharacters_anIllegalArgumentExceptionIsThrown(Consumer<String> methodCall) {
        String invalidCharacters = "!@#$%^&*()+";
        for (char invalidCharacter : invalidCharacters.toCharArray()) {
            String invalidName = "Name" + invalidCharacter;

            assertThatThrownBy(() -> methodCall.accept(invalidName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(String.format("Error name '%s' has invalid format.", invalidName));
        }
    }

    @Test
    public void errorNameHasInvalidCharacters_anIllegalArgumentExceptionIsThrown() {
        assert_errorNameHasInvalidCharacters_anIllegalArgumentExceptionIsThrown(ErrorConfiguration::baseError);
        assert_errorNameHasInvalidCharacters_anIllegalArgumentExceptionIsThrown(ErrorConfiguration::commonError);
        assert_errorNameHasInvalidCharacters_anIllegalArgumentExceptionIsThrown(ErrorConfiguration::error);
    }
}
