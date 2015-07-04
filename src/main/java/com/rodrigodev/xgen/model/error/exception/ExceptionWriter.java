package com.rodrigodev.xgen.model.error.exception;

import com.rodrigodev.xgen.model.common.file.ClassWriter;
import com.rodrigodev.xgen.model.error.configuration.ErrorDefinition;
import lombok.NonNull;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
public class ExceptionWriter {

    @Inject ClassWriter classWriter;
    @Inject ExceptionClassTemplateFactory exceptionClassTemplateFactory;

    @Inject
    public ExceptionWriter() {
    }

    public ExceptionClassFile write(
            @NonNull String sourceDirPath,
            @NonNull Optional<ExceptionClassFile> rootExceptionClassFile,
            @NonNull ErrorDefinition errorDefinition,
            @NonNull Optional<ExceptionClassFile> parentClassFile
    ) {
        ExceptionClassDefinition exceptionClass = new ExceptionClassDefinition(errorDefinition);
        ExceptionClassFile exceptionClassFile = new ExceptionClassFile(sourceDirPath, exceptionClass);
        classWriter.write(exceptionClassTemplateFactory.create(
                rootExceptionClassFile, exceptionClassFile, parentClassFile
        ));

        return exceptionClassFile;
    }
}
