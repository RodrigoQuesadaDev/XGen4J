package com.rodrigodev.xgen4j.model.information.error;

import com.rodrigodev.xgen4j.model.common.template.FreemarkerClassTemplate.InjectedFields;
import com.rodrigodev.xgen4j.model.error.ErrorClassFile;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
@Singleton
public class ErrorInfoClassTemplateFactory {

    @Inject InjectedFields injectedFields;

    @Inject
    public ErrorInfoClassTemplateFactory() {
    }

    public ErrorInfoClassTemplate create(ErrorInfoClassFile errorInfoClassFile, ErrorClassFile rootErrorClassFile) {
        return new ErrorInfoClassTemplate(injectedFields, errorInfoClassFile, rootErrorClassFile);
    }
}
