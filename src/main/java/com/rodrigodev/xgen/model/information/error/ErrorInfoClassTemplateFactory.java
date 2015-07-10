package com.rodrigodev.xgen.model.information.error;

import com.rodrigodev.xgen.model.common.template.FreemarkerClassTemplate.InjectedFields;
import com.rodrigodev.xgen.model.error.ErrorClassFile;

import javax.inject.Inject;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
public class ErrorInfoClassTemplateFactory {

    @Inject InjectedFields injectedFields;

    @Inject
    public ErrorInfoClassTemplateFactory() {
    }

    public ErrorInfoClassTemplate create(ErrorInfoClassFile errorInfoClassFile, ErrorClassFile rootErrorClassFile) {
        return new ErrorInfoClassTemplate(injectedFields, errorInfoClassFile, rootErrorClassFile);
    }
}
