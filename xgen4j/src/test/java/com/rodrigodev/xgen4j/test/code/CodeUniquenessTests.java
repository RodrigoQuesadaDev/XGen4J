/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Rodrigo Quesada <rodrigoquesada.dev@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.rodrigodev.xgen4j.test.code;

import com.rodrigodev.xgen4j.ExceptionsGenerator;
import com.rodrigodev.xgen4j.test.TestSpecification;
import com.rodrigodev.xgen4j.test.code.errorCodeEqualityIsBasedOnId_onlyName.ARootError;
import com.rodrigodev.xgen4j.test.code.errorCodeEqualityIsBasedOnId_onlyName.ErrorCodeATestFactory;
import com.rodrigodev.xgen4j.test.code.errorCodeEqualityIsBasedOnId_onlyName.c1.c2.c3_1.AC3_1Error;
import com.rodrigodev.xgen4j.test.code.errorCodeEqualityIsBasedOnId_withNumber.BRootError;
import com.rodrigodev.xgen4j.test.code.errorCodeEqualityIsBasedOnId_withNumber.ErrorCodeBTestFactory;
import com.rodrigodev.xgen4j.test.code.errorCodeEqualityIsBasedOnId_withNumber.c1.c2.c3_1.BC3_1Error;
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

    private void assert_codeNumberCannotBeEqualToRootCodeNumberForChildrenOfRootError(
            ThrowingCallable methodCall, String codeName
    ) {
        assertThatThrownBy(methodCall)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(
                        String.format("Number for error code '%s' is equal to root error's code's number.", codeName)
                );
    }

    @Test
    public void codeNumberCannotBeEqualToRootCodeNumberForChildrenOfRootError() {
        ExceptionsGenerator xgen = generator();

        assert_codeNumberCannotBeEqualToRootCodeNumberForChildrenOfRootError(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").code(123).errors(
                                commonError("C1Name").code(123),
                                error("E1Name").code(345),
                                error("E2Name").code(456)
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNumberCannotBeEqualToRootCodeNumberForChildrenOfRootError").build())
                        // @formatter:on
                , "c-1-name"
        );
        assert_codeNumberCannotBeEqualToRootCodeNumberForChildrenOfRootError(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").code(123).errors(
                                commonError("C1Name").code(234),
                                error("E1Name").code(123),
                                error("E2Name").code(456)
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNumberCannotBeEqualToRootCodeNumberForChildrenOfRootError").build())
                        // @formatter:on
                , "e-1-name"
        );

        assert_codeNumberCannotBeEqualToRootCodeNumberForChildrenOfRootError(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").code(123).errors(
                                commonError("C1Name").code(123).errors(
                                        error("C2Name").code(345).errors(
                                                error("C3Name").code(456)
                                        )
                                ),
                                error("E1Name").code(567).errors(
                                        error("E2Name").code(678).errors(
                                                error("E3Name").code(789)
                                        )
                                ),
                                error("EB1Name").code(890).errors(
                                        error("EB2Name").code(1234).errors(
                                                error("EB3Name").code(2345)
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNumberCannotBeEqualToRootCodeNumberForChildrenOfRootError").build())
                        // @formatter:on
                , "c-1-name"
        );
        assert_codeNumberCannotBeEqualToRootCodeNumberForChildrenOfRootError(
                () ->
                        // @formatter:off
                        xgen.generate(rootError("RootName").code(123).errors(
                                commonError("C1Name").code(234).errors(
                                        error("C2Name").code(345).errors(
                                                error("C3Name").code(456)
                                        )
                                ),
                                error("E1Name").code(123).errors(
                                        error("E2Name").code(678).errors(
                                                error("E3Name").code(789)
                                        )
                                ),
                                error("EB1Name").code(890).errors(
                                        error("EB2Name").code(1234).errors(
                                                error("EB3Name").code(2345)
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNumberCannotBeEqualToRootCodeNumberForChildrenOfRootError").build())
                        // @formatter:on
                , "e-1-name"
        );
    }

    @Test
    public void codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError() {
        String basePackage = "com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError";
        // @formatter:off
        generator().generate(rootError("Root").code(123).errors(
                commonError("C1").code(234).errors(
                        error("C2").code(123).errors(
                                error("C3").code(123)
                        )
                ),
                error("E1").code(345).errors(
                        error("E2").code(123).errors(
                                error("E3").code(123)
                        )
                ),
                error("EB1").code(456).errors(
                        error("EB2").code(123).errors(
                                error("EB3").code(123)
                        )
                )
        ).basePackage(basePackage).build());
        // @formatter:on

        assertThatErrorAndExceptionClassExist(basePackage, "Root");
        assertThatErrorAndExceptionClassExist(basePackage, "c1.C1");
        assertThatErrorAndExceptionClassExist(basePackage, "c1.c2.C2");
        assertThatErrorAndExceptionClassExist(basePackage, "c1.c2.c3.C3");
        assertThatErrorAndExceptionClassExist(basePackage, "e1.E1");
        assertThatErrorAndExceptionClassExist(basePackage, "e1.e2.E2");
        assertThatErrorAndExceptionClassExist(basePackage, "e1.e2.e3.E3");
        assertThatErrorAndExceptionClassExist(basePackage, "eb1.EB1");
        assertThatErrorAndExceptionClassExist(basePackage, "eb1.eb2.EB2");
        assertThatErrorAndExceptionClassExist(basePackage, "eb1.eb2.eb3.EB3");
    }

    private void assert_codeNameCannotBeEqualToRootCodeNameForChildrenOfRootError(ThrowingCallable methodCall) {
        assertThatThrownBy(methodCall)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Error code 'code-name-root' has same name as root error's code.");
    }

    private void assert_codeNameCannotBeEqualToRootCodeNameForChildrenOfRootError(boolean withNumericId) {
        ExceptionsGenerator xgen = generator();

        assert_codeNameCannotBeEqualToRootCodeNameForChildrenOfRootError(
                () ->
                        // @formatter:off
                        xgen.generate(code(rootError("Root"), "code-name-root", 1, withNumericId).errors(
                                code(commonError("C1"), "code-name-root", 2, withNumericId),
                                code(error("E1"), "code-name-e1", 3, withNumericId),
                                code(error("E2"), "code-name-e2", 4, withNumericId)
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNameCannotBeEqualToRootCodeNameForChildrenOfRootError").build())
                        // @formatter:on
        );
        assert_codeNameCannotBeEqualToRootCodeNameForChildrenOfRootError(
                () ->
                        // @formatter:off
                        xgen.generate(code(rootError("Root"), "code-name-root", 1, withNumericId).errors(
                                code(commonError("C1"), "code-name-c1", 2, withNumericId),
                                code(error("E1"), "code-name-root", 3, withNumericId),
                                code(error("E2"), "code-name-e2", 4, withNumericId)
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNameCannotBeEqualToRootCodeNameForChildrenOfRootError").build())
                        // @formatter:on
        );

        assert_codeNameCannotBeEqualToRootCodeNameForChildrenOfRootError(
                () ->
                        // @formatter:off
                        xgen.generate(code(rootError("Root"), "code-name-root", 1, withNumericId).errors(
                                code(commonError("C1"), "code-name-root", 2, withNumericId).errors(
                                        code(error("C2"), "code-name-c2", 3, withNumericId).errors(
                                                code(error("C3"), "code-name-c3", 4, withNumericId)
                                        )
                                ),
                                code(error("E1"), "code-name-e1", 5, withNumericId).errors(
                                        code(error("E2"), "code-name-e2", 6, withNumericId).errors(
                                                code(error("E3"), "code-name-e3", 7, withNumericId)
                                        )
                                ),
                                code(error("EB1"), "code-name-eb1", 8, withNumericId).errors(
                                        code(error("EB2"), "code-name-eb2", 9, withNumericId).errors(
                                                code(error("EB3"), "code-name-eb3", 10, withNumericId)
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNameCannotBeEqualToRootCodeNameForChildrenOfRootError").build())
                        // @formatter:on
        );
        assert_codeNameCannotBeEqualToRootCodeNameForChildrenOfRootError(
                () ->
                        // @formatter:off
                        xgen.generate(code(rootError("Root"), "code-name-root", 1, withNumericId).errors(
                                code(commonError("C1"), "code-name-c1", 2, withNumericId).errors(
                                        code(error("C2"), "code-name-c2", 3, withNumericId).errors(
                                                code(error("C3"), "code-name-c3", 4, withNumericId)
                                        )
                                ),
                                code(error("E1"), "code-name-root", 5, withNumericId).errors(
                                        code(error("E2"), "code-name-e2", 6, withNumericId).errors(
                                                code(error("E3"), "code-name-e3", 7, withNumericId)
                                        )
                                ),
                                code(error("EB1"), "code-name-eb1", 8, withNumericId).errors(
                                        code(error("EB2"), "code-name-eb2", 9, withNumericId).errors(
                                                code(error("EB3"), "code-name-eb3", 10, withNumericId)
                                        )
                                )
                        ).basePackage("com.rodrigodev.xgen4j.test.code.codeNameCannotBeEqualToRootCodeNameForChildrenOfRootError").build())
                        // @formatter:on
        );
    }

    @Test
    public void codeNameCannotBeEqualToRootCodeNameForChildrenOfRootError() {
        assert_codeNameCannotBeEqualToRootCodeNameForChildrenOfRootError(false);
        assert_codeNameCannotBeEqualToRootCodeNameForChildrenOfRootError(true);
    }

    private void assert_codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError(
            boolean withNumericId, String namespace
    ) {
        String basePackage = "com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_" + namespace;
        // @formatter:off
        generator().generate(code(rootError("Root"), "code-name-root", 1, withNumericId).errors(
                code(commonError("C1"), "code-name-c1", 2, withNumericId).errors(
                        code(error("C2"), "code-name-root", 3, withNumericId).errors(
                                code(error("C3"), "code-name-root", 4, withNumericId)
                        )
                ),
                code(error("E1"), "code-name-e1", 5, withNumericId).errors(
                        code(error("E2"), "code-name-root", 6, withNumericId).errors(
                                code(error("E3"), "code-name-root", 7, withNumericId)
                        )
                ),
                code(error("EB1"), "code-name-eb1", 8, withNumericId).errors(
                        code(error("EB2"), "code-name-root", 9, withNumericId).errors(
                                code(error("EB3"), "code-name-root", 10, withNumericId)
                        )
                )
        ).basePackage(basePackage).build());
        // @formatter:on

        assertThatErrorAndExceptionClassExist(basePackage, "Root");
        assertThatErrorAndExceptionClassExist(basePackage, "code_name_c1.C1");
        assertThatErrorAndExceptionClassExist(basePackage, "code_name_c1.code_name_root.C2");
        assertThatErrorAndExceptionClassExist(basePackage, "code_name_c1.code_name_root.code_name_root.C3");
        assertThatErrorAndExceptionClassExist(basePackage, "code_name_e1.E1");
        assertThatErrorAndExceptionClassExist(basePackage, "code_name_e1.code_name_root.E2");
        assertThatErrorAndExceptionClassExist(basePackage, "code_name_e1.code_name_root.code_name_root.E3");
        assertThatErrorAndExceptionClassExist(basePackage, "code_name_eb1.EB1");
        assertThatErrorAndExceptionClassExist(basePackage, "code_name_eb1.code_name_root.EB2");
        assertThatErrorAndExceptionClassExist(basePackage, "code_name_eb1.code_name_root.code_name_root.EB3");
    }

    @Test
    public void codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError() {
        assert_codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError(false, "nameOnly");
        assert_codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError(true, "withNumber");
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
        assertThat(AC3_1Error.CODE).isEqualTo(errorCodeATestFactory.create("c1.c2.c3-1"));
        assertThat(AC3_1Error.CODE).isNotEqualTo(errorCodeATestFactory.create("c1.c2.different"));

        assertThat(BRootError.CODE).isEqualTo(errorCodeBTestFactory.create("root", 123));
        assertThat(BRootError.CODE).isNotEqualTo(errorCodeBTestFactory.create("different", 123));
        assertThat(BC3_1Error.CODE).isEqualTo(errorCodeBTestFactory.create("c1.c2.c3-1", 123));
        assertThat(BC3_1Error.CODE).isNotEqualTo(errorCodeBTestFactory.create("c1.c2.different", 123));
    }
}
