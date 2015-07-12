package com.rodrigodev.xgen.model.error;

import com.rodrigodev.xgen.model.common.template.FreemarkerClassTemplate;
import com.rodrigodev.xgen.model.error.ErrorClassTemplateModel.ErrorClassTemplateModelBuilder;
import com.rodrigodev.xgen.model.error.configuration.definition.ErrorDefinition;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassFile;
import lombok.NonNull;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
public class ErrorClassTemplate extends FreemarkerClassTemplate<ErrorClassTemplateModel, ErrorClassDefinition> {

    public static final String TEMPLATE_FILE_NAME = "error-class-def.ftl";

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
        ErrorDefinition errorDefinition = errorClassFile.classDefinition().errorDefinition();
        errorDefinition.description().ifPresent(modelBuilder::description);
        errorDefinition.customMessageGenerator().ifPresent(modelBuilder::generator);
        modelBuilder.code(errorDefinition.code());
        modelBuilder.exceptionName(exceptionClassFile.classDefinition().name());
        rootErrorClassFile.ifPresent(r -> modelBuilder.root(r.classDefinition()));
        rootExceptionClassFile.ifPresent(r -> modelBuilder.rootException(r.classDefinition()));
        modelBuilder.common(errorDefinition.isCommon());
        return modelBuilder;
    }
}
