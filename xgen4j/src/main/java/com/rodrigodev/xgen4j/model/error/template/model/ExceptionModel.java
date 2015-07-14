package com.rodrigodev.xgen4j.model.error.template.model;

import com.rodrigodev.xgen4j.model.error.exception.ExceptionClassDefinition;
import lombok.NonNull;
import lombok.Value;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Value
public class ExceptionModel {

    @NonNull private String name;
    private boolean checkedException;

    public ExceptionModel(ExceptionClassDefinition exceptionClassDefinition) {
        this.name = exceptionClassDefinition.name();
        this.checkedException = exceptionClassDefinition.isCheckedException();
    }
}
