package com.rodrigodev.xgen4j.model.information.exception;

import com.rodrigodev.xgen4j.GenerationOptions;
import com.rodrigodev.xgen4j.model.common.clazz.ClassDefinition;
import com.rodrigodev.xgen4j.model.support.optional.OptionalClassType;
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
