package com.rodrigodev.xgen.model.information.error;

import com.rodrigodev.xgen.model.common.template.FreemarkerClassTemplate;
import com.rodrigodev.xgen.model.error.ErrorClassFile;
import com.rodrigodev.xgen.model.information.error.ErrorInfoClassTemplateModel.ErrorInfoClassTemplateModelBuilder;
import lombok.NonNull;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
public class ErrorInfoClassTemplate extends FreemarkerClassTemplate<ErrorInfoClassTemplateModel, ErrorInfoClassTemplateModelBuilder, ErrorInfoClassDefinition> {

    public static final String TEMPLATE_FILE_NAME = "error-info-class-def.ftl";

    //TODO change to builder?
    public ErrorInfoClassTemplate(
            InjectedFields injectedFields,
            ErrorInfoClassFile errorInfoClassFile,
            @NonNull ErrorClassFile rootErrorClassFile
    ) {
        super(
                injectedFields,
                TEMPLATE_FILE_NAME,
                modelBuilder(rootErrorClassFile),
                errorInfoClassFile,
                Optional.empty()
        );
    }

    private static ErrorInfoClassTemplateModelBuilder modelBuilder(ErrorClassFile rootErrorClassFile) {
        ErrorInfoClassTemplateModelBuilder modelBuilder = ErrorInfoClassTemplateModel.builder();
        modelBuilder.rootError(rootErrorClassFile.classDefinition());
        return modelBuilder;
    }
}
