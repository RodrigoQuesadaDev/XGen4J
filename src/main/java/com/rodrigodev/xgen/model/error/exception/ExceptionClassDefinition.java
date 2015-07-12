package com.rodrigodev.xgen.model.error.exception;

import com.rodrigodev.xgen.GenerationOptions;
import com.rodrigodev.xgen.model.error.ClassDefinitionForError;
import com.rodrigodev.xgen.model.error.configuration.definition.ErrorDefinition;
import lombok.NonNull;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 25/05/15.
 */
@Accessors(fluent = true)
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
