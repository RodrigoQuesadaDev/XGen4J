package com.rodrigodev.xgen.generators;

import lombok.experimental.FieldDefaults;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@FieldDefaults(makeFinal = true)
public abstract class ClassesGenerator {

    protected String sourceDirPath;

    protected ClassesGenerator(String sourceDirPath) {
        this.sourceDirPath = sourceDirPath;
    }

    public abstract void generate();
}
