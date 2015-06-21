package com.rodrigodev.xgen.writer.file_definition;

import com.rodrigodev.xgen.configuration.ErrorDefinition;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 25/05/15.
 */
@Accessors(fluent = true)
public class ErrorClassDefinition extends ClassDefinition {

    private static final String NAME_SUFFIX = "Error";

    @NonNull @Getter private ErrorDefinition errorDefinition;

    public ErrorClassDefinition(@NonNull ErrorDefinition errorDefinition) {
        super(NAME_SUFFIX, errorDefinition.name(), errorDefinition.basePackage());
        this.errorDefinition = errorDefinition;
    }
}
