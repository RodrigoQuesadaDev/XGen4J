package com.rodrigodev.xgen.model.information;

import com.google.common.collect.ImmutableList;
import com.rodrigodev.xgen.model.common.clazz.ErrorExceptionClassDefinitionPair;
import com.rodrigodev.xgen.model.common.file.ClassWriter;
import com.rodrigodev.xgen.model.error.ErrorClassFile;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassFile;
import com.rodrigodev.xgen.model.information.error.ErrorInfoClassDefinition;
import com.rodrigodev.xgen.model.information.error.ErrorInfoClassFile;
import com.rodrigodev.xgen.model.information.error.ErrorInfoClassTemplateFactory;
import com.rodrigodev.xgen.model.information.exception.ExceptionInfoClassDefinition;
import com.rodrigodev.xgen.model.information.exception.ExceptionInfoClassFile;
import com.rodrigodev.xgen.model.information.exception.ExceptionInfoClassTemplateFactory;
import lombok.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
@Singleton
public class InformationClassesWriter {

    @Inject ClassWriter classWriter;
    @Inject InformationClassTemplateFactory informationClassTemplateFactory;
    @Inject ErrorInfoClassTemplateFactory errorInfoClassTemplateFactory;
    @Inject ExceptionInfoClassTemplateFactory exceptionInfoClassTemplateFactory;

    @Inject
    public InformationClassesWriter() {
    }

    public InformationClassFile write(
            @NonNull String sourceDirPath,
            @NonNull ErrorClassFile rootErrorClassFile,
            @NonNull ExceptionClassFile rootExceptionClassFile,
            ImmutableList<ErrorExceptionClassDefinitionPair> errorExceptionPairs
    ) {
        String rootPackagePath = rootErrorClassFile.classDefinition().packagePath();
        InformationClassDefinition errorCodeClass = new InformationClassDefinition(rootPackagePath);
        InformationClassFile informationClassFile = new InformationClassFile(sourceDirPath, errorCodeClass);
        classWriter.write(informationClassTemplateFactory.create(informationClassFile, errorExceptionPairs));

        ErrorInfoClassDefinition errorInfoClass = new ErrorInfoClassDefinition(rootPackagePath);
        ErrorInfoClassFile errorInfoClassFile = new ErrorInfoClassFile(sourceDirPath, errorInfoClass);
        classWriter.write(errorInfoClassTemplateFactory.create(errorInfoClassFile, rootErrorClassFile));

        ExceptionInfoClassDefinition exceptionInfoClass = new ExceptionInfoClassDefinition(rootPackagePath);
        ExceptionInfoClassFile exceptionInfoClassFile = new ExceptionInfoClassFile(sourceDirPath, exceptionInfoClass);
        classWriter.write(exceptionInfoClassTemplateFactory.create(
                exceptionInfoClassFile, rootErrorClassFile, rootExceptionClassFile
        ));

        //TODO change this?

        return informationClassFile;
    }
}
