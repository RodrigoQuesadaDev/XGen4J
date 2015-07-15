package com.rodrigodev.xgen4j.model.common.clazz;

import com.rodrigodev.xgen4j.model.error.ErrorClassFile;
import com.rodrigodev.xgen4j.model.error.exception.ExceptionClassFile;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
@Value
@Accessors(fluent = true)
public class ErrorExceptionClassFilePair {

    private ErrorClassFile error;
    private ExceptionClassFile exception;
}
