package com.rodrigodev.xgen.model.error.exception;

import com.rodrigodev.xgen.model.error.configuration.ErrorDefinition;
import com.rodrigodev.xgen.model.error.ClassDefinitionForError;
import lombok.NonNull;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 25/05/15.
 */
@Accessors(fluent = true)
public class ExceptionClassDefinition extends ClassDefinitionForError {

    private static final String NAME_SUFFIX = "Exception";

    public ExceptionClassDefinition(@NonNull ErrorDefinition errorDefinition) {
        super(errorDefinition, NAME_SUFFIX);
    }
}
