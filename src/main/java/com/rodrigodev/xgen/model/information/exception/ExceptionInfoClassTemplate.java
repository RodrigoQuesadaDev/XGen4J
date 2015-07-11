package com.rodrigodev.xgen.model.information.exception;

import com.rodrigodev.xgen.model.common.template.FreemarkerClassTemplate;
import com.rodrigodev.xgen.model.error.ErrorClassFile;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassFile;
import com.rodrigodev.xgen.model.information.exception.ExceptionInfoClassTemplateModel.ExceptionInfoClassTemplateModelBuilder;
import lombok.NonNull;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
public class ExceptionInfoClassTemplate extends FreemarkerClassTemplate<ExceptionInfoClassTemplateModel, ExceptionInfoClassDefinition> {

    public static final String TEMPLATE_FILE_NAME = "exception-info-class-def.ftl";

    public ExceptionInfoClassTemplate(
            InjectedFields injectedFields,
            ExceptionInfoClassFile exceptionInfoClassFile,
            @NonNull ErrorClassFile rootErrorClassFile,
            @NonNull ExceptionClassFile rootExceptionClassFile
    ) {
        super(
                injectedFields,
                TEMPLATE_FILE_NAME,
                modelBuilder(rootErrorClassFile, rootExceptionClassFile),
                exceptionInfoClassFile,
                Optional.empty()
        );
    }

    private static ExceptionInfoClassTemplateModelBuilder modelBuilder(
            ErrorClassFile rootErrorClassFile,
            ExceptionClassFile rootExceptionClassFile
    ) {
        ExceptionInfoClassTemplateModelBuilder modelBuilder = ExceptionInfoClassTemplateModel.builder();
        modelBuilder.rootError(rootErrorClassFile.classDefinition())
                .rootException(rootExceptionClassFile.classDefinition());
        return modelBuilder;
    }
}