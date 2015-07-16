package com.rodrigodev.xgen4j_table_generator.test;

import com.rodrigodev.xgen4j_table_generator.model.information.*;
import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNumericId.ErrorInfo;
import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNumericId.Information;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * Created by Rodrigo Quesada on 14/07/15.
 */
public class TableCreationWithNumericIdTests extends TableCreationTestSpecification {

    @Override
    protected InformationWrapper information() {
        return new InformationWrapperImpl();
    }

    @Test
    public void tableIsGeneratedForErrorsWithNumericId() {
        assert_tableIsGeneratedForErrors(
                true, "/test_data/test_table_with_numeric_id.xlsx", "tableIsGeneratedForErrorsWithNumericId"
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
            return new ErrorCodeWrapper() {
                @Override
                public String id() {
                    return errorInfo.code().id();
                }

                @Override
                public String numericId() {
                    return errorInfo.code().numericId();
                }
            };
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
