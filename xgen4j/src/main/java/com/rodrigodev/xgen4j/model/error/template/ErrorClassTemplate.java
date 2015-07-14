package com.rodrigodev.xgen4j.model.error.template;

import com.rodrigodev.xgen4j.model.common.template.FreemarkerClassTemplate;
import com.rodrigodev.xgen4j.model.error.ErrorClassDefinition;
import com.rodrigodev.xgen4j.model.error.ErrorClassFile;
import com.rodrigodev.xgen4j.model.error.exception.ExceptionClassFile;
import com.rodrigodev.xgen4j.model.error.template.ErrorClassTemplateModel.ErrorClassTemplateModelBuilder;
import lombok.NonNull;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
public class ErrorClassTemplate extends FreemarkerClassTemplate<ErrorClassTemplateModel, ErrorClassDefinition> {

    private static final String TEMPLATE_FILE_NAME = "error-class-def.ftl";

    public ErrorClassTemplate(
            InjectedFields injectedFields,
            @NonNull Optional<ErrorClassFile> rootErrorClassFile,
            @NonNull Optional<ExceptionClassFile> rootExceptionClassFile,
            ErrorClassFile errorClassFile,
            @NonNull ExceptionClassFile exceptionClassFile,
            Optional<ErrorClassFile> parentClassFile
    ) {
        super(
                injectedFields,
                TEMPLATE_FILE_NAME,
                modelBuilder(rootErrorClassFile, rootExceptionClassFile, errorClassFile, exceptionClassFile),
                errorClassFile,
                parentClassFile
        );
    }

    private static ErrorClassTemplateModelBuilder modelBuilder(
            Optional<ErrorClassFile> rootErrorClassFile,
            Optional<ExceptionClassFile> rootExceptionClassFile,
            ErrorClassFile errorClassFile,
            ExceptionClassFile exceptionClassFile
    ) {
        ErrorClassTemplateModelBuilder modelBuilder = ErrorClassTemplateModel.builder();
        rootErrorClassFile.ifPresent(modelBuilder::rootErrorClassFile);
        rootExceptionClassFile.ifPresent(modelBuilder::rootExceptionClassFile);
        return modelBuilder.errorClassFile(errorClassFile)
                .exceptionClassFile(exceptionClassFile);
    }
}
