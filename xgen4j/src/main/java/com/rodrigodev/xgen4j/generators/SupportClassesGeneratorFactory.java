package com.rodrigodev.xgen4j.generators;

import com.rodrigodev.xgen4j.GenerationOptions;
import com.rodrigodev.xgen4j.generators.SupportClassesGenerator.InjectedFields;
import com.rodrigodev.xgen4j.model.error.ErrorClassFile;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Singleton
public class SupportClassesGeneratorFactory {

    @Inject protected InjectedFields injectedFields;

    @Inject
    public SupportClassesGeneratorFactory() {
    }

    public SupportClassesGenerator create(
            String sourceDirPath,
            ErrorClassFile rootErrorClassFile,
            GenerationOptions options
    ) {
        return new SupportClassesGenerator(injectedFields, sourceDirPath, rootErrorClassFile, options);
    }
}
