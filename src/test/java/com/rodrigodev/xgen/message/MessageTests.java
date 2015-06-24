package com.rodrigodev.xgen.message;

import com.rodrigodev.xgen.ExceptionsGenerator;
import com.rodrigodev.xgen.test.message.noParamsForDescription.e1.e2.e3.E3Error;
import org.junit.Test;

import static com.rodrigodev.xgen.configuration.ErrorConfiguration.baseError;
import static com.rodrigodev.xgen.configuration.ErrorConfiguration.error;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
public class MessageTests {

    @Test
    public void descriptionIsEmpty_anIllegalArgumentExceptionIsThrown() {
        assertThatThrownBy(
                () -> {
                    baseError("Root").errors(
                            error("E1").errors(
                                    error("E2").errors(
                                            error("E3").description("")
                                    )
                            )
                    );
                }
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("descriptionFormat is empty");
    }

    @Test
    public void noParamsForDescription() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
        xgen.generate(baseError("Root").errors(
                error("E1").errors(
                        error("E2").errors(
                                error("E3").description("Some description.")
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.message.noParamsForDescription").build());

        assertThatThrownBy(E3Error::throwException)
                .hasMessage("Some description.");
    }
}
