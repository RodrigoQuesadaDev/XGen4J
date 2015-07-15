package com.rodrigodev.xgen4j.model.information.template.model;

import com.rodrigodev.xgen4j.model.common.clazz.ErrorExceptionClassFilePair;
import com.rodrigodev.xgen4j.model.common.template.model.TypeTemplateModel;
import com.rodrigodev.xgen4j.model.error.configuration.definition.ErrorDefinition;
import com.rodrigodev.xgen4j.model.error.configuration.definition.description.CustomMessageGeneratorDefinition;
import com.rodrigodev.xgen4j.model.error.configuration.definition.description.ErrorDescriptionDefinition;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Value
@EqualsAndHashCode(callSuper = true)
public class ErrorTemplateModel extends TypeTemplateModel {

    @NonNull private ExceptionTemplateModel exception;
    private boolean common;
    private DescriptionTemplateModel description;

    public ErrorTemplateModel(@NonNull ErrorExceptionClassFilePair errorExceptionPair) {
        super(errorExceptionPair.error().classDefinition());

        this.exception = new ExceptionTemplateModel(errorExceptionPair.exception().classDefinition());

        ErrorDefinition errorDefinition = errorExceptionPair.error().classDefinition().errorDefinition();
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
