package com.rodrigodev.xgen4j.model.error;

import com.rodrigodev.xgen4j.model.common.file.ClassWriter;
import com.rodrigodev.xgen4j.model.error.configuration.definition.ErrorDefinition;
import com.rodrigodev.xgen4j.model.error.exception.ExceptionClassFile;
import com.rodrigodev.xgen4j.model.error.template.ErrorClassTemplateFactory;
import lombok.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
@Singleton
public class ErrorClassWriter {

    @Inject ClassWriter classWriter;
    @Inject ErrorClassTemplateFactory errorClassTemplateFactory;

    @Inject
    public ErrorClassWriter() {
    }

    public ErrorClassFile write(
            @NonNull String sourceDirPath,
            @NonNull Optional<ErrorClassFile> rootErrorClassFile,
            @NonNull Optional<ExceptionClassFile> rootExceptionClassFile,
            @NonNull ErrorDefinition errorDefinition,
            @NonNull ExceptionClassFile exceptionClassFile,
            @NonNull Optional<ErrorClassFile> parentClassFile
    ) {
        ErrorClassDefinition errorClass = new ErrorClassDefinition(errorDefinition);
        ErrorClassFile errorClassFile = new ErrorClassFile(sourceDirPath, errorClass);
        classWriter.write(errorClassTemplateFactory.create(
                rootErrorClassFile,
                rootExceptionClassFile,
                errorClassFile,
                exceptionClassFile,
                parentClassFile
        ));

        return errorClassFile;
    }
}
