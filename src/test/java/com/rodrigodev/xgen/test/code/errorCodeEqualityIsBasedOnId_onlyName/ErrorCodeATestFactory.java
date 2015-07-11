package com.rodrigodev.xgen.test.code.errorCodeEqualityIsBasedOnId_onlyName;

import javax.inject.Inject;

/**
 * Created by Rodrigo Quesada on 11/07/15.
 */
public class ErrorCodeATestFactory {

    @Inject
    public ErrorCodeATestFactory() {
    }

    public ErrorCode create(String name) {
        return new ErrorCode(name);
    }
}
