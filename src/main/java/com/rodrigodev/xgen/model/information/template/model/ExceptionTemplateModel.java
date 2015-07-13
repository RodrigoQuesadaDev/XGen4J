package com.rodrigodev.xgen.model.information.template.model;

import com.rodrigodev.xgen.model.common.template.model.TypeTemplateModel;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassDefinition;
import lombok.Value;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Value
public class ExceptionTemplateModel extends TypeTemplateModel {

    private boolean hasType;

    public ExceptionTemplateModel(ExceptionClassDefinition classDefinition) {
        super(classDefinition);
        this.hasType = classDefinition.hasType();
    }
}
