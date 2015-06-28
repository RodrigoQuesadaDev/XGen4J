package com.rodrigodev.xgen.model.error.configuration;

import com.rodrigodev.xgen.model.error.configuration.ErrorDefinition.ErrorDefinitionBuilder;
import lombok.NonNull;

/**
 * Created by Rodrigo Quesada on 11/05/15.
 */
public class ErrorConfiguration {

    public static ErrorDefinitionBuilder rootError(@NonNull String name) {
        return ErrorDefinition.builder().name(name);
    }

    public static ErrorDefinition.ErrorDefinitionBuilder commonError(@NonNull String name) {
        return ErrorDefinition.builder().name(name);
    }

    public static ErrorDefinition.ErrorDefinitionBuilder error(@NonNull String name) {
        return ErrorDefinition.builder().name(name);
    }
}
