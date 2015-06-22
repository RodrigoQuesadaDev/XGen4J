package com.rodrigodev.xgen.writer.template.exception;

import com.rodrigodev.xgen.writer.file_definition.ExceptionClassFile;
import com.rodrigodev.xgen.writer.template.FreemarkerClassTemplate.InjectedFields;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
public class ExceptionClassTemplateFactory {

    @Inject InjectedFields injectedFields;

    @Inject
    public ExceptionClassTemplateFactory() {
    }

    public ExceptionClassTemplate create(ExceptionClassFile classFile, Optional<ExceptionClassFile> parentClassFile) {
        return new ExceptionClassTemplate(injectedFields, classFile, parentClassFile);
    }
}
