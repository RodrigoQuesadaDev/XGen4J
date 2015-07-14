package com.rodrigodev.xgen4j.test.code;

import com.rodrigodev.xgen4j.ExceptionsGenerator;
import com.rodrigodev.xgen4j.test.TestSpecification;
import com.rodrigodev.xgen4j.test.code.errorCodeEqualityIsBasedOnId_onlyName.ARootError;
import com.rodrigodev.xgen4j.test.code.errorCodeEqualityIsBasedOnId_onlyName.ErrorCodeATestFactory;
import com.rodrigodev.xgen4j.test.code.errorCodeEqualityIsBasedOnId_onlyName.ac1.ac2.ac3_1.AC3_1Error;
import com.rodrigodev.xgen4j.test.code.errorCodeEqualityIsBasedOnId_withNumber.BRootError;
import com.rodrigodev.xgen4j.test.code.errorCodeEqualityIsBasedOnId_withNumber.ErrorCodeBTestFactory;
import com.rodrigodev.xgen4j.test.code.errorCodeEqualityIsBasedOnId_withNumber.bc1.bc2.bc3_1.BC3_1Error;
import dagger.Component;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Test;

import javax.inject.Inject;

import static com.rodrigodev.xgen4j.model.error.configuration.ErrorConfiguration.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 07/07/15.
 */
public class CodeUniquenessTests extends TestSpecification {

    @Inject ErrorCodeATestFactory errorCodeATestFactory;
    @Inject ErrorCodeBTestFactory errorCodeBTestFactory;

    @Component
    public interface TestComponent {

        void inject(CodeUniquenessTests testClass);
    }

    public CodeUniquenessTests() {
        DaggerCodeUniquenessTests_TestComponent.create().inject(this);
    }

    private void assert_codeNumberMustBeUniqueAmongSiblingErrors(
            ThrowingCallable methodCall, int codeNumber, String codeName
    ) {
        assertThatThrownBy(methodCall)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(String.format("Duplicated code number '%d' for error code '%s'.", codeNumber, codeName));
    }

    @Test
    public void codeNumberMustBeUniqueAmongSiblingErrors() {
        ExceptionsGenerator xgen = generator();

        assert_codeNumberMustBeUniqueAmongSiblingErrors(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").code(123).errors(
                                commonError("C1Name").code(234),
                                error("E1Name").code(345),
                                error("E2Name").code(234)
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNumberMustBeUniqueAmongSiblingErrors").build())
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
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNumberMustBeUniqueAmongSiblingErrors").build())
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
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNumberMustBeUniqueAmongSiblingErrors").build())
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
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNumberMustBeUniqueAmongSiblingErrors").build())
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
        ExceptionsGenerator xgen = generator();

        assert_codeNameMustBeUniqueAmongSiblingErrors(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("Root").code(123).errors(
                                commonError("C1").code("c-1-name", 234),
                                error("E1").code(345),
                                error("C3").code("c-1-name", 456)
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNameMustBeUniqueAmongSiblingErrors_specifiedName").build())
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
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNameMustBeUniqueAmongSiblingErrors_specifiedName").build())
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
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNameMustBeUniqueAmongSiblingErrors_specifiedName").build())
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
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNameMustBeUniqueAmongSiblingErrors_specifiedName").build())
                        // @formatter:on
                , "e-3-1-name"
        );
    }

    @Test
    public void codeNameMustBeUniqueAmongSiblingErrors_mixedCase() {
        ExceptionsGenerator xgen = generator();

        assert_codeNameMustBeUniqueAmongSiblingErrors(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("Root").code(123).errors(
                                commonError("C1Name").code(234),
                                error("E1").code(345),
                                error("C3").code("c-1-name", 456)
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNameMustBeUniqueAmongSiblingErrors_mixedCase").build())
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
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNameMustBeUniqueAmongSiblingErrors_mixedCase").build())
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
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNameMustBeUniqueAmongSiblingErrors_mixedCase").build())
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
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNameMustBeUniqueAmongSiblingErrors_mixedCase").build())
                        // @formatter:on
                , "e-3-1-name"
        );
    }

    @Test
    public void errorCodeEqualityIsBasedOnId() {
        ExceptionsGenerator xgen = generator();
        // @formatter:off
        xgen.generate(rootError("ARoot").code("root").errors(
                commonError("AC1").code("c1").errors(
                        error("AC2").code("c2").errors(
                                error("AC3_1").code("c3-1")
                        )
                )
        ).basePackage("com.rodrigodev.xgen4j.test.code.errorCodeEqualityIsBasedOnId_onlyName").build());
        xgen.generate(rootError("BRoot").code("root", 1).errors(
                commonError("BC1").code("c1", 2).errors(
                        error("BC2").code("c2", 3).errors(
                                error("BC3_1").code("c3-1", 4)
                        )
                )
        ).basePackage("com.rodrigodev.xgen4j.test.code.errorCodeEqualityIsBasedOnId_withNumber").build());
        // @formatter:on

        assertThat(ARootError.CODE).isEqualTo(errorCodeATestFactory.create("root"));
        assertThat(ARootError.CODE).isNotEqualTo(errorCodeATestFactory.create("different"));
        assertThat(AC3_1Error.CODE).isEqualTo(errorCodeATestFactory.create("root.c1.c2.c3-1"));
        assertThat(AC3_1Error.CODE).isNotEqualTo(errorCodeATestFactory.create("root.c1.c2.different"));

        assertThat(BRootError.CODE).isEqualTo(errorCodeBTestFactory.create("root", 123));
        assertThat(BRootError.CODE).isNotEqualTo(errorCodeBTestFactory.create("different", 123));
        assertThat(BC3_1Error.CODE).isEqualTo(errorCodeBTestFactory.create("root.c1.c2.c3-1", 123));
        assertThat(BC3_1Error.CODE).isNotEqualTo(errorCodeBTestFactory.create("root.c1.c2.different", 123));
    }
}
