package com.rodrigodev.xgen4j.model.error;

import com.rodrigodev.xgen4j.model.common.clazz.ClassFile;

/**
 * Created by Rodrigo Quesada on 25/05/15.
 */
public class ErrorClassFile extends ClassFile<ErrorClassDefinition> {

    public ErrorClassFile(String baseDirectory, ErrorClassDefinition errorClass) {
        super(baseDirectory, errorClass);
    }
}
