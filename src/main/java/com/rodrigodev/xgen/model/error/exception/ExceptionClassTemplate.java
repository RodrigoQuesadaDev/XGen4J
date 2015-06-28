package com.rodrigodev.xgen.model.error.exception;

import com.rodrigodev.xgen.model.error.exception.ExceptionClassTemplateModel.ExceptionClassTemplateModelBuilder;
import com.rodrigodev.xgen.model.common.template.FreemarkerClassTemplate;

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
