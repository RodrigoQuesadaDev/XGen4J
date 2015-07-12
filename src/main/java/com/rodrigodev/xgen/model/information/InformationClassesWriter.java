package com.rodrigodev.xgen.model.information;

import com.google.common.collect.ImmutableList;
import com.rodrigodev.xgen.model.common.clazz.ErrorExceptionClassDefinitionPair;
import com.rodrigodev.xgen.model.error.ErrorClassFile;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassFile;
import com.rodrigodev.xgen.model.information.error.ErrorInfoClassWriter;
import com.rodrigodev.xgen.model.information.exception.ExceptionInfoClassWriter;
import lombok.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
@Singleton
public class InformationClassesWriter {

    @Inject InformationClassWriter informationClassWriter;
    @Inject ErrorInfoClassWriter errorInfoClassWriter;
    @Inject ExceptionInfoClassWriter exceptionInfoClassWriter;

    @Inject
    public InformationClassesWriter() {
    }

    public void write(
            @NonNull String sourceDirPath,
            @NonNull ErrorClassFile rootErrorClassFile,
            @NonNull ExceptionClassFile rootExceptionClassFile,
            ImmutableList<ErrorExceptionClassDefinitionPair> errorExceptionPairs
    ) {
        informationClassWriter.write(sourceDirPath, rootErrorClassFile, errorExceptionPairs);
        errorInfoClassWriter.write(sourceDirPath, rootErrorClassFile);
        exceptionInfoClassWriter.write(sourceDirPath, rootErrorClassFile, rootExceptionClassFile);
    }
}
