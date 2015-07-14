package com.rodrigodev.xgen4j.model.error.exception;

import com.rodrigodev.xgen4j.model.common.template.FreemarkerClassTemplate;
import com.rodrigodev.xgen4j.model.error.exception.ExceptionClassTemplateModel.ExceptionClassTemplateModelBuilder;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
public class ExceptionClassTemplate extends FreemarkerClassTemplate<ExceptionClassTemplateModel, ExceptionClassDefinition> {

    private static final String TEMPLATE_FILE_NAME = "exception-class-def.ftl";

    public ExceptionClassTemplate(
            InjectedFields injectedFields,
            Optional<ExceptionClassFile> rootClassFile,
            ExceptionClassFile classFile,
            Optional<ExceptionClassFile> parentClassFile
    ) {
        super(injectedFields, TEMPLATE_FILE_NAME, modelBuilder(rootClassFile, classFile), classFile, parentClassFile);
    }

    private static ExceptionClassTemplateModelBuilder modelBuilder(
            Optional<ExceptionClassFile> rootClassFile,
            ExceptionClassFile errorClassFile
    ) {
        return ExceptionClassTemplateModel.builder()
                .rootClassFile(rootClassFile)
                .errorClassFile(errorClassFile);
    }
}
