package com.rodrigodev.xgen.model.error.code;

import com.rodrigodev.xgen.model.common.clazz.ClassDefinition;
import lombok.NonNull;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 25/05/15.
 */
@Accessors(fluent = true)
public class ErrorCodeClassDefinition extends ClassDefinition {

    private static final String NAME = "ErrorCode";

    public ErrorCodeClassDefinition(@NonNull String packagePath) {
        super(NAME, packagePath);
    }
}
