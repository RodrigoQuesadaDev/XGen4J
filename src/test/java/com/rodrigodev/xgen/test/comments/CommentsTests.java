package com.rodrigodev.xgen.test.comments;

import com.rodrigodev.xgen.ExceptionsGenerator;
import com.rodrigodev.xgen.ExceptionsGeneratorComponent;
import com.rodrigodev.xgen.MainModule;
import com.rodrigodev.xgen.model.common.file.FileService;
import com.rodrigodev.xgen.service.time.TimeService;
import com.rodrigodev.xgen.test.common.doubles.file.InMemoryFileModule;
import com.rodrigodev.xgen.test.common.doubles.file.InMemoryFileService;
import com.rodrigodev.xgen.test.common.doubles.service.time.FakeTimeModule;
import com.rodrigodev.xgen.test.common.doubles.service.time.FakeTimeService;
import dagger.Component;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.time.LocalDateTime;

import static com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 26/06/15.
 */
public class CommentsTests {

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
                .mainModule(new MainModule("src/test-gen/java"))
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
        ).basePackage("com.rodrigodev.xgen.test.comments.currentDateIsAddedToTemplateComments").build());
        // @formatter:on

        for (StringBuffer file : fileService.files()) {
            assertThat(file).contains("November 13, 1234");
        }
    }

    //TODO refactor all tests to use constant time (so that files do not change every time the date is different)
}
