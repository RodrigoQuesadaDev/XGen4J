package com.rodrigodev.xgen.model.error.configuration;

import com.rodrigodev.xgen.model.error.configuration.definition.CommonErrorDefinition;
import com.rodrigodev.xgen.model.error.configuration.definition.CommonErrorDefinition.CommonErrorDefinitionBuilder;
import com.rodrigodev.xgen.model.error.configuration.definition.ErrorDefinition;
import com.rodrigodev.xgen.model.error.configuration.definition.ErrorDefinition.ErrorDefinitionBuilder;
import com.rodrigodev.xgen.model.error.configuration.definition.RootErrorDefinition;
import com.rodrigodev.xgen.model.error.configuration.definition.RootErrorDefinition.RootErrorDefinitionBuilder;
import lombok.NonNull;

/**
 * Created by Rodrigo Quesada on 11/05/15.
 */
public class ErrorConfiguration {

    public static RootErrorDefinitionBuilder rootError(@NonNull String name) {
        return RootErrorDefinition.builder(name);
    }

    public static CommonErrorDefinitionBuilder commonError(@NonNull String name) {
        return CommonErrorDefinition.builder(name);
    }

    public static ErrorDefinitionBuilder error(@NonNull String name) {
        return ErrorDefinition.builder(name);
    }
}
