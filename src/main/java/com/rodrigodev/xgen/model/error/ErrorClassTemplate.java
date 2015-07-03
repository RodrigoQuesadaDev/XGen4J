package com.rodrigodev.xgen.model.error;

import com.rodrigodev.xgen.model.common.template.FreemarkerClassTemplate;
import com.rodrigodev.xgen.model.error.ErrorClassTemplateModel.ErrorClassTemplateModelBuilder;
import com.rodrigodev.xgen.model.error.configuration.ErrorDefinition;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassFile;
import lombok.NonNull;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
public class ErrorClassTemplate extends FreemarkerClassTemplate<ErrorClassTemplateModel, ErrorClassTemplateModelBuilder, ErrorClassDefinition> {

    public static final String TEMPLATE_FILE_NAME = "error-class-def.ftl";

    //TODO change to builder?
    public ErrorClassTemplate(
            InjectedFields injectedFields,
            @NonNull String rootPackage,
            ErrorClassFile errorClassFile,
            @NonNull ExceptionClassFile exceptionClassFile,
            Optional<ErrorClassFile> parentClassFile
    ) {
        super(
                injectedFields,
                TEMPLATE_FILE_NAME,
                modelBuilder(rootPackage, errorClassFile, exceptionClassFile),
                errorClassFile,
                parentClassFile
        );
    }

    private static ErrorClassTemplateModelBuilder modelBuilder(
            String rootPackage,
            ErrorClassFile errorClassFile,
            ExceptionClassFile exceptionClassFile
    ) {
        ErrorClassTemplateModelBuilder modelBuilder = ErrorClassTemplateModel.builder();
        ErrorDefinition errorDefinition = errorClassFile.classDefinition().errorDefinition();
        errorDefinition.description().ifPresent(modelBuilder::description);
        errorDefinition.customMessageGenerator().ifPresent(modelBuilder::generator);
        modelBuilder.code(errorDefinition.code());
        modelBuilder.exceptionName(exceptionClassFile.classDefinition().name());
        modelBuilder.rootPackage(rootPackage);
        return modelBuilder;
    }
}
