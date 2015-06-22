package com.rodrigodev.xgen.writer.template.error;

import com.rodrigodev.xgen.writer.file_definition.ErrorClassFile;
import com.rodrigodev.xgen.writer.file_definition.ExceptionClassFile;
import com.rodrigodev.xgen.writer.template.FreemarkerClassTemplate.InjectedFields;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
public class ErrorClassTemplateFactory {

    @Inject InjectedFields injectedFields;

    @Inject
    public ErrorClassTemplateFactory() {
    }

    public ErrorClassTemplate create(
            ErrorClassFile errorClassFile,
            ExceptionClassFile exceptionClassFile,
            Optional<ErrorClassFile> parentClassFile
    ) {
        return new ErrorClassTemplate(injectedFields, errorClassFile, exceptionClassFile, parentClassFile);
    }
}
