package com.rodrigodev.xgen.model.information.error;

import com.rodrigodev.xgen.model.common.file.ClassWriter;
import com.rodrigodev.xgen.model.error.ErrorClassFile;
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

    public void write(@NonNull String sourceDirPath, @NonNull ErrorClassFile rootErrorClassFile) {
        String rootPackagePath = rootErrorClassFile.classDefinition().packagePath();
        ErrorInfoClassDefinition errorInfoClass = new ErrorInfoClassDefinition(rootPackagePath);
        ErrorInfoClassFile errorInfoClassFile = new ErrorInfoClassFile(sourceDirPath, errorInfoClass);
        classWriter.write(errorInfoClassTemplateFactory.create(errorInfoClassFile, rootErrorClassFile));
    }
}
