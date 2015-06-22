package com.rodrigodev.xgen.writer.template.error;

import com.rodrigodev.xgen.writer.file_definition.ErrorClassDefinition;
import com.rodrigodev.xgen.writer.file_definition.ErrorClassFile;
import com.rodrigodev.xgen.writer.file_definition.ExceptionClassFile;
import com.rodrigodev.xgen.writer.template.FreemarkerClassTemplate;
import com.rodrigodev.xgen.writer.template.error.ErrorClassTemplateModel.ErrorClassTemplateModelBuilder;
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
            ErrorClassFile errorClassFile,
            @NonNull ExceptionClassFile exceptionClassFile,
            Optional<ErrorClassFile> parentClassFile
    ) {
        super(
                injectedFields,
                TEMPLATE_FILE_NAME,
                modelBuilder(errorClassFile, exceptionClassFile),
                errorClassFile,
                parentClassFile
        );
    }

    private static ErrorClassTemplateModelBuilder modelBuilder(
            ErrorClassFile errorClassFile,
            ExceptionClassFile exceptionClassFile
    ) {
        ErrorClassTemplateModelBuilder modelBuilder = ErrorClassTemplateModel.builder();
        errorClassFile.classDefinition().errorDefinition().description().ifPresent(modelBuilder::description);
        modelBuilder.exceptionName(exceptionClassFile.classDefinition().name());
        return modelBuilder;
    }
}
