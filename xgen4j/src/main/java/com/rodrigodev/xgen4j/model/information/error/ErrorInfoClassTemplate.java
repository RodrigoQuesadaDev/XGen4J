package com.rodrigodev.xgen4j.model.information.error;

import com.rodrigodev.xgen4j.model.common.template.FreemarkerClassTemplate;
import com.rodrigodev.xgen4j.model.error.ErrorClassFile;
import lombok.NonNull;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
public class ErrorInfoClassTemplate extends FreemarkerClassTemplate<ErrorInfoClassTemplateModel, ErrorInfoClassDefinition> {

    private static final String TEMPLATE_FILE_NAME = "error-info-class-def.ftl";

    public ErrorInfoClassTemplate(
            InjectedFields injectedFields,
            ErrorInfoClassFile errorInfoClassFile,
            @NonNull ErrorClassFile rootErrorClassFile
    ) {
        super(
                injectedFields,
                TEMPLATE_FILE_NAME,
                ErrorInfoClassTemplateModel.builder()
                        .errorInfoClassFile(errorInfoClassFile)
                        .rootErrorClassFile(rootErrorClassFile),
                errorInfoClassFile,
                Optional.empty()
        );
    }
}