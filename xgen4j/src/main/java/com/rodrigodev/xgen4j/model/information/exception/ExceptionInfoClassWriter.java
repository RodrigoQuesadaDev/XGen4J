package com.rodrigodev.xgen4j.model.information.exception;

import com.rodrigodev.xgen4j.GenerationOptions;
import com.rodrigodev.xgen4j.model.common.file.ClassWriter;
import com.rodrigodev.xgen4j.model.error.ErrorClassFile;
import com.rodrigodev.xgen4j.model.error.exception.ExceptionClassFile;
import com.rodrigodev.xgen4j.model.information.exception.template.ExceptionInfoClassTemplateFactory;
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
            @NonNull ExceptionClassFile rootExceptionClassFile,
            @NonNull GenerationOptions generationOptions
    ) {
        String rootPackagePath = rootErrorClassFile.classDefinition().packagePath();
        ExceptionInfoClassDefinition exceptionInfoClass
                = new ExceptionInfoClassDefinition(rootPackagePath, generationOptions);
        ExceptionInfoClassFile exceptionInfoClassFile = new ExceptionInfoClassFile(sourceDirPath, exceptionInfoClass);
        classWriter.write(exceptionInfoClassTemplateFactory.create(
                exceptionInfoClassFile, rootErrorClassFile, rootExceptionClassFile
        ));
    }
}
