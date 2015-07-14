package com.rodrigodev.xgen4j.model.information.template.model;

import com.rodrigodev.xgen4j.model.common.template.model.TypeTemplateModel;
import com.rodrigodev.xgen4j.model.error.exception.ExceptionClassDefinition;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Value
@EqualsAndHashCode(callSuper = true)
public class ExceptionTemplateModel extends TypeTemplateModel {

    private boolean hasType;

    public ExceptionTemplateModel(ExceptionClassDefinition classDefinition) {
        super(classDefinition);
        this.hasType = classDefinition.hasType();
    }
}
