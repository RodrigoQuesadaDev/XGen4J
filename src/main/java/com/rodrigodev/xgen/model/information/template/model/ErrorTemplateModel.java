package com.rodrigodev.xgen.model.information.template.model;

import com.rodrigodev.xgen.model.common.clazz.ErrorExceptionClassDefinitionPair;
import com.rodrigodev.xgen.model.common.template.model.TypeTemplateModel;
import com.rodrigodev.xgen.model.error.configuration.definition.ErrorDefinition;
import com.rodrigodev.xgen.model.error.configuration.definition.description.CustomMessageGeneratorDefinition;
import com.rodrigodev.xgen.model.error.configuration.definition.description.ErrorDescriptionDefinition;
import lombok.NonNull;
import lombok.Value;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Value
public class ErrorTemplateModel extends TypeTemplateModel {

    @NonNull private ExceptionTemplateModel exception;
    private boolean common;
    private DescriptionTemplateModel description;

    public ErrorTemplateModel(@NonNull ErrorExceptionClassDefinitionPair errorExceptionPair) {
        super(errorExceptionPair.error());

        this.exception = new ExceptionTemplateModel(errorExceptionPair.exception());

        ErrorDefinition errorDefinition = errorExceptionPair.error().errorDefinition();
        this.common = errorDefinition.isCommon();

        Optional<ErrorDescriptionDefinition> descriptionDefinition = errorDefinition.description();
        Optional<CustomMessageGeneratorDefinition> customMessageGenerator = errorDefinition.customMessageGenerator();
        this.description = descriptionDefinition.isPresent() || customMessageGenerator.isPresent()
                ?
                new DescriptionTemplateModel(
                        descriptionDefinition.isPresent()
                                ? descriptionDefinition.get().format()
                                : customMessageGenerator.get().type().getCanonicalName() + ".class",
                        descriptionDefinition.isPresent()
                )
                : null;
    }
}
