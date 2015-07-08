package com.rodrigodev.xgen.test.code;

import com.rodrigodev.xgen.ExceptionsGenerator;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Test;

import static com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 07/07/15.
 */
public class CodeUniquenessTests {

    private void assert_codeNumberMustBeUniqueAmongSiblingErrors(
            ThrowingCallable methodCall, int codeNumber, String codeName
    ) {
        assertThatThrownBy(methodCall)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(String.format("Duplicated code number '%d' for error code '%s'.", codeNumber, codeName));
    }

    @Test
    public void codeNumberMustBeUniqueAmongSiblingErrors() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");

        assert_codeNumberMustBeUniqueAmongSiblingErrors(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").code(123).errors(
                                commonError("C1Name").code(234),
                                error("E1Name").code(345),
                                error("E2Name").code(234)
                        ).basePackage("com.rodrigodev.xgen.test.code.codeNumberMustBeUniqueAmongSiblingErrors").build())
                        // @formatter:on
                , 234, "e-2-name"
        );

        assert_codeNumberMustBeUniqueAmongSiblingErrors(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").code(123).errors(
                                error("E1Name").code(234),
                                error("E2Name").code(345),
                                error("E3Name").code(234)
                        ).basePackage("com.rodrigodev.xgen.test.code.codeNumberMustBeUniqueAmongSiblingErrors").build())
                        // @formatter:on
                , 234, "e-3-name"
        );

        assert_codeNumberMustBeUniqueAmongSiblingErrors(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").code(123).errors(
                                commonError("C1Name").code(234).errors(
                                        error("C2Name").code(345).errors(
                                                error("C3_1Name").code(456),
                                                error("C3_2Name").code(567),
                                                error("C3_3Name").code(456)
                                        )
                                ),
                                error("E1Name").code(432).errors(
                                        error("E2Name").code(543).errors(
                                                error("E3_1Name").code(654),
                                                error("E3_2Name").code(765),
                                                error("E3_3Name").code(876)
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen.test.code.codeNumberMustBeUniqueAmongSiblingErrors").build())
                        // @formatter:on
                , 456, "c-3-3-name"
        );

        assert_codeNumberMustBeUniqueAmongSiblingErrors(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").code(123).errors(
                                commonError("C1Name").code(234).errors(
                                        error("C2Name").code(345).errors(
                                                error("C3_1Name").code(456),
                                                error("C3_2Name").code(567),
                                                error("C3_3Name").code(678)
                                        )
                                ),
                                error("E1Name").code(432).errors(
                                        error("E2Name").code(543).errors(
                                                error("E3_1Name").code(654),
                                                error("E3_2Name").code(765),
                                                error("E3_3Name").code(654)
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen.test.code.codeNumberMustBeUniqueAmongSiblingErrors").build())
                        // @formatter:on
                , 654, "e-3-3-name"
        );
    }
}
