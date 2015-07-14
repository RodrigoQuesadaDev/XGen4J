package com.rodrigodev.xgen.model.support.optional;

import com.rodrigodev.xgen.model.common.file.ClassWriter;
import com.rodrigodev.xgen.model.error.ErrorClassFile;
import lombok.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Singleton
public class OptionalClassWriter {

    @Inject ClassWriter classWriter;
    @Inject OptionalClassTemplateFactory optionalClassTemplateFactory;

    @Inject
    public OptionalClassWriter() {
    }

    public void write(
            @NonNull String sourceDirPath,
            @NonNull ErrorClassFile rootErrorClassFile
    ) {
        String rootPackagePath = rootErrorClassFile.classDefinition().packagePath();
        OptionalClassDefinition optionalInfoClass = new OptionalClassDefinition(rootPackagePath);
        OptionalClassFile optionalClassFile = new OptionalClassFile(sourceDirPath, optionalInfoClass);
        classWriter.write(optionalClassTemplateFactory.create(optionalClassFile));
    }
}
