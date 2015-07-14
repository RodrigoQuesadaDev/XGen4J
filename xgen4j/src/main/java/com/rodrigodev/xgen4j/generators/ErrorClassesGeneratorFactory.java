package com.rodrigodev.xgen4j.generators;

import com.rodrigodev.xgen4j.GenerationOptions;
import com.rodrigodev.xgen4j.generators.ErrorClassesGenerator.InjectedFields;
import com.rodrigodev.xgen4j.model.error.configuration.definition.RootErrorDefinition;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Singleton
public class ErrorClassesGeneratorFactory {

    @Inject protected InjectedFields injectedFields;

    @Inject
    public ErrorClassesGeneratorFactory() {
    }

    public ErrorClassesGenerator create(
            String sourceDirPath, RootErrorDefinition rootError, GenerationOptions options
    ) {
        return new ErrorClassesGenerator(injectedFields, sourceDirPath, rootError, options);
    }
}
