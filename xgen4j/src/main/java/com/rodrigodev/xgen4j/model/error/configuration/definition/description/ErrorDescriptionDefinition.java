package com.rodrigodev.xgen.model.error.configuration.definition.description;

import com.rodrigodev.xgen.model.error.configuration.definition.ParameterDefinition;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 12/05/15.
 */
@Value
@Accessors(fluent = true)
public class ErrorDescriptionDefinition {

    @NonNull private String format;
    @NonNull private ParameterDefinition[] params;
}
