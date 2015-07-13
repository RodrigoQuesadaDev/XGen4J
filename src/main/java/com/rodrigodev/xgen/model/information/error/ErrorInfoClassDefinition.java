package com.rodrigodev.xgen.model.information.error;

import com.rodrigodev.xgen.GenerationOptions;
import com.rodrigodev.xgen.model.common.clazz.ClassDefinition;
import com.rodrigodev.xgen.model.support.optional.OptionalClassType;
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
