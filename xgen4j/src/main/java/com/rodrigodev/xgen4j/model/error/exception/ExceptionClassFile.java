package com.rodrigodev.xgen4j.model.error.exception;

import com.rodrigodev.xgen4j.model.common.clazz.ClassFile;

/**
 * Created by Rodrigo Quesada on 25/05/15.
 */
public class ExceptionClassFile extends ClassFile<ExceptionClassDefinition> {

    public ExceptionClassFile(String baseDirectory, ExceptionClassDefinition exceptionClass) {
        super(baseDirectory, exceptionClass);
    }
}
