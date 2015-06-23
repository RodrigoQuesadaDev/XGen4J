package com.rodrigodev.xgen.configuration;

import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 12/05/15.
 */
@Value
@Accessors(fluent = true)
public class ErrorDescription {

    @NonNull private String format;
    @NonNull private ParameterDefinition[] params;
}
