package com.rodrigodev.xgen.test.generation_options;

import com.rodrigodev.xgen.ExceptionsGenerator;
import com.rodrigodev.xgen.ExceptionsGeneratorComponent;
import com.rodrigodev.xgen.GenerationOptions;
import com.rodrigodev.xgen.MainModule;
import com.rodrigodev.xgen.model.common.file.FileService;
import com.rodrigodev.xgen.model.error.configuration.definition.RootErrorDefinition;
import com.rodrigodev.xgen.model.support.optional.OptionalClassType;
import com.rodrigodev.xgen.test.common.doubles.error.message.TestMessageGeneratorObject;
import com.rodrigodev.xgen.test.common.doubles.error.message.TestObject;
import com.rodrigodev.xgen.test.common.doubles.file.InMemoryFileModule;
import com.rodrigodev.xgen.test.common.doubles.file.InMemoryFileService;
import dagger.Component;
import org.assertj.core.api.Condition;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

import static com.rodrigodev.xgen.model.error.configuration.ErrorConfiguration.*;
import static com.rodrigodev.xgen.model.error.configuration.definition.ParameterDefinition.p;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
public class OptionalClassTypeOptionTests {

    @Singleton
    @Component(modules = {MainModule.class})
    public interface TestExceptionsGeneratorComponent extends ExceptionsGeneratorComponent {

        void inject(OptionalClassTypeOptionTests testClass);
    }

    private TestExceptionsGeneratorComponent exceptionsGeneratorComponent;
    private InMemoryFileService fileService;

    public OptionalClassTypeOptionTests() {
        exceptionsGeneratorComponent = DaggerOptionalClassTypeOptionTests_TestExceptionsGeneratorComponent.builder()
                .mainModule(new MainModule("src/test-gen/java"))
                .fileModule(new InMemoryFileModule())
                .build();
        exceptionsGeneratorComponent.inject(this);
    }

    @Inject
    public void setFileService(FileService fileService) {
        this.fileService = (InMemoryFileService) fileService;
    }

    @Before
    public void setUp() {
        fileService.reset();
    }

    private static void generateClasses(
            ExceptionsGenerator xgen,
            RootErrorDefinition rootError,
            Optional<OptionalClassType> optionalClassType
    ) {
        if (optionalClassType.isPresent()) {
            xgen.generate(rootError, GenerationOptions.builder().optionalClassType(optionalClassType.get()).build());
        }
        else {
            xgen.generate(rootError);
        }
    }

    private void assert_correctOptionalClassWasWrittenToGeneratedFiles(
            RootErrorDefinition rootError,
            Optional<OptionalClassType> optionalClassType
    ) {
        //test compilation
        generateClasses(new ExceptionsGenerator("src/test-gen/java"), rootError, optionalClassType);

        //verify correct Optional class was written
        generateClasses(exceptionsGeneratorComponent.generator(), rootError, optionalClassType);
        assertThat(fileService.files()).have(new DoesNotContainNonSelectedOptionalTypes(optionalClassType));
        assertThat(fileService.files()).haveAtLeastOne(new ContainsSelectedOptionalType(optionalClassType));
    }

    private void assert_correctOptionalClassIsUsed(
            String prefix, Optional<OptionalClassType> optionalClassType, String namespace
    ) {
        setUp();
        // @formatter:off
        assert_correctOptionalClassWasWrittenToGeneratedFiles(rootError(prefix + "Root").errors(
                commonError(prefix + "C1").errors(
                        error(prefix + "C2").errors(
                                error(prefix + "C3_1").description("Message for C3_1 error."),
                                error(prefix + "C3_2").description("{param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                error(prefix + "C3_3").description(TestMessageGeneratorObject.class, "generator")
                        )
                ),
                error(prefix + "E1").errors(
                        error(prefix + "E2").errors(
                                error(prefix + "E3_1").description("Message for E3_1 error."),
                                error(prefix + "E3_2").description("{param1: '%s', param2: %d, param3: '%s'}", p(String.class, "param1"), p(Integer.class, "param2"), p(TestObject.class, "param3")),
                                error(prefix + "E3_3").description(TestMessageGeneratorObject.class, "generator")
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.generation_options." + namespace).build(), optionalClassType);
        // @formatter:on
    }

    @Test
    public void correctOptionalClassIsUsedForCorrespondingOption() {
        // @formatter:off
        assert_correctOptionalClassIsUsed("Default", Optional.empty(), "java8OptionalClassIsUsedWhenNoOptionIsSet");
        assert_correctOptionalClassIsUsed("Java8", Optional.of(OptionalClassType.JAVA_8), "java8OptionalClassIsUsedWhenCorrespondingOptionIsSet");
        assert_correctOptionalClassIsUsed("Guava", Optional.of(OptionalClassType.GUAVA), "guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet");
        assert_correctOptionalClassIsUsed("Custom", Optional.of(OptionalClassType.CUSTOM), "customOptionalClassIsUsedWhenCorrespondingOptionIsSet");
        // @formatter:on
    }

    private abstract class SelectedOptionalCondition extends Condition<StringBuffer> {

        protected TestOptionalClassType selectedOptionalClassType;

        public SelectedOptionalCondition(Optional<OptionalClassType> selectedOptionalClassType) {
            this.selectedOptionalClassType = TestOptionalClassType.from(selectedOptionalClassType);
        }

        @Override
        abstract public boolean matches(StringBuffer file);
    }

    private class ContainsSelectedOptionalType extends SelectedOptionalCondition {

        public ContainsSelectedOptionalType(Optional<OptionalClassType> selectedOptionalClassType) {
            super(selectedOptionalClassType);
        }

        @Override
        public boolean matches(StringBuffer file) {
            return file.toString().contains(selectedOptionalClassType.fullQualifiedName());
        }
    }

    private class DoesNotContainNonSelectedOptionalTypes extends SelectedOptionalCondition {

        public DoesNotContainNonSelectedOptionalTypes(Optional<OptionalClassType> selectedOptionalClassType) {
            super(selectedOptionalClassType);
        }

        @Override
        public boolean matches(StringBuffer file) {
            boolean result = true;
            for (TestOptionalClassType type : TestOptionalClassType.values()) {
                if (type != selectedOptionalClassType) {
                    if (file.toString().contains(type.fullQualifiedName())) {
                        result = false;
                        break;
                    }
                }
            }
            return result;
        }
    }

    private enum TestOptionalClassType {
        JAVA_8(Optional.class),
        GUAVA(com.google.common.base.Optional.class),
        CUSTOM(com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.Optional.class);

        private Class<?> type;

        TestOptionalClassType(Class<?> type) {
            this.type = type;
        }

        public String fullQualifiedName() {
            return type.getName();
        }

        public static TestOptionalClassType from(Optional<OptionalClassType> optionalClassType) {
            return valueOf(
                    optionalClassType.isPresent()
                            ? optionalClassType.get().name()
                            : TestOptionalClassType.JAVA_8.name()
            );
        }
    }
}
