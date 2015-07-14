package com.rodrigodev.xgen4j.model.error.code;

import com.rodrigodev.xgen4j.model.common.clazz.ClassFile;

/**
 * Created by Rodrigo Quesada on 25/05/15.
 */
public class ErrorCodeClassFile extends ClassFile<ErrorCodeClassDefinition> {

    public ErrorCodeClassFile(String baseDirectory, ErrorCodeClassDefinition errorCodeClass) {
        super(baseDirectory, errorCodeClass);
    }
}
