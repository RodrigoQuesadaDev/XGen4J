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

package com.rodrigodev.xgen4j_table_generator.test;

import com.rodrigodev.xgen4j_table_generator.model.information.*;
import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.ErrorInfo;
import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.Information;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * Created by Rodrigo Quesada on 14/07/15.
 */
public class TableCreationWithoutNumericIdTests extends TableCreationTestSpecification {

    @Override
    protected InformationWrapper information() {
        return new InformationWrapperImpl();
    }

    @Test
    public void tableIsGeneratedForErrorsWithNoNumericId() {
        assert_tableIsGeneratedForErrors(
                false, "/test_data/test_table_without_numeric_id.xlsx", "tableIsGeneratedForErrorsWithNoNumericId"
        );
    }

    private static class InformationWrapperImpl implements InformationWrapper {

        @Override
        public List<ErrorInfoWrapper> list() {
            return Information.list().stream().map(ErrorInfoWrapperImpl::new).collect(toList());
        }
    }

    private static class ErrorInfoWrapperImpl implements ErrorInfoWrapper {

        private ErrorInfo errorInfo;

        public ErrorInfoWrapperImpl(ErrorInfo errorInfo) {
            this.errorInfo = errorInfo;
        }

        @Override
        public ExceptionInfoWrapper exceptionInfo() {
            return () -> errorInfo.exceptionInfo().clazz();
        }

        @Override
        public ErrorCodeWrapper code() {
            return () -> errorInfo.code().id();
        }

        @Override
        public Optional<ErrorDescriptionWrapper> description() {
            return errorInfo.description().map(d -> new ErrorDescriptionWrapper() {
                @Override
                public Object description() {
                    return d.description();
                }

                @Override
                public boolean usesCustomMessageGenerator() {
                    return d.usesCustomMessageGenerator();
                }
            });
        }

        @Override
        public boolean isCommon() {
            return errorInfo.isCommon();
        }
    }
}
