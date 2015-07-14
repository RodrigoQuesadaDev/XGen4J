package com.rodrigodev.xgen.test;

import com.rodrigodev.xgen.DaggerExceptionsGeneratorComponent;
import com.rodrigodev.xgen.ExceptionsGenerator;
import com.rodrigodev.xgen.MainModule;
import com.rodrigodev.xgen.test.common.doubles.service.time.FakeTimeModule;

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
