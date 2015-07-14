package com.rodrigodev.xgen4j.model.error.exception;

import com.rodrigodev.xgen4j.GenerationOptions;
import com.rodrigodev.xgen4j.model.common.file.ClassWriter;
import com.rodrigodev.xgen4j.model.error.configuration.definition.ErrorDefinition;
import lombok.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
@Singleton
public class ExceptionClassWriter {

    @Inject ClassWriter classWriter;
    @Inject ExceptionClassTemplateFactory exceptionClassTemplateFactory;

    @Inject
    public ExceptionClassWriter() {
    }

    public ExceptionClassFile write(
            @NonNull String sourceDirPath,
            @NonNull Optional<ExceptionClassFile> rootExceptionClassFile,
            @NonNull ErrorDefinition errorDefinition,
            @NonNull Optional<ExceptionClassFile> parentClassFile,
            @NonNull GenerationOptions generationOptions
    ) {
        ExceptionClassDefinition exceptionClass = new ExceptionClassDefinition(errorDefinition, generationOptions);
        ExceptionClassFile exceptionClassFile = new ExceptionClassFile(sourceDirPath, exceptionClass);
        classWriter.write(exceptionClassTemplateFactory.create(
                rootExceptionClassFile, exceptionClassFile, parentClassFile
        ));

        return exceptionClassFile;
    }
}
