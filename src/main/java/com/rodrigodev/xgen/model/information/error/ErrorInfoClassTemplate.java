package com.rodrigodev.xgen.model.information.error;

import com.rodrigodev.xgen.model.common.template.FreemarkerClassTemplate;
import com.rodrigodev.xgen.model.error.ErrorClassFile;
import lombok.NonNull;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
public class ErrorInfoClassTemplate extends FreemarkerClassTemplate<ErrorInfoClassTemplateModel, ErrorInfoClassDefinition> {

    public static final String TEMPLATE_FILE_NAME = "error-info-class-def.ftl";

    public ErrorInfoClassTemplate(
            InjectedFields injectedFields,
            ErrorInfoClassFile errorInfoClassFile,
            @NonNull ErrorClassFile rootErrorClassFile
    ) {
        super(
                injectedFields,
                TEMPLATE_FILE_NAME,
                ErrorInfoClassTemplateModel.builder().rootErrorClassFile(rootErrorClassFile),
                errorInfoClassFile,
                Optional.empty()
        );
    }
}
