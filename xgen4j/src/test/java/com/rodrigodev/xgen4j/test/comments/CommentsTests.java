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

package com.rodrigodev.xgen4j.test.comments;

import com.rodrigodev.xgen4j.ExceptionsGenerator;
import com.rodrigodev.xgen4j.ExceptionsGeneratorComponent;
import com.rodrigodev.xgen4j.MainModule;
import com.rodrigodev.xgen4j.model.common.file.FileService;
import com.rodrigodev.xgen4j.service.time.TimeService;
import com.rodrigodev.xgen4j.test.TestSpecification;
import com.rodrigodev.xgen4j.test.common.doubles.file.InMemoryFileModule;
import com.rodrigodev.xgen4j.test.common.doubles.file.InMemoryFileService;
import com.rodrigodev.xgen4j.test.common.doubles.service.time.FakeTimeModule;
import com.rodrigodev.xgen4j.test.common.doubles.service.time.FakeTimeService;
import dagger.Component;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.time.LocalDateTime;

import static com.rodrigodev.xgen4j.model.error.configuration.ErrorConfiguration.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 26/06/15.
 */
public class CommentsTests extends TestSpecification {

    @Singleton
    @Component(modules = {MainModule.class})
    public interface TestExceptionsGeneratorComponent extends ExceptionsGeneratorComponent {

        void inject(CommentsTests testClass);
    }

    private TestExceptionsGeneratorComponent exceptionsGeneratorComponent;
    private InMemoryFileService fileService;
    private FakeTimeService timeService;

    public CommentsTests() {
        exceptionsGeneratorComponent = DaggerCommentsTests_TestExceptionsGeneratorComponent.builder()
                .mainModule(new MainModule(SRC_DIR_PATH))
                .fileModule(new InMemoryFileModule())
                .timeModule(new FakeTimeModule())
                .build();
        exceptionsGeneratorComponent.inject(this);
        timeService.setupConstant();
        timeService.setTime(LocalDateTime.of(1234, 11, 13, 17, 19));
    }

    @Inject
    public void setFileService(FileService fileService) {
        this.fileService = (InMemoryFileService) fileService;
    }

    @Inject
    public void setTimeService(TimeService timeService) {
        this.timeService = (FakeTimeService) timeService;
    }

    @Before
    public void setUp() {
        fileService.reset();
    }

    @Test
    public void currentDateIsAddedToTemplateComments() {
        ExceptionsGenerator xgen = exceptionsGeneratorComponent.generator();
        // @formatter:off
        xgen.generate(rootError("Root").code("code-name-root").errors(
                commonError("C1").code("code-name-c1").errors(
                        error("C2").code("code-name-c2").errors(
                                error("C3_1").code("code-name-c3-1").description("ABCDE")
                        )
                ),
                error("E1").code("code-name-e1").errors(
                        error("E2").code("code-name-e2").errors(
                                error("E3_1").code("code-name-e3-1").description("ABCDE")
                        )
                )
        ).basePackage("com.rodrigodev.xgen4j.test.comments.currentDateIsAddedToTemplateComments").build());
        // @formatter:on

        for (StringBuffer file : fileService.files()) {
            assertThat(file).contains("November 13, 1234");
        }
    }
}
