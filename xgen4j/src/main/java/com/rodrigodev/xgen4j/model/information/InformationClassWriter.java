package com.rodrigodev.xgen.model.information;

import com.google.common.collect.ImmutableList;
import com.rodrigodev.xgen.model.common.clazz.ErrorExceptionClassDefinitionPair;
import com.rodrigodev.xgen.model.common.file.ClassWriter;
import com.rodrigodev.xgen.model.error.ErrorClassFile;
import com.rodrigodev.xgen.model.information.template.InformationClassTemplateFactory;
import lombok.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 11/07/15.
 */
@Singleton
public class InformationClassWriter {

    @Inject ClassWriter classWriter;
    @Inject InformationClassTemplateFactory informationClassTemplateFactory;

    @Inject
    public InformationClassWriter() {
    }

    public void write(
            @NonNull String sourceDirPath,
            @NonNull ErrorClassFile rootErrorClassFile,
            ImmutableList<ErrorExceptionClassDefinitionPair> errorExceptionPairs
    ) {
        String rootPackagePath = rootErrorClassFile.classDefinition().packagePath();
        InformationClassDefinition errorCodeClass = new InformationClassDefinition(rootPackagePath);
        InformationClassFile informationClassFile = new InformationClassFile(sourceDirPath, errorCodeClass);
        classWriter.write(informationClassTemplateFactory.create(informationClassFile, errorExceptionPairs));
    }
}
