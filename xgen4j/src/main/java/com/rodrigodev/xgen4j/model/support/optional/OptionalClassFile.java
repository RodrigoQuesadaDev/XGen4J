package com.rodrigodev.xgen.model.support.optional;

import com.rodrigodev.xgen.model.common.clazz.ClassFile;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
public class OptionalClassFile extends ClassFile<OptionalClassDefinition> {

    public OptionalClassFile(String baseDirectory, OptionalClassDefinition classDefinition) {
        super(baseDirectory, classDefinition);
    }
}
