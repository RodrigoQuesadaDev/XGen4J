package com.rodrigodev.xgen.model.information.exception;

import com.rodrigodev.xgen.model.common.clazz.ClassFile;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
public class ExceptionInfoClassFile extends ClassFile<ExceptionInfoClassDefinition> {

    public ExceptionInfoClassFile(String baseDirectory, ExceptionInfoClassDefinition classDefinition) {
        super(baseDirectory, classDefinition);
    }
}