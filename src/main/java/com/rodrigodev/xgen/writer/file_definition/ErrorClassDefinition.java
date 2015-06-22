package com.rodrigodev.xgen.writer.file_definition;

import com.rodrigodev.xgen.configuration.ErrorDefinition;
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
