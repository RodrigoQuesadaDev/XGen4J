package com.rodrigodev.xgen.model.error.template.model;

import com.rodrigodev.xgen.model.common.template.model.TypeTemplateModel;
import com.rodrigodev.xgen.model.error.configuration.definition.ParameterDefinition;
import lombok.NonNull;
import lombok.Value;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Value
public class ParameterDefinitionModel {

    @NonNull private TypeTemplateModel type;
    @NonNull private String name;

    public ParameterDefinitionModel(@NonNull ParameterDefinition param) {
        Class<?> paramClass = param.type();
        this.type = new TypeTemplateModel(paramClass.getSimpleName(), paramClass.getCanonicalName());
        this.name = param.name();
    }
}
