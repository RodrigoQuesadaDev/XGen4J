package com.rodrigodev.xgen4j;

import com.rodrigodev.xgen4j.generators.*;
import com.rodrigodev.xgen4j.model.error.configuration.definition.RootErrorDefinition;
import lombok.NonNull;

import javax.inject.Inject;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.google.common.base.Preconditions.*;

/**
 * Created by Rodrigo Quesada on 12/05/15.
 */
public class ExceptionsGenerator {

    public static class InjectedFields {

        @Inject BaseClassesGeneratorFactory baseClassesGeneratorFactory;
        @Inject ErrorClassesGeneratorFactory errorClassesGeneratorFactory;
        @Inject InformationClassesGeneratorFactory informationClassesGeneratorFactory;
        @Inject SupportClassesGeneratorFactory supportClassesGeneratorFactory;

        @Inject
        public InjectedFields() {
        }
    }

    @Inject InjectedFields inj;
    private final String sourceDirPath;

    ExceptionsGenerator(@NonNull InjectedFields injectedFields, @NonNull String sourceDirPath) {
        this.inj = injectedFields;
        this.sourceDirPath = sourceDirPath;
    }

    public ExceptionsGenerator(@NonNull String sourceDirPath) {
        checkArgument(Files.exists(Paths.get(sourceDirPath)), "Source directory doesn't exist.");

        this.sourceDirPath = sourceDirPath;
        DaggerExceptionsGeneratorComponent.builder()
                .mainModule(new MainModule(sourceDirPath))
                .build().inject(this);
    }

    public void generate(@NonNull RootErrorDefinition rootError, @NonNull GenerationOptions options) {
        inj.baseClassesGeneratorFactory.create(sourceDirPath, rootError).generate();
        ErrorClassesGenerator errorClassesGenerator = inj.errorClassesGeneratorFactory.create(
                sourceDirPath, rootError, options
        );
        errorClassesGenerator.generate();
        inj.informationClassesGeneratorFactory.create(
                sourceDirPath,
                errorClassesGenerator.rootErrorClassFile(),
                errorClassesGenerator.rootExceptionClassFile(),
                errorClassesGenerator.errorExceptionPairs(),
                options
        ).generate();
        inj.supportClassesGeneratorFactory.create(
                sourceDirPath, errorClassesGenerator.rootErrorClassFile(), options
        ).generate();
    }

    public void generate(@NonNull RootErrorDefinition rootError) {
        generate(rootError, GenerationOptions.builder().build());
    }
}
