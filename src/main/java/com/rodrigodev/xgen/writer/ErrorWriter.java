package com.rodrigodev.xgen.writer;

import com.rodrigodev.xgen.configuration.ErrorDefinition;
import com.rodrigodev.xgen.writer.file_definition.ErrorClassDefinition;
import com.rodrigodev.xgen.writer.file_definition.ErrorClassFile;
import com.rodrigodev.xgen.writer.file_definition.ExceptionClassFile;
import com.rodrigodev.xgen.writer.template.error.ErrorClassTemplateFactory;
import lombok.NonNull;

import javax.inject.Inject;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
public class ErrorWriter {

    @Inject ClassWriter classWriter;
    @Inject ErrorClassTemplateFactory errorClassTemplateFactory;

    @Inject
    public ErrorWriter() {
    }

    public void write(
            @NonNull String sourceDirPath,
            @NonNull ErrorDefinition errorDefinition,
            @NonNull ExceptionClassFile exceptionClassFile
    ) {
        ErrorClassDefinition errorClass = new ErrorClassDefinition(errorDefinition);
        ErrorClassFile errorClassFile = new ErrorClassFile(sourceDirPath, errorClass);
        classWriter.write(errorClassTemplateFactory.create(errorClassFile, exceptionClassFile));
    }
}
