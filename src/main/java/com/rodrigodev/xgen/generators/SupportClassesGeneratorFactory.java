package com.rodrigodev.xgen.generators;

import com.rodrigodev.xgen.GenerationOptions;
import com.rodrigodev.xgen.generators.SupportClassesGenerator.InjectedFields;
import com.rodrigodev.xgen.model.error.ErrorClassFile;

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
