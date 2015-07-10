package com.rodrigodev.xgen.model.information.error;

import com.rodrigodev.xgen.model.common.clazz.ClassFile;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
public class ErrorInfoClassFile extends ClassFile<ErrorInfoClassDefinition> {

    public ErrorInfoClassFile(String baseDirectory, ErrorInfoClassDefinition classDefinition) {
        super(baseDirectory, classDefinition);
    }
}

