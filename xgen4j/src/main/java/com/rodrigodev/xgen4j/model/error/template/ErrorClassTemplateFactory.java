package com.rodrigodev.xgen4j.model.error.template;

import com.rodrigodev.xgen4j.model.common.template.FreemarkerClassTemplateFactory;
import com.rodrigodev.xgen4j.model.error.ErrorClassFile;
import com.rodrigodev.xgen4j.model.error.exception.ExceptionClassFile;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
@Singleton
public class ErrorClassTemplateFactory extends FreemarkerClassTemplateFactory {

    @Inject
    public ErrorClassTemplateFactory() {
    }

    public ErrorClassTemplate create(
            Optional<ErrorClassFile> rootErrorClassFile,
            Optional<ExceptionClassFile> rootExceptionClassFile,
            ErrorClassFile errorClassFile,
            ExceptionClassFile exceptionClassFile,
            Optional<ErrorClassFile> parentClassFile
    ) {
        return new ErrorClassTemplate(
                injectedFields,
                rootErrorClassFile,
                rootExceptionClassFile,
                errorClassFile,
                exceptionClassFile,
                parentClassFile
        );
    }
}
