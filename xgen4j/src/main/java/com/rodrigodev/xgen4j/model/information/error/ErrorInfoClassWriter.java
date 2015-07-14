package com.rodrigodev.xgen4j.model.information.error;

import com.rodrigodev.xgen4j.GenerationOptions;
import com.rodrigodev.xgen4j.model.common.file.ClassWriter;
import com.rodrigodev.xgen4j.model.error.ErrorClassFile;
import lombok.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 11/07/15.
 */
@Singleton
public class ErrorInfoClassWriter {

    @Inject ClassWriter classWriter;
    @Inject ErrorInfoClassTemplateFactory errorInfoClassTemplateFactory;

    @Inject
    public ErrorInfoClassWriter() {
    }

    public void write(
            @NonNull String sourceDirPath,
            @NonNull ErrorClassFile rootErrorClassFile,
            @NonNull GenerationOptions generationOptions
    ) {
        String rootPackagePath = rootErrorClassFile.classDefinition().packagePath();
        ErrorInfoClassDefinition errorInfoClass = new ErrorInfoClassDefinition(rootPackagePath, generationOptions);
        ErrorInfoClassFile errorInfoClassFile = new ErrorInfoClassFile(sourceDirPath, errorInfoClass);
        classWriter.write(errorInfoClassTemplateFactory.create(errorInfoClassFile, rootErrorClassFile));
    }
}
