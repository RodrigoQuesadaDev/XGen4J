package com.rodrigodev.xgen.model.information.exception;

import com.rodrigodev.xgen.model.common.file.ClassWriter;
import com.rodrigodev.xgen.model.error.ErrorClassFile;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassFile;
import lombok.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 11/07/15.
 */
@Singleton
public class ExceptionInfoClassWriter {

    @Inject ClassWriter classWriter;
    @Inject ExceptionInfoClassTemplateFactory exceptionInfoClassTemplateFactory;

    @Inject
    public ExceptionInfoClassWriter() {
    }

    public void write(
            @NonNull String sourceDirPath,
            @NonNull ErrorClassFile rootErrorClassFile,
            @NonNull ExceptionClassFile rootExceptionClassFile
    ) {
        String rootPackagePath = rootErrorClassFile.classDefinition().packagePath();
        ExceptionInfoClassDefinition exceptionInfoClass = new ExceptionInfoClassDefinition(rootPackagePath);
        ExceptionInfoClassFile exceptionInfoClassFile = new ExceptionInfoClassFile(sourceDirPath, exceptionInfoClass);
        classWriter.write(exceptionInfoClassTemplateFactory.create(
                exceptionInfoClassFile, rootErrorClassFile, rootExceptionClassFile
        ));
    }
}
