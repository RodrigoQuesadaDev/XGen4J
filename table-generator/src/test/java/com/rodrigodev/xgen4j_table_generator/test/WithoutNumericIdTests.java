package com.rodrigodev.xgen4j_table_generator.test;

import com.rodrigodev.xgen4j.test.TestSpecification;
import com.rodrigodev.xgen4j.test.common.doubles.error.message.TestMessageGeneratorObject;
import com.rodrigodev.xgen4j.test.common.doubles.error.message.TestObject;
import com.rodrigodev.xgen4j_table_generator.MainModule;
import com.rodrigodev.xgen4j_table_generator.TableGeneratorComponent;
import com.rodrigodev.xgen4j_table_generator.model.information.*;
import com.rodrigodev.xgen4j_table_generator.service.file.FileService;
import com.rodrigodev.xgen4j_table_generator.test.common.assertion.excel.conditions.ExcelFile;
import com.rodrigodev.xgen4j_table_generator.test.common.doubles.file.InMemoryFileModule;
import com.rodrigodev.xgen4j_table_generator.test.common.doubles.file.InMemoryFileService;
import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.ErrorInfo;
import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.Information;
import dagger.Component;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.rodrigodev.xgen4j.model.error.configuration.ErrorConfiguration.*;
import static com.rodrigodev.xgen4j.model.error.configuration.definition.ParameterDefinition.p;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 14/07/15.
 */
public class WithoutNumericIdTests extends TestSpecification {

    @Singleton
    @Component(modules = {MainModule.class})
    public interface TestTableGeneratorComponent extends TableGeneratorComponent {

        void inject(WithoutNumericIdTests testClass);
    }

    private TestTableGeneratorComponent tableGeneratorComponent;
    private InMemoryFileService fileService;

    public WithoutNumericIdTests() {
        tableGeneratorComponent = DaggerWithoutNumericIdTests_TestTableGeneratorComponent.builder()
                .fileModule(new InMemoryFileModule())
                .build();
        tableGeneratorComponent.inject(this);
    }

    @Inject
    public void setFileService(FileService fileService) {
        this.fileService = (InMemoryFileService) fileService;
    }

    @Test
    public void tableIsGeneratedForErrorsWithNoNumericId() {
        // @formatter:off
        generator().generate(rootError("RootName").code("root-code-name").errors(
                commonError("CName1").code("common-code-name-1").description("Message for CName1 error.").errors(
                        error("CName2").code("common-code-name-2").errors(
                                error("CName3_1").code("common-code-name-3-1").description("Message for CName3_1 error."),
                                error("CName3_2").code("common-code-name-3-2").description("CName3_2: {param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                error("CName3_3").code("common-code-name-3-3").description(TestMessageGeneratorObject1.class, "generator")
                        )
                ),
                error("EName1").code("error-code-name-1").description("Message for EName1 error.").errors(
                        error("EName2").code("error-code-name-2").errors(
                                error("EName3_1").code("error-code-name-3-1").description("Message for EName3_1 error."),
                                error("EName3_2").code("error-code-name-3-2").description("EName3_2: {param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                error("EName3_3").code("error-code-name-3-3").description(TestMessageGeneratorObject2.class, "generator")
                        )
                ),
                error("E2Name1").code("error-2-code-name-1").description("Message for E2Name1 error.").errors(
                        error("E2Name2").code("error-2-code-name-2").errors(
                                error("E2Name3_1").code("error-2-code-name-3-1").description("Message for E2Name3_1 error."),
                                error("E2Name3_2").code("error-2-code-name-3-2").description("E2Name3_2: {param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                error("E2Name3_3").code("error-2-code-name-3-3").description(TestMessageGeneratorObject3.class, "generator")
                        )
                )
        ).basePackage("com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId").build());
        // @formatter:on

        tableGeneratorComponent.generator().generate(
                new InformationWrapperImpl(),
                "src/test-gen/java/com/rodrigodev/xgen4j_table_generator/test/table.xlsx"
        );


        assertThat(
                fileService.files().stream()
                        .map(b -> new ByteArrayInputStream(b.toByteArray()))
                        .collect(Collectors.toList())
        ).hasSize(1)
                .have(new ExcelFile(getClass().getResourceAsStream("/test_data/test_table_without_numeric_id.xlsx")));
    }

    public static class TestMessageGeneratorObject1 extends TestMessageGeneratorObject {
        public TestMessageGeneratorObject1(String value1, int value2) {
            super(value1, value2);
        }
    }

    public static class TestMessageGeneratorObject2 extends TestMessageGeneratorObject {
        public TestMessageGeneratorObject2(String value1, int value2) {
            super(value1, value2);
        }
    }

    public static class TestMessageGeneratorObject3 extends TestMessageGeneratorObject {
        public TestMessageGeneratorObject3(String value1, int value2) {
            super(value1, value2);
        }
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
