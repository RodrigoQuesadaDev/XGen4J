package com.rodrigodev.xgen4j.model.information;

import com.rodrigodev.xgen4j.model.common.clazz.ClassFile;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
public class InformationClassFile extends ClassFile<InformationClassDefinition> {

    public InformationClassFile(String baseDirectory, InformationClassDefinition classDefinition) {
        super(baseDirectory, classDefinition);
    }
}
