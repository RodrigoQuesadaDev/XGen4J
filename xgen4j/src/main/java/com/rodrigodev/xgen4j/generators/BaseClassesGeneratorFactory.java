package com.rodrigodev.xgen4j.generators;

import com.rodrigodev.xgen4j.generators.BaseClassesGenerator.InjectedFields;
import com.rodrigodev.xgen4j.model.error.configuration.definition.RootErrorDefinition;

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
