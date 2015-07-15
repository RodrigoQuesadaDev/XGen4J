package com.rodrigodev.xgen4j.model.error.code;

import com.rodrigodev.xgen4j.model.common.clazz.ClassDefinition;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 25/05/15.
 */
@Accessors(fluent = true)
public class ErrorCodeClassDefinition extends ClassDefinition {

    private static final String NAME = "ErrorCode";

    @Getter private boolean hasNumber;

    public ErrorCodeClassDefinition(String packagePath, boolean hasNumber) {
        super(NAME, packagePath);
        this.hasNumber = hasNumber;
    }

    public boolean hasNumericId() {
        return hasNumber;
    }
}
