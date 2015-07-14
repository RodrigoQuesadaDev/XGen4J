package com.rodrigodev.xgen4j.model.error.exception;

import com.rodrigodev.xgen4j.GenerationOptions;
import com.rodrigodev.xgen4j.model.error.ClassDefinitionForError;
import com.rodrigodev.xgen4j.model.error.configuration.definition.ErrorDefinition;
import lombok.NonNull;

/**
 * Created by Rodrigo Quesada on 25/05/15.
 */
public class ExceptionClassDefinition extends ClassDefinitionForError {

    private static final String NAME_SUFFIX = "Exception";

    private GenerationOptions generationOptions;

    public ExceptionClassDefinition(
            @NonNull ErrorDefinition errorDefinition,
            @NonNull GenerationOptions generationOptions
    ) {
        super(errorDefinition, NAME_SUFFIX);
        this.generationOptions = generationOptions;
    }

    public boolean hasType() {
        return !errorDefinition().isRoot() && !errorDefinition().isCommon();
    }

    public boolean isCheckedException() {
        return generationOptions.checkedExceptions();
    }
}
