package com.rodrigodev.xgen.writer.template.exception;

import com.rodrigodev.xgen.writer.file_definition.ErrorClassFile;
import com.rodrigodev.xgen.writer.file_definition.ExceptionClassDefinition;
import com.rodrigodev.xgen.writer.file_definition.ExceptionClassFile;
import com.rodrigodev.xgen.writer.template.FreemarkerClassTemplate;
import com.rodrigodev.xgen.writer.template.exception.ExceptionClassTemplateModel.ExceptionClassTemplateModelBuilder;
import lombok.NonNull;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
public class ExceptionClassTemplate extends FreemarkerClassTemplate<ExceptionClassTemplateModel, ExceptionClassTemplateModelBuilder, ExceptionClassDefinition> {

    public static final String TEMPLATE_FILE_NAME = "exception-class-def.ftl";

    //TODO change to builder?
    public ExceptionClassTemplate(
            InjectedFields injectedFields, ExceptionClassFile classFile, Optional<ExceptionClassFile> parentClassFile
    ) {
        super(injectedFields, TEMPLATE_FILE_NAME, ExceptionClassTemplateModel.builder(), classFile, parentClassFile);
    }
}
