package com.rodrigodev.xgen.model.error;

import com.rodrigodev.xgen.model.common.clazz.ClassFile;

/**
 * Created by Rodrigo Quesada on 25/05/15.
 */
public class ErrorClassFile extends ClassFile<ErrorClassDefinition> {

    public ErrorClassFile(String baseDirectory, ErrorClassDefinition errorClass) {
        super(baseDirectory, errorClass);
    }
}
