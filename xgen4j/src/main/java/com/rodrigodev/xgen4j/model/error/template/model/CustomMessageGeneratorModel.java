package com.rodrigodev.xgen4j.model.error.template.model;

import com.rodrigodev.xgen4j.model.common.template.model.TypeTemplateModel;
import com.rodrigodev.xgen4j.model.error.configuration.definition.description.CustomMessageGeneratorDefinition;
import lombok.NonNull;
import lombok.Value;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Value
public class CustomMessageGeneratorModel {

    @NonNull private TypeTemplateModel type;
    @NonNull private String name;

    public CustomMessageGeneratorModel(@NonNull CustomMessageGeneratorDefinition generator) {
        Class<?> paramClass = generator.type();
        this.type = new TypeTemplateModel(paramClass.getSimpleName(), paramClass.getCanonicalName());
        this.name = generator.name();
    }
}
