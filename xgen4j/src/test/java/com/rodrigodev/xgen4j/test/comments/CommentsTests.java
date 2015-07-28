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

import com.rodrigodev.xgen4j.DaggerExceptionsGeneratorComponent;
import com.rodrigodev.xgen4j.test.TestSpecification;
import com.rodrigodev.xgen4j.test.common.doubles.file.FakeFileModule;
import com.rodrigodev.xgen4j.test.common.doubles.file.InMemoryFileService;
import com.rodrigodev.xgen4j.test.common.doubles.service.time.FakeTimeModule;
import com.rodrigodev.xgen4j.test.common.doubles.service.time.FakeTimeService;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static com.rodrigodev.xgen4j.model.error.configuration.ErrorConfiguration.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Rodrigo Quesada on 26/06/15.
 */
public class CommentsTests extends TestSpecification {

    private InMemoryFileService fileService;

    @Override
    protected void customizeComponent(DaggerExceptionsGeneratorComponent.Builder componentBuilder) {
        fileService = new InMemoryFileService();
        componentBuilder.fileModule(new FakeFileModule(fileService));

        FakeTimeService timeService = new FakeTimeService();
        timeService.setupConstant();
        timeService.setTime(LocalDateTime.of(1234, 11, 13, 17, 19));
        componentBuilder.timeModule(new FakeTimeModule(timeService));
    }

    @Before
    public void setUp() {
        fileService.reset();
    }

    @Test
    public void currentDateIsAddedToTemplateComments() {
        // @formatter:off
        generator().generate(rootError("Root").code("code-name-root").errors(
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
