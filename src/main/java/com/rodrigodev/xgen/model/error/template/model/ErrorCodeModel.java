package com.rodrigodev.xgen.model.error.template.model;

import com.rodrigodev.xgen.model.error.configuration.definition.code.ErrorCodeDefinition;
import lombok.NonNull;
import lombok.Value;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Value
public class ErrorCodeModel {

    @NonNull private String name;
    private Integer number;

    public ErrorCodeModel(@NonNull ErrorCodeDefinition code) {
        this.name = code.name();
        this.number = code.number().orElse(null);
    }
}
