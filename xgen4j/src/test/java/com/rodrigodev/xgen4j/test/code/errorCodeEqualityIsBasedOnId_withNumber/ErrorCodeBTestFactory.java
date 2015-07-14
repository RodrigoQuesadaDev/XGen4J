package com.rodrigodev.xgen4j.test.code.errorCodeEqualityIsBasedOnId_withNumber;

import javax.inject.Inject;

/**
 * Created by Rodrigo Quesada on 11/07/15.
 */
public class ErrorCodeBTestFactory {

    @Inject
    public ErrorCodeBTestFactory() {
    }

    public ErrorCode create(
            String name, int number
    ) {
        return new ErrorCode(name, number);
    }
}
