package com.rodrigodev.xgen4j.model.information.template.model;

import com.rodrigodev.xgen4j.model.error.code.ErrorCodeClassFile;
import lombok.Value;

/**
 * Created by Rodrigo Quesada on 14/07/15.
 */
@Value
public class ErrorCodeTemplateModel {

    private boolean hasNumericId;

    public ErrorCodeTemplateModel(ErrorCodeClassFile errorCodeClassFile) {
        hasNumericId = errorCodeClassFile.classDefinition().hasNumericId();
    }
}
