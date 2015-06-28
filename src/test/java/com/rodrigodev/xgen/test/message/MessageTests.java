package com.rodrigodev.xgen.test.message;

import com.rodrigodev.xgen.ExceptionsGenerator;
import com.rodrigodev.xgen.test.message.descriptionWithNoParamsIsAllowed.e1.e2.e3.E3Error;
import org.junit.Test;

import static com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration.rootError;
import static com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration.error;
import static com.rodrigodev.xgen.model.error.configuration.ParameterDefinition.p;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
public class MessageTests {

    @Test
    public void descriptionMustNotBeEmpty() {
        assertThatThrownBy(
                () -> {
                    rootError("Root").errors(
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
    public void descriptionWithNoParamsIsAllowed() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
        xgen.generate(rootError("Root").errors(
                error("E1").errors(
                        error("E2").errors(
                                error("E3").description("Some description.")
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.message.descriptionWithNoParamsIsAllowed").build());

        assertThatThrownBy(E3Error::throwException)
                .hasMessage("Some description.");
    }

    public static class TestObject {
        @Override
        public String toString() {
            return "A test object.";
        }
    }

    @Test
    public void descriptionWithMultipleParametersIsAllowed() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
        // @formatter:off
        xgen.generate(rootError("Root").errors(
                error("E1").errors(
                        error("E2").errors(
                                error("E3").description("{param1: '%s', param2: %.3f, param3: '%s'}", p(String.class, "param1"), p(Double.class, "param2"), p(TestObject.class, "param3"))
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.message.descriptionWithMultipleParametersIsAllowed").build());
        // @formatter:on

        assertThatThrownBy(
                () -> com.rodrigodev.xgen.test.message.descriptionWithMultipleParametersIsAllowed.e1.e2.e3.E3Error
                        .throwException("Abcde", 123.456, new TestObject())
        ).hasMessage("{param1: 'Abcde', param2: 123.456, param3: 'A test object.'}");
    }
}
