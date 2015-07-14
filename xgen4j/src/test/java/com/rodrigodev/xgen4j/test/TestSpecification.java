package com.rodrigodev.xgen4j.test;

import com.rodrigodev.xgen4j.DaggerExceptionsGeneratorComponent;
import com.rodrigodev.xgen4j.ExceptionsGenerator;
import com.rodrigodev.xgen4j.MainModule;
import com.rodrigodev.xgen4j.test.common.doubles.service.time.FakeTimeModule;

/**
 * Created by Rodrigo Quesada on 14/07/15.
 */
public class TestSpecification {

    protected static final String SRC_DIR_PATH = "src/test-gen/java";

    protected static ExceptionsGenerator generator() {
        return DaggerExceptionsGeneratorComponent.builder()
                .mainModule(new MainModule(SRC_DIR_PATH))
                .timeModule(new FakeTimeModule())
                .build().generator();
    }
}
