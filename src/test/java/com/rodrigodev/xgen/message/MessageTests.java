package com.rodrigodev.xgen.message;

import com.rodrigodev.xgen.ExceptionsGenerator;
import com.rodrigodev.xgen.test.message.descriptionIsEmpty.E3Error;
import org.junit.Test;

import static com.rodrigodev.xgen.configuration.ErrorConfiguration.baseError;
import static com.rodrigodev.xgen.configuration.ErrorConfiguration.error;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
public class MessageTests {

    @Test
    public void descriptionIsEmpty() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
        // @formatter:off
        xgen.generate(baseError("Root").errors(
                error("E1").errors(
                        error("E2").errors(
                                error("E3").description("")
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.message.descriptionIsEmpty").build());
        // @formatter:on

        assertThatThrownBy(E3Error::throwException).hasMessage("");
    }

    private void assert_noParamsForDescription(int testId, String description) {

    }

    @Test
    public void noParamsForDescription() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
        // @formatter:off
        xgen.generate(baseError("Root").errors(
                error("E1").errors(
                        error("E2").errors(
                                error("E3").description("Some description.")
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.message.noParamsForDescription").build());
        // @formatter:on

        assertThatThrownBy(com.rodrigodev.xgen.test.message.noParamsForDescription.E3Error::throwException)
                .hasMessage("Some description.");
    }
}
