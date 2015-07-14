package com.rodrigodev.xgen4j.model.error.exception;

import com.rodrigodev.xgen4j.model.common.template.FreemarkerClassTemplate.InjectedFields;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
@Singleton
public class ExceptionClassTemplateFactory {

    @Inject InjectedFields injectedFields;

    @Inject
    public ExceptionClassTemplateFactory() {
    }

    public ExceptionClassTemplate create(
            Optional<ExceptionClassFile> rootClassFile,
            ExceptionClassFile classFile,
            Optional<ExceptionClassFile> parentClassFile
    ) {
        return new ExceptionClassTemplate(injectedFields, rootClassFile, classFile, parentClassFile);
    }
}
