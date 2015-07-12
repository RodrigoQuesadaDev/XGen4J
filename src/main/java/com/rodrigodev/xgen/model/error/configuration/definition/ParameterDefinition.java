package com.rodrigodev.xgen.model.error.configuration.definition;

import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 12/05/15.
 */
@Value
@Accessors(fluent = true)
public class ParameterDefinition {

    @NonNull private Class<?> type;
    @NonNull private String name;

    public static ParameterDefinition p(Class type, String name) {
        return new ParameterDefinition(type, name);
    }
}
