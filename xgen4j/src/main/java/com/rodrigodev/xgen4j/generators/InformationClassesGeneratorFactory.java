package com.rodrigodev.xgen4j.generators;

import com.rodrigodev.xgen4j.GenerationOptions;
import com.rodrigodev.xgen4j.generators.InformationClassesGenerator.InjectedFields;
import com.rodrigodev.xgen4j.model.common.clazz.ErrorExceptionClassDefinitionPair;
import com.rodrigodev.xgen4j.model.error.ErrorClassFile;
import com.rodrigodev.xgen4j.model.error.exception.ExceptionClassFile;

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
