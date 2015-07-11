package com.rodrigodev.xgen.model.error.code;

import com.rodrigodev.xgen.model.common.template.FreemarkerClassTemplate;
import com.rodrigodev.xgen.model.error.code.ErrorCodeClassTemplateModel.ErrorCodeClassTemplateModelBuilder;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 25/06/15.
 */
public class ErrorCodeClassTemplate extends FreemarkerClassTemplate<ErrorCodeClassTemplateModel, ErrorCodeClassDefinition> {

    public static final String TEMPLATE_FILE_NAME = "error-code-class-def.ftl";

    public ErrorCodeClassTemplate(InjectedFields injectedFields, ErrorCodeClassFile errorCodeClassFile) {
        super(
                injectedFields,
                TEMPLATE_FILE_NAME,
                modelBuilder(errorCodeClassFile),
                errorCodeClassFile,
                Optional.empty()
        );
    }

    private static ErrorCodeClassTemplateModelBuilder modelBuilder(ErrorCodeClassFile errorCodeClassFile) {
        ErrorCodeClassTemplateModelBuilder modelBuilder = ErrorCodeClassTemplateModel.builder();
        modelBuilder.hasNumber(errorCodeClassFile.classDefinition().hasNumber());
        return modelBuilder;
    }
}
