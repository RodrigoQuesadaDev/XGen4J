package com.rodrigodev.xgen.generators;

import com.rodrigodev.xgen.GenerationOptions;
import com.rodrigodev.xgen.generators.InformationClassesGenerator.InjectedFields;
import com.rodrigodev.xgen.model.common.clazz.ErrorExceptionClassDefinitionPair;
import com.rodrigodev.xgen.model.error.ErrorClassFile;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassFile;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Singleton
public class InformationClassesGeneratorFactory {

    @Inject protected InjectedFields injectedFields;

    @Inject
    public InformationClassesGeneratorFactory() {
    }

    public InformationClassesGenerator create(
            String sourceDirPath,
            ErrorClassFile rootErrorClassFile,
            ExceptionClassFile rootExceptionClassFile,
            List<ErrorExceptionClassDefinitionPair> errorExceptionPairs,
            GenerationOptions options
    ) {
        return new InformationClassesGenerator(
                injectedFields, sourceDirPath, rootErrorClassFile, rootExceptionClassFile, errorExceptionPairs, options
        );
    }
}
