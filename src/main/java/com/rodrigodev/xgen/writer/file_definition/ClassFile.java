package com.rodrigodev.xgen.writer.file_definition;

/**
 * Created by Rodrigo Quesada on 26/05/15.
 */
public interface ClassFile<D extends ClassDefinition> {

    String filePath();
    D classDefinition();
}
