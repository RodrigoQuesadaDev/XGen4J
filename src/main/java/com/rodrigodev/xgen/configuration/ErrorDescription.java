package com.rodrigodev.xgen.configuration;

import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 12/05/15.
 */
@Value
@Accessors(fluent = true)
public class ErrorDescription {

    private String format;
    private ParameterDefinition[] params;
}
