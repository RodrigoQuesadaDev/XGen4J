package com.rodrigodev.xgen4j.model.error.template.model;

import com.rodrigodev.xgen4j.model.common.template.model.TypeTemplateModel;
import com.rodrigodev.xgen4j.model.error.ErrorClassDefinition;
import com.rodrigodev.xgen4j.model.error.exception.ExceptionClassDefinition;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Value
@EqualsAndHashCode(callSuper = true)
public class RootTemplateModel extends TypeTemplateModel {

    @NonNull private TypeTemplateModel exception;

    public RootTemplateModel(@NonNull ErrorClassDefinition error, @NonNull ExceptionClassDefinition rootException) {
        super(error);
        exception = new TypeTemplateModel(rootException);
    }
}