package com.rodrigodev.xgen.test.throwing;

import com.rodrigodev.xgen.ExceptionsGenerator;
import com.rodrigodev.xgen.test.throwing.c1.c2.c3.C3Error;
import com.rodrigodev.xgen.test.throwing.c1.c2.c3.C3Exception;
import com.rodrigodev.xgen.test.throwing.e1.e2.e3.E3Error;
import com.rodrigodev.xgen.test.throwing.e1.e2.e3.E3Exception;
import org.junit.Test;

import static com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 03/07/15.
 */
public class ThrowTests {

    public ThrowTests() {
        generateErrorsForThrowTests();
    }

    private void generateErrorsForThrowTests() {

        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");

        // @formatter:off
        xgen.generate(rootError("Root").errors(
                commonError("C1").errors(
                        error("C2").errors(
                                error("C3").description("Message for C3 error.")
                        )
                ),
                error("E1").errors(
                        error("E2").errors(
                                error("E3").description("Message for E3 error.")
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.throwing").build());
        // @formatter:on
    }

    @Test
    public void errorsAreAbleToThrowCorrespondingExceptionsWithCorrectMessage() {

        assertThatThrownBy(() -> C3Error.throwException())
                .isInstanceOf(C3Exception.class).hasMessage("Message for C3 error.");

        assertThatThrownBy(() -> E3Error.throwException())
                .isInstanceOf(E3Exception.class).hasMessage("Message for E3 error.");
    }

    @Test
    public void commonErrorsCanThrowOtherExceptionsUsingOwnMessage() {

        //C3Error.throwException(E3Exception.TYPE);
        //TODO implement this
    }
}
