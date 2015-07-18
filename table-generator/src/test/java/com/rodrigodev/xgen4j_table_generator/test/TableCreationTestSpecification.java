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

import com.rodrigodev.xgen4j.test.TestSpecification;
import com.rodrigodev.xgen4j.test.common.doubles.error.message.TestMessageGeneratorObject;
import com.rodrigodev.xgen4j.test.common.doubles.error.message.TestObject;
import com.rodrigodev.xgen4j_table_generator.MainModule;
import com.rodrigodev.xgen4j_table_generator.TableGeneratorComponent;
import com.rodrigodev.xgen4j_table_generator.model.information.InformationWrapper;
import com.rodrigodev.xgen4j_table_generator.service.file.FileService;
import com.rodrigodev.xgen4j_table_generator.test.common.assertion.excel.conditions.ExcelFile;
import com.rodrigodev.xgen4j_table_generator.test.common.doubles.file.InMemoryFileModule;
import com.rodrigodev.xgen4j_table_generator.test.common.doubles.file.InMemoryFileService;
import dagger.Component;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.ByteArrayInputStream;
import java.util.stream.Collectors;

import static com.rodrigodev.xgen4j.model.error.configuration.ErrorConfiguration.*;
import static com.rodrigodev.xgen4j.model.error.configuration.definition.ParameterDefinition.p;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 15/07/15.
 */
public abstract class TableCreationTestSpecification extends TestSpecification {

    @Singleton
    @Component(modules = {MainModule.class})
    public interface TestTableGeneratorComponent extends TableGeneratorComponent {

        void inject(TableCreationTestSpecification testClass);
    }

    private TestTableGeneratorComponent tableGeneratorComponent;
    private InMemoryFileService fileService;

    public TableCreationTestSpecification() {
        tableGeneratorComponent = DaggerTableCreationTestSpecification_TestTableGeneratorComponent.builder()
                .fileModule(new InMemoryFileModule())
                .build();
        tableGeneratorComponent.inject(this);
    }

    @Inject
    public void setFileService(FileService fileService) {
        this.fileService = (InMemoryFileService) fileService;
    }

    private void generateErrorsForTests(boolean withNumericId, String namespace) {
        // @formatter:off
        generator().generate(code(rootError("RootName"), "root-code-name", 1, withNumericId).errors(
                code(commonError("CName1"), "common-code-name-1", 2, withNumericId).description("Message for CName1 error.").errors(
                        code(error("CName2"), "common-code-name-2", 3, withNumericId).errors(
                                code(error("CName3_1"), "common-code-name-3-1", 4, withNumericId).description("Message for CName3_1 error."),
                                code(error("CName3_2"), "common-code-name-3-2", 5, withNumericId).description("CName3_2: {param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                code(error("CName3_3"), "common-code-name-3-3", 6, withNumericId).description(TestMessageGeneratorObject1.class, "generator")
                        )
                ),
                code(error("EName1"), "error-code-name-1", 7, withNumericId).description("Message for EName1 error.").errors(
                        code(error("EName2"), "error-code-name-2", 8, withNumericId).errors(
                                code(error("EName3_1"), "error-code-name-3-1", 9, withNumericId).description("Message for EName3_1 error."),
                                code(error("EName3_2"), "error-code-name-3-2", 10, withNumericId).description("EName3_2: {param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                code(error("EName3_3"), "error-code-name-3-3", 11, withNumericId).description(TestMessageGeneratorObject2.class, "generator")
                        )
                ),
                code(error("E2Name1"), "error-2-code-name-1", 12, withNumericId).description("Message for E2Name1 error.").errors(
                        code(error("E2Name2"), "error-2-code-name-2", 13, withNumericId).errors(
                                code(error("E2Name3_1"), "error-2-code-name-3-1", 14, withNumericId).description("Message for E2Name3_1 error."),
                                code(error("E2Name3_2"), "error-2-code-name-3-2", 15, withNumericId).description("E2Name3_2: {param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                code(error("E2Name3_3"), "error-2-code-name-3-3", 16, withNumericId).description(TestMessageGeneratorObject3.class, "generator")
                        )
                )
        ).basePackage("com.rodrigodev.xgen4j_table_generator.test." + namespace).build());
        // @formatter:on
    }

    protected void assert_tableIsGeneratedForErrors(boolean withNumericId, String expectedFilePath, String namespace) {
        generateErrorsForTests(withNumericId, namespace);

        tableGeneratorComponent.generator().generate(
                information(),
                "src/test-gen/java/com/rodrigodev/xgen4j_table_generator/test/table.xlsx"
        );

        assertThat(
                fileService.files().stream()
                        .map(b -> new ByteArrayInputStream(b.toByteArray()))
                        .collect(Collectors.toList())
        ).hasSize(1)
                .have(new ExcelFile(getClass().getResourceAsStream(expectedFilePath)));
    }

    protected abstract InformationWrapper information();

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
}
