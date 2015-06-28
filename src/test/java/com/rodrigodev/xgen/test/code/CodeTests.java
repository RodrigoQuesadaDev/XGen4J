package com.rodrigodev.xgen.test.code;

import com.rodrigodev.xgen.ExceptionsGenerator;
import com.rodrigodev.xgen.test.code.codeNameIsGenerated.ErrorCode;
import com.rodrigodev.xgen.test.code.codeNameIsGenerated.RootError;
import com.rodrigodev.xgen.test.code.codeNameIsGenerated.c1.C1Error;
import com.rodrigodev.xgen.test.code.codeNameIsGenerated.c1.c2.C2Error;
import com.rodrigodev.xgen.test.code.codeNameIsGenerated.c1.c2.c3_1.C3_1Error;
import com.rodrigodev.xgen.test.code.codeNameIsGenerated.c1.c2.c3_2.C3_2Error;
import com.rodrigodev.xgen.test.code.codeNameIsGenerated.c1.c2.c3_3.C3_3Error;
import com.rodrigodev.xgen.test.code.codeNameIsGenerated.e1.E1Error;
import com.rodrigodev.xgen.test.code.codeNameIsGenerated.e1.e2.E2Error;
import com.rodrigodev.xgen.test.code.codeNameIsGenerated.e1.e2.e3_1.E3_1Error;
import com.rodrigodev.xgen.test.code.codeNameIsGenerated.e1.e2.e3_2.E3_2Error;
import com.rodrigodev.xgen.test.code.codeNameIsGenerated.e1.e2.e3_3.E3_3Error;
import org.junit.Test;

import static com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration.error;
import static com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration.rootError;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 25/06/15.
 */
public class CodeTests {

    @Test
    public void codeNameIsGenerated() {
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
        ).basePackage("com.rodrigodev.xgen.test.code.codeNameIsGenerated").build());
        // @formatter:on

        assertThat(RootError.CODE).isEqualTo(new ErrorCode("code-name-root"));

        assertThat(C1Error.CODE).isEqualTo(new ErrorCode("code-name-root.code-name-c1"));
        assertThat(C2Error.CODE).isEqualTo(new ErrorCode("code-name-root.code-name-c1.code-name-c2"));
        assertThat(C3_1Error.CODE).isEqualTo(new ErrorCode("code-name-root.code-name-c1.code-name-c2.code-name-c3-1"));
        assertThat(C3_2Error.CODE).isEqualTo(new ErrorCode("code-name-root.code-name-c1.code-name-c2.code-name-c3-2"));
        assertThat(C3_3Error.CODE).isEqualTo(new ErrorCode("code-name-root.code-name-c1.code-name-c2.code-name-c3-3"));

        assertThat(E1Error.CODE).isEqualTo(new ErrorCode("code-name-root.code-name-e1"));
        assertThat(E2Error.CODE).isEqualTo(new ErrorCode("code-name-root.code-name-e1.code-name-e2"));
        assertThat(E3_1Error.CODE).isEqualTo(new ErrorCode("code-name-root.code-name-e1.code-name-e2.code-name-e3-1"));
        assertThat(E3_2Error.CODE).isEqualTo(new ErrorCode("code-name-root.code-name-e1.code-name-e2.code-name-e3-2"));
        assertThat(E3_3Error.CODE).isEqualTo(new ErrorCode("code-name-root.code-name-e1.code-name-e2.code-name-e3-3"));
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
    public void nameCanOnlyContainLowercaseLettersNumbersOrHyphens() {
        String invalidCharacters = "A!@#$%^&*()+_";
        for (char invalidCharacter : invalidCharacters.toCharArray()) {
            String invalidName = "name" + invalidCharacter;

            assertThatThrownBy(() -> rootError("Root").code(invalidName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(String.format("Error code's name '%s' has invalid format.", invalidName));
        }
    }

    //TODO test parent code exists?

    //TODO code name should not be optional in CodeDefinition
}
