package com.rodrigodev.xgen.model.error;

import com.rodrigodev.xgen.model.common.file.ClassWriter;
import com.rodrigodev.xgen.model.error.configuration.ErrorDefinition;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassFile;
import lombok.NonNull;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
public class ErrorWriter {

    @Inject ClassWriter classWriter;
    @Inject ErrorClassTemplateFactory errorClassTemplateFactory;

    @Inject
    public ErrorWriter() {
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
