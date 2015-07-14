package com.rodrigodev.xgen.model.information.exception.template;

import com.rodrigodev.xgen.model.common.template.FreemarkerClassTemplate;
import com.rodrigodev.xgen.model.error.ErrorClassFile;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassFile;
import com.rodrigodev.xgen.model.information.exception.ExceptionInfoClassDefinition;
import com.rodrigodev.xgen.model.information.exception.ExceptionInfoClassFile;
import lombok.NonNull;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
public class ExceptionInfoClassTemplate extends FreemarkerClassTemplate<ExceptionInfoClassTemplateModel, ExceptionInfoClassDefinition> {

    private static final String TEMPLATE_FILE_NAME = "exception-info-class-def.ftl";

    public ExceptionInfoClassTemplate(
            InjectedFields injectedFields,
            ExceptionInfoClassFile exceptionInfoClassFile,
            @NonNull ErrorClassFile rootErrorClassFile,
            @NonNull ExceptionClassFile rootExceptionClassFile
    ) {
        super(
                injectedFields,
                TEMPLATE_FILE_NAME,
                ExceptionInfoClassTemplateModel.builder()
                        .exceptionInfoClassFile(exceptionInfoClassFile)
                        .rootErrorClassFile(rootErrorClassFile)
                        .rootExceptionClassFile(rootExceptionClassFile),
                exceptionInfoClassFile,
                Optional.empty()
        );
    }
}
