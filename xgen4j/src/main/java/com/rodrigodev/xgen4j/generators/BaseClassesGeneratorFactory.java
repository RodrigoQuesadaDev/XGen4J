package com.rodrigodev.xgen.generators;

import com.rodrigodev.xgen.generators.BaseClassesGenerator.InjectedFields;
import com.rodrigodev.xgen.model.error.configuration.definition.RootErrorDefinition;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Singleton
public class BaseClassesGeneratorFactory {

    @Inject protected InjectedFields injectedFields;

    @Inject
    public BaseClassesGeneratorFactory() {
    }

    public BaseClassesGenerator create(
            String sourceDirPath, RootErrorDefinition rootError
    ) {
        return new BaseClassesGenerator(injectedFields, sourceDirPath, rootError);
    }
}
