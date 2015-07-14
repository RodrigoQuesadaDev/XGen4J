package com.rodrigodev.xgen4j.test.code;

import com.rodrigodev.xgen4j.ExceptionsGenerator;
import com.rodrigodev.xgen4j.test.TestSpecification;
import com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.RootError;
import com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.c1.C1Error;
import com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.c1.c2.C2Error;
import com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.c1.c2.c3_1.C3_1Error;
import com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.c1.c2.c3_2.C3_2Error;
import com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.c1.c2.c3_3.C3_3Error;
import com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.e1.E1Error;
import com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.e1.e2.E2Error;
import com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.e1.e2.e3_1.E3_1Error;
import com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.e1.e2.e3_2.E3_2Error;
import com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.e1.e2.e3_3.E3_3Error;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Test;

import static com.rodrigodev.xgen4j.model.error.configuration.ErrorConfiguration.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 25/06/15.
 */
public class CodeNumberTests extends TestSpecification {

    public CodeNumberTests() {
        generateErrorsForCodeNumericIdAndNumberAreGeneratedWhenSpecifiedTests();
        generateErrorsForCodeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecifiedTests();
    }

    private void assert_ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt(ThrowingCallable methodCall) {
        assertThatThrownBy(methodCall)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Code number is missing for error code 'an-error-name'.");
    }

    @Test
    public void ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt() {
        ExceptionsGenerator xgen = generator();

        assert_ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").code(1).errors(
                                commonError("AnErrorName")
                        ).basePackage("com.rodrigodev.xgen4j.test.code.ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt").build())
                        // @formatter:on
        );
        assert_ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").code(1).errors(
                                commonError("C1").code(1).errors(
                                        error("AnErrorName")
                                )
                        ).basePackage("com.rodrigodev.xgen4j.test.code.ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt").build())
                        // @formatter:on
        );
        assert_ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").code(1).errors(
                                commonError("C1").code(1).errors(
                                        error("C2").code(1).errors(
                                                error("C3_1").code(1),
                                                error("AnErrorName"),
                                                error("C3_3").code(3)
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen4j.test.code.ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt").build())
                        // @formatter:on
        );
        assert_ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").code(1).errors(
                                error("AnErrorName")
                        ).basePackage("com.rodrigodev.xgen4j.test.code.ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt").build())
                        // @formatter:on
        );
        assert_ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").code(1).errors(
                                error("E1").code(1).errors(
                                        error("AnErrorName")
                                )
                        ).basePackage("com.rodrigodev.xgen4j.test.code.ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt").build())
                        // @formatter:on
        );
        assert_ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").code(1).errors(
                                error("E1").code(1).errors(
                                        error("E2").code(1).errors(
                                                error("E3_1").code(1),
                                                error("AnErrorName"),
                                                error("E3_3").code(3)
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen4j.test.code.ifRootErrorHasCodeNumberThenAllDescendantsMustAlsoHaveIt").build())
                        // @formatter:on
        );
    }

    private void assert_ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither(
            ThrowingCallable methodCall) {
        assertThatThrownBy(methodCall)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Error code 'an-error-name' can't have a code number.");
    }

    @Test
    public void ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither() {
        ExceptionsGenerator xgen = generator();

        assert_ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").errors(
                                commonError("AnErrorName").code(1)
                        ).basePackage("com.rodrigodev.xgen4j.test.code.ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither").build())
                        // @formatter:on
        );
        assert_ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").errors(
                                commonError("C1").errors(
                                        error("AnErrorName").code(1)
                                )
                        ).basePackage("com.rodrigodev.xgen4j.test.code.ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither").build())
                        // @formatter:on
        );
        assert_ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").errors(
                                commonError("C1").errors(
                                        error("C2").errors(
                                                error("C3_1"),
                                                error("AnErrorName").code(1),
                                                error("C3_3")
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen4j.test.code.ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither").build())
                        // @formatter:on
        );
        assert_ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").errors(
                                error("AnErrorName").code(1)
                        ).basePackage("com.rodrigodev.xgen4j.test.code.ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither").build())
                        // @formatter:on
        );
        assert_ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").errors(
                                error("E1").errors(
                                        error("AnErrorName").code(1)
                                )
                        ).basePackage("com.rodrigodev.xgen4j.test.code.ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither").build())
                        // @formatter:on
        );
        assert_ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").errors(
                                error("E1").errors(
                                        error("E2").errors(
                                                error("E3_1"),
                                                error("AnErrorName").code(1),
                                                error("E3_3")
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen4j.test.code.ifRootErrorDoesNotHaveCodeNumberThenDescendantDoNotHaveItEither").build())
                        // @formatter:on
        );
    }

    private void generateErrorsForCodeNumericIdAndNumberAreGeneratedWhenSpecifiedTests() {
        // @formatter:off
        generator().generate(rootError("Root").code(123).errors(
                commonError("C1").code(234).errors(
                        error("C2").code(345).errors(
                                error("C3_1").code(456).description("ABCDE"),
                                error("C3_2").code(567).description("ABCDE"),
                                error("C3_3").code(678).description("ABCDE")
                        )
                ),
                error("E1").code(432).errors(
                        error("E2").code(543).errors(
                                error("E3_1").code(654).description("ABCDE"),
                                error("E3_2").code(765).description("ABCDE"),
                                error("E3_3").code(876).description("ABCDE")
                        )
                )
        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified").build());
        // @formatter:on
    }

    @Test
    public void codeNumberIsGeneratedWhenSpecified() {
        assertThat(RootError.CODE.number()).isEqualTo(123);

        assertThat(C1Error.CODE.number()).isEqualTo(234);
        assertThat(C2Error.CODE.number()).isEqualTo(345);
        assertThat(C3_1Error.CODE.number()).isEqualTo(456);
        assertThat(C3_2Error.CODE.number()).isEqualTo(567);
        assertThat(C3_3Error.CODE.number()).isEqualTo(678);

        assertThat(E1Error.CODE.number()).isEqualTo(432);

        assertThat(E2Error.CODE.number()).isEqualTo(543);
        assertThat(E3_1Error.CODE.number()).isEqualTo(654);
        assertThat(E3_2Error.CODE.number()).isEqualTo(765);
        assertThat(E3_3Error.CODE.number()).isEqualTo(876);
    }

    @Test
    public void codeNumericIdIsGeneratedWhenSpecified() {
        assertThat(RootError.CODE.numericId()).isEqualTo("123");

        assertThat(C1Error.CODE.numericId()).isEqualTo("123:234");
        assertThat(C2Error.CODE.numericId()).isEqualTo("123:234:345");
        assertThat(C3_1Error.CODE.numericId()).isEqualTo("123:234:345:456");
        assertThat(C3_2Error.CODE.numericId()).isEqualTo("123:234:345:567");
        assertThat(C3_3Error.CODE.numericId()).isEqualTo("123:234:345:678");

        assertThat(E1Error.CODE.numericId()).isEqualTo("123:432");
        assertThat(E2Error.CODE.numericId()).isEqualTo("123:432:543");
        assertThat(E3_1Error.CODE.numericId()).isEqualTo("123:432:543:654");
        assertThat(E3_2Error.CODE.numericId()).isEqualTo("123:432:543:765");
        assertThat(E3_3Error.CODE.numericId()).isEqualTo("123:432:543:876");
    }

    private void generateErrorsForCodeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecifiedTests() {
        // @formatter:off
        generator().generate(rootError("Root").code("code-name-1", 123).errors(
                error("E1").code("code-name-2", 234).errors(
                        error("E2").code("code-name-3", 345).errors(
                                error("E3_1").code("code-name-4-1", 456).description("ABCDE"),
                                error("E3_2").code("code-name-4-2").code(567).description("ABCDE"),
                                error("E3_3").code(678).code("code-name-4-3").description("ABCDE")
                        )
                )
        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified").build());
        // @formatter:on
    }

    @Test
    public void codeNumberIsGeneratedWhenNameIsAlsoSpecifiedSpecified() {
        // @formatter:off
        assertThat(com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified.RootError.CODE.number()).isEqualTo(123);
        assertThat(com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified.e1.E1Error.CODE.number()).isEqualTo(234);
        assertThat(com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified.e1.e2.E2Error.CODE.number()).isEqualTo(345);
        assertThat(com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified.e1.e2.e3_1.E3_1Error.CODE.number()).isEqualTo(456);
        assertThat(com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified.e1.e2.e3_2.E3_2Error.CODE.number()).isEqualTo(567);
        assertThat(com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified.e1.e2.e3_3.E3_3Error.CODE.number()).isEqualTo(678);
        // @formatter:on
    }

    @Test
    public void codeNumericIdIsGeneratedWhenNameIsAlsoSpecifiedSpecified() {
        // @formatter:off
        assertThat(com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified.RootError.CODE.numericId()).isEqualTo("123");
        assertThat(com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified.e1.E1Error.CODE.numericId()).isEqualTo("123:234");
        assertThat(com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified.e1.e2.E2Error.CODE.numericId()).isEqualTo("123:234:345");
        assertThat(com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified.e1.e2.e3_1.E3_1Error.CODE.numericId()).isEqualTo("123:234:345:456");
        assertThat(com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified.e1.e2.e3_2.E3_2Error.CODE.numericId()).isEqualTo("123:234:345:567");
        assertThat(com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified.e1.e2.e3_3.E3_3Error.CODE.numericId()).isEqualTo("123:234:345:678");
        // @formatter:on
    }
}
