package com.rodrigodev.xgen.model.information.exception.template.model;

import com.rodrigodev.xgen.model.common.template.model.TypeTemplateModel;
import com.rodrigodev.xgen.model.error.ErrorClassDefinition;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassDefinition;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Value
@EqualsAndHashCode(callSuper = true)
public class RootErrorTemplateModel extends TypeTemplateModel {

    @NonNull private TypeTemplateModel exception;

    public RootErrorTemplateModel(@NonNull ErrorClassDefinition error,
                                  @NonNull ExceptionClassDefinition rootException
    ) {
        super(error);
        exception = new TypeTemplateModel(rootException);
    }
}
