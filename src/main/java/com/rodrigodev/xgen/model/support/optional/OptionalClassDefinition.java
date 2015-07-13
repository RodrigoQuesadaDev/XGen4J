package com.rodrigodev.xgen.model.support.optional;

import com.rodrigodev.xgen.model.common.clazz.ClassDefinition;
import lombok.NonNull;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
public class OptionalClassDefinition extends ClassDefinition {

    private static final String NAME = "Optional";

    public OptionalClassDefinition(@NonNull String packagePath) {
        super(NAME, packagePath);
    }
}
