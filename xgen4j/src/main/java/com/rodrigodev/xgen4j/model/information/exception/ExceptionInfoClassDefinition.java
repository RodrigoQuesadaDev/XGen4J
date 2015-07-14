package com.rodrigodev.xgen.model.information.exception;

import com.rodrigodev.xgen.GenerationOptions;
import com.rodrigodev.xgen.model.common.clazz.ClassDefinition;
import com.rodrigodev.xgen.model.support.optional.OptionalClassType;
import lombok.NonNull;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
public class ExceptionInfoClassDefinition extends ClassDefinition {

    private static final String NAME = "ExceptionInfo";

    private GenerationOptions generationOptions;

    public ExceptionInfoClassDefinition(String packagePath, @NonNull GenerationOptions generationOptions) {
        super(NAME, packagePath);
        this.generationOptions = generationOptions;
    }

    public OptionalClassType optionalClassType() {
        return generationOptions.optionalClassType();
    }
}
