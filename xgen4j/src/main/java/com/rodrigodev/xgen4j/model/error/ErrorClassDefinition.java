package com.rodrigodev.xgen.model.error;

import com.rodrigodev.xgen.model.error.configuration.definition.ErrorDefinition;
import lombok.NonNull;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 25/05/15.
 */
@Accessors(fluent = true)
public class ErrorClassDefinition extends ClassDefinitionForError {

    private static final String NAME_SUFFIX = "Error";

    public ErrorClassDefinition(@NonNull ErrorDefinition errorDefinition) {
        super(errorDefinition, NAME_SUFFIX);
    }
}
