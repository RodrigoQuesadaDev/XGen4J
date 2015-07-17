package com.rodrigodev.xgen4j.model.information.template.model;

import com.rodrigodev.xgen4j.model.common.template.model.TypeTemplateModel;
import com.rodrigodev.xgen4j.model.error.exception.ExceptionClassDefinition;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Getter
@FieldDefaults(makeFinal = true)
@ToString
public class ExceptionTemplateModel extends TypeTemplateModel {

    private boolean hasType;

    public ExceptionTemplateModel(ExceptionClassDefinition classDefinition) {
        super(classDefinition);
        this.hasType = classDefinition.hasType();
    }
}
