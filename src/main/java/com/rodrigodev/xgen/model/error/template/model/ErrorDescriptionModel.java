package com.rodrigodev.xgen.model.error.template.model;

import com.rodrigodev.xgen.model.error.configuration.definition.description.CustomMessageGeneratorDefinition;
import com.rodrigodev.xgen.model.error.configuration.definition.description.ErrorDescriptionDefinition;
import lombok.NonNull;
import lombok.Value;

import java.util.Arrays;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Value
public class ErrorDescriptionModel {

    @NonNull private String format;
    private ParameterDefinitionModel[] params;
    private CustomMessageGeneratorModel generator;

    public ErrorDescriptionModel(@NonNull ErrorDescriptionDefinition description) {
        format = description.format();
        params = Arrays.stream(description.params())
                .map(ParameterDefinitionModel::new)
                .toArray(ParameterDefinitionModel[]::new);
        generator = null;
    }

    public ErrorDescriptionModel(@NonNull CustomMessageGeneratorDefinition generator) {
        format = null;
        params = null;
        this.generator = new CustomMessageGeneratorModel(generator);
    }
}
