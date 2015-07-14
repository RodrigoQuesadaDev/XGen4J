package com.rodrigodev.xgen4j.model.information.exception.template;

import com.rodrigodev.xgen4j.model.common.template.FreemarkerClassTemplate.InjectedFields;
import com.rodrigodev.xgen4j.model.error.ErrorClassFile;
import com.rodrigodev.xgen4j.model.error.exception.ExceptionClassFile;
import com.rodrigodev.xgen4j.model.information.exception.ExceptionInfoClassFile;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
@Singleton
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

