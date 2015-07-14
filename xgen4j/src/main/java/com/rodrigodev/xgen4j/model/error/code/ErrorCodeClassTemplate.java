package com.rodrigodev.xgen4j.model.error.code;

import com.rodrigodev.xgen4j.model.common.template.FreemarkerClassTemplate;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 25/06/15.
 */
public class ErrorCodeClassTemplate extends FreemarkerClassTemplate<ErrorCodeClassTemplateModel, ErrorCodeClassDefinition> {

    private static final String TEMPLATE_FILE_NAME = "error-code-class-def.ftl";

    public ErrorCodeClassTemplate(InjectedFields injectedFields, ErrorCodeClassFile errorCodeClassFile) {
        super(
                injectedFields,
                TEMPLATE_FILE_NAME,
                ErrorCodeClassTemplateModel.builder().errorCodeClassFile(errorCodeClassFile),
                errorCodeClassFile,
                Optional.empty()
        );
    }
}
