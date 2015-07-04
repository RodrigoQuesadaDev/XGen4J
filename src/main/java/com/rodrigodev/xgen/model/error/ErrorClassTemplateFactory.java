package com.rodrigodev.xgen.model.error;

import com.rodrigodev.xgen.model.common.template.FreemarkerClassTemplateFactory;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassFile;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
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
