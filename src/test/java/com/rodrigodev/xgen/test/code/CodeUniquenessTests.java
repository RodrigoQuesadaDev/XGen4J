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

    private void assert_codeNameMustBeUniqueAmongSiblingErrors(ThrowingCallable methodCall, String codeName) {
        assertThatThrownBy(methodCall)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(String.format("Duplicated code name '%s' for error code.", codeName));
    }

    @Test
    public void codeNameMustBeUniqueAmongSiblingErrors_specifiedName() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");

        assert_codeNameMustBeUniqueAmongSiblingErrors(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("Root").code(123).errors(
                                commonError("C1").code("c-1-name", 234),
                                error("E1").code(345),
                                error("C3").code("c-1-name", 456)
                        ).basePackage("com.rodrigodev.xgen.test.code.codeNameMustBeUniqueAmongSiblingErrors_specifiedName").build())
                        // @formatter:on
                , "c-1-name"
        );

        assert_codeNameMustBeUniqueAmongSiblingErrors(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("Root").code(123).errors(
                                error("E1").code("e-1-name", 234),
                                error("E2").code(345),
                                error("E3").code("e-1-name", 456)
                        ).basePackage("com.rodrigodev.xgen.test.code.codeNameMustBeUniqueAmongSiblingErrors_specifiedName").build())
                        // @formatter:on
                , "e-1-name"
        );

        assert_codeNameMustBeUniqueAmongSiblingErrors(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("Root").code(123).errors(
                                commonError("C1").code(234).errors(
                                        error("C2").code(345).errors(
                                                error("C3_1").code("c-3-1-name", 456),
                                                error("C3_2").code(567),
                                                error("C3_3").code("c-3-1-name", 678)
                                        )
                                ),
                                error("E1").code(432).errors(
                                        error("E2").code(543).errors(
                                                error("E3_1").code(654),
                                                error("E3_2").code(765),
                                                error("E3_3").code(876)
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen.test.code.codeNameMustBeUniqueAmongSiblingErrors_specifiedName").build())
                        // @formatter:on
                , "c-3-1-name"
        );

        assert_codeNameMustBeUniqueAmongSiblingErrors(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("Root").code(123).errors(
                                commonError("C1").code(234).errors(
                                        error("C2").code(345).errors(
                                                error("C3_1").code(456),
                                                error("C3_2").code(567),
                                                error("C3_3").code(678)
                                        )
                                ),
                                error("E1").code(432).errors(
                                        error("E2").code(543).errors(
                                                error("E3_1").code("e-3-1-name", 654),
                                                error("E3_2").code(765),
                                                error("E3_3").code("e-3-1-name", 867)
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen.test.code.codeNameMustBeUniqueAmongSiblingErrors_specifiedName").build())
                        // @formatter:on
                , "e-3-1-name"
        );
    }

    @Test
    public void codeNameMustBeUniqueAmongSiblingErrors_generatedName() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");

        assert_codeNameMustBeUniqueAmongSiblingErrors(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").code(123).errors(
                                commonError("C1Name").code(234),
                                error("E1Name").code(345),
                                error("C1Name").code(456)
                        ).basePackage("com.rodrigodev.xgen.test.code.codeNameMustBeUniqueAmongSiblingErrors_generatedName").build())
                        // @formatter:on
                , "c-1-name"
        );

        assert_codeNameMustBeUniqueAmongSiblingErrors(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").code(123).errors(
                                error("E1Name").code(234),
                                error("E2Name").code(345),
                                error("E1Name").code(456)
                        ).basePackage("com.rodrigodev.xgen.test.code.codeNameMustBeUniqueAmongSiblingErrors_generatedName").build())
                        // @formatter:on
                , "e-1-name"
        );

        assert_codeNameMustBeUniqueAmongSiblingErrors(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").code(123).errors(
                                commonError("C1Name").code(234).errors(
                                        error("C2Name").code(345).errors(
                                                error("C3_1Name").code(456),
                                                error("C3_2Name").code(567),
                                                error("C3_1Name").code(678)
                                        )
                                ),
                                error("E1Name").code(432).errors(
                                        error("E2Name").code(543).errors(
                                                error("E3_1Name").code(654),
                                                error("E3_2Name").code(765),
                                                error("E3_3Name").code(876)
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen.test.code.codeNameMustBeUniqueAmongSiblingErrors_generatedName").build())
                        // @formatter:on
                , "c-3-1-name"
        );

        assert_codeNameMustBeUniqueAmongSiblingErrors(
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
                                                error("E3_1Name").code(867)
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen.test.code.codeNameMustBeUniqueAmongSiblingErrors_generatedName").build())
                        // @formatter:on
                , "e-3-1-name"
        );
    }

    @Test
    public void codeNameMustBeUniqueAmongSiblingErrors_mixedCase() {
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");

        assert_codeNameMustBeUniqueAmongSiblingErrors(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("Root").code(123).errors(
                                commonError("C1Name").code(234),
                                error("E1").code(345),
                                error("C3").code("c-1-name", 456)
                        ).basePackage("com.rodrigodev.xgen.test.code.codeNameMustBeUniqueAmongSiblingErrors_mixedCase").build())
                        // @formatter:on
                , "c-1-name"
        );

        assert_codeNameMustBeUniqueAmongSiblingErrors(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("Root").code(123).errors(
                                error("E1Name").code(234),
                                error("E2").code(345),
                                error("E3").code("e-1-name", 456)
                        ).basePackage("com.rodrigodev.xgen.test.code.codeNameMustBeUniqueAmongSiblingErrors_mixedCase").build())
                        // @formatter:on
                , "e-1-name"
        );

        assert_codeNameMustBeUniqueAmongSiblingErrors(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("Root").code(123).errors(
                                commonError("C1").code(234).errors(
                                        error("C2").code(345).errors(
                                                error("C3_1Name").code(456),
                                                error("C3_2").code(567),
                                                error("C3_3").code("c-3-1-name", 678)
                                        )
                                ),
                                error("E1").code(432).errors(
                                        error("E2").code(543).errors(
                                                error("E3_1").code(654),
                                                error("E3_2").code(765),
                                                error("E3_3").code(876)
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen.test.code.codeNameMustBeUniqueAmongSiblingErrors_mixedCase").build())
                        // @formatter:on
                , "c-3-1-name"
        );

        assert_codeNameMustBeUniqueAmongSiblingErrors(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("Root").code(123).errors(
                                commonError("C1").code(234).errors(
                                        error("C2").code(345).errors(
                                                error("C3_1").code(456),
                                                error("C3_2").code(567),
                                                error("C3_3").code(678)
                                        )
                                ),
                                error("E1").code(432).errors(
                                        error("E2").code(543).errors(
                                                error("E3_1Name").code(654),
                                                error("E3_2").code(765),
                                                error("E3_3").code("e-3-1-name", 867)
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen.test.code.codeNameMustBeUniqueAmongSiblingErrors_mixedCase").build())
                        // @formatter:on
                , "e-3-1-name"
        );
    }
}
