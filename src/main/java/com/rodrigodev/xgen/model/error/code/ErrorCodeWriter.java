package com.rodrigodev.xgen.model.error.code;

import com.rodrigodev.xgen.model.error.configuration.ErrorDefinition;
import com.rodrigodev.xgen.model.common.file.ClassWriter;
import lombok.NonNull;

import javax.inject.Inject;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
public class ErrorCodeWriter {

    @Inject ClassWriter classWriter;
    @Inject ErrorCodeClassTemplateFactory errorClassTemplateFactory;

    @Inject
    public ErrorCodeWriter() {
    }

    public ErrorCodeClassFile write(@NonNull String sourceDirPath, @NonNull ErrorDefinition rootError) {

        ErrorCodeClassDefinition errorCodeClass = new ErrorCodeClassDefinition(rootError.packagePath());
        ErrorCodeClassFile errorCodeClassFile = new ErrorCodeClassFile(sourceDirPath, errorCodeClass);
        classWriter.write(errorClassTemplateFactory.create(errorCodeClassFile));

        return errorCodeClassFile;
    }
}
