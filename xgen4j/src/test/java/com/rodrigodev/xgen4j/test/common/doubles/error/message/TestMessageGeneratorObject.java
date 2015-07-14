package com.rodrigodev.xgen4j.test.common.doubles.error.message;

import lombok.Value;
import lombok.experimental.NonFinal;

/**
 * Created by Rodrigo Quesada on 09/07/15.
 */
@Value
@NonFinal
public class TestMessageGeneratorObject {

    private String value1;
    private int value2;

    public String message() {
        return String.format("Custom Message: {value1: '%s', value2: %d}", value1, value2);
    }
}
