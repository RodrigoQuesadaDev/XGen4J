package com.rodrigodev.xgen.model.error.code;

import com.rodrigodev.xgen.model.common.template.FreemarkerClassTemplate.InjectedFields;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
@Singleton
public class ErrorCodeClassTemplateFactory {

    @Inject InjectedFields injectedFields;

    @Inject
    public ErrorCodeClassTemplateFactory() {
    }

    public ErrorCodeClassTemplate create(ErrorCodeClassFile errorCodeClassFile) {
        return new ErrorCodeClassTemplate(injectedFields, errorCodeClassFile);
    }
}
