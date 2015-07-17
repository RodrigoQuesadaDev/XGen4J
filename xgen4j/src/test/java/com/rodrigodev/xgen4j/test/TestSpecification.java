package com.rodrigodev.xgen4j.test;

import com.rodrigodev.xgen4j.DaggerExceptionsGeneratorComponent;
import com.rodrigodev.xgen4j.ExceptionsGenerator;
import com.rodrigodev.xgen4j.MainModule;
import com.rodrigodev.xgen4j.model.error.configuration.definition.ErrorDefinition.ErrorDefinitionBuilder;
import com.rodrigodev.xgen4j.test.common.doubles.service.time.FakeTimeModule;

import static com.rodrigodev.xgen4j.common.lang.PackageUtil.join;

/**
 * Created by Rodrigo Quesada on 14/07/15.
 */
public class TestSpecification {

    protected static final String SRC_DIR_PATH = "src/test-gen/java";
    protected static final String ERROR_SUFFIX = "Error";
    protected static final String EXCEPTION_SUFFIX = "Exception";

    protected static ExceptionsGenerator generator() {
        return DaggerExceptionsGeneratorComponent.builder()
                .mainModule(new MainModule(SRC_DIR_PATH))
                .timeModule(new FakeTimeModule())
                .build().generator();
    }

    protected static void assertThatClassExists(String basePackage, String classPath) {
        try {
            Class.forName(join(basePackage, classPath));
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //TODO use this method for asserting whenever possible
    protected static void assertThatErrorAndExceptionClassExist(String basePackage, String baseClassPath) {
        assertThatClassExists(basePackage, baseClassPath + ERROR_SUFFIX);
        assertThatClassExists(basePackage, baseClassPath + EXCEPTION_SUFFIX);
    }

    @SuppressWarnings("unchecked")
    protected <B extends ErrorDefinitionBuilder<?, ?>> B code(
            B errorBuilder, String name, int number, boolean withNumericId
    ) {
        return (B) (withNumericId ? errorBuilder.code(name, number) : errorBuilder.code(name));
    }
}
