package com.rodrigodev.xgen4j.model.information.error;

import com.rodrigodev.xgen4j.GenerationOptions;
import com.rodrigodev.xgen4j.model.common.clazz.ClassDefinition;
import com.rodrigodev.xgen4j.model.support.optional.OptionalClassType;
import lombok.NonNull;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
public class ErrorInfoClassDefinition extends ClassDefinition {

    private static final String NAME = "ErrorInfo";

    private GenerationOptions generationOptions;

    public ErrorInfoClassDefinition(String packagePath, @NonNull GenerationOptions generationOptions) {
        super(NAME, packagePath);
        this.generationOptions = generationOptions;
    }

    public OptionalClassType optionalClassType() {
        return generationOptions.optionalClassType();
    }
}
