package com.rodrigodev.xgen.model.information.exception;

import com.rodrigodev.xgen.model.common.template.FreemarkerClassTemplate.InjectedFields;
import com.rodrigodev.xgen.model.error.ErrorClassFile;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassFile;

import javax.inject.Inject;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
public class ExceptionInfoClassTemplateFactory {

    @Inject InjectedFields injectedFields;

    @Inject
    public ExceptionInfoClassTemplateFactory() {
    }

    public ExceptionInfoClassTemplate create(
            ExceptionInfoClassFile exceptionInfoClassFile,
            ErrorClassFile rootErrorClassFile,
            ExceptionClassFile rootExceptionClassFile
    ) {
        return new ExceptionInfoClassTemplate(
                injectedFields, exceptionInfoClassFile, rootErrorClassFile, rootExceptionClassFile
        );
    }
}

