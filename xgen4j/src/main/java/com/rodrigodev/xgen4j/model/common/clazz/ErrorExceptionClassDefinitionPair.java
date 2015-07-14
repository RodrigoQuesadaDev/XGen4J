package com.rodrigodev.xgen.model.common.clazz;

import com.rodrigodev.xgen.model.error.ErrorClassDefinition;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassDefinition;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
@Value
@Accessors(fluent = true)
public class ErrorExceptionClassDefinitionPair {

    private ErrorClassDefinition error;
    private ExceptionClassDefinition exception;
}
