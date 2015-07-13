package com.rodrigodev.xgen.model.error.template.model;

import com.rodrigodev.xgen.model.common.template.model.TypeTemplateModel;
import com.rodrigodev.xgen.model.error.ErrorClassDefinition;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassDefinition;
import lombok.NonNull;
import lombok.Value;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Value
public class RootTemplateModel extends TypeTemplateModel {

    @NonNull private TypeTemplateModel exception;

    public RootTemplateModel(@NonNull ErrorClassDefinition error, @NonNull ExceptionClassDefinition rootException) {
        super(error);
        exception = new TypeTemplateModel(rootException);
    }
}
