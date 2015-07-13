package com.rodrigodev.xgen;

import com.google.common.collect.ImmutableList;
import com.rodrigodev.xgen.model.common.clazz.ErrorExceptionClassDefinitionPair;
import com.rodrigodev.xgen.model.error.ErrorClassFile;
import com.rodrigodev.xgen.model.error.ErrorClassWriter;
import com.rodrigodev.xgen.model.error.code.ErrorCodeClassWriter;
import com.rodrigodev.xgen.model.error.configuration.definition.ErrorDefinition;
import com.rodrigodev.xgen.model.error.configuration.definition.RootErrorDefinition;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassFile;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassWriter;
import com.rodrigodev.xgen.model.information.InformationClassesWriter;
import com.rodrigodev.xgen.model.support.optional.OptionalClassType;
import com.rodrigodev.xgen.model.support.optional.OptionalClassWriter;
import lombok.NonNull;

import javax.inject.Inject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.*;

/**
 * Created by Rodrigo Quesada on 12/05/15.
 */
public class ExceptionsGenerator {

    public static class InjectedFields {

        @Inject ErrorCodeClassWriter errorCodeClassWriter;
        @Inject ErrorClassWriter errorClassWriter;
        @Inject ExceptionClassWriter exceptionClassWriter;
        @Inject InformationClassesWriter informationClassesWriter;
        @Inject OptionalClassWriter optionalClassWriter;

        @Inject
        public InjectedFields() {
        }
    }

    @Inject InjectedFields inj;
    private final String sourceDirPath;

    private Optional<ErrorClassFile> rootErrorClassFile;
    private Optional<ExceptionClassFile> rootExceptionClassFile;
    private List<ErrorExceptionClassDefinitionPair> errorExceptionPairs;
    private GenerationOptions options;

    ExceptionsGenerator(
            InjectedFields injectedFields,
            String sourceDirPath
    ) {
        this.inj = injectedFields;
        this.sourceDirPath = sourceDirPath;
        init(options);
    }

    public ExceptionsGenerator(@NonNull String sourceDirPath) {
        checkArgument(Files.exists(Paths.get(sourceDirPath)), "Source directory doesn't exist.");

        this.sourceDirPath = sourceDirPath;
        DaggerExceptionsGeneratorComponent.builder()
                .mainModule(new MainModule(sourceDirPath))
                .build().inject(this);
        init(options);
    }

    private void init(GenerationOptions options) {
        rootErrorClassFile = Optional.empty();
        rootExceptionClassFile = Optional.empty();
        errorExceptionPairs = new ArrayList<>();
        this.options = options;
    }

    public void generate(@NonNull RootErrorDefinition rootError, @NonNull GenerationOptions options) {
        init(options);
        generateBaseClasses(rootError);
        generateErrors(rootError, Optional.empty(), Optional.empty());
        generateInformationClasses();
        generateSupportClasses();
    }

    public void generate(@NonNull RootErrorDefinition rootError) {
        generate(rootError, GenerationOptions.builder().build());
    }

    private void generateBaseClasses(RootErrorDefinition rootError) {
        generateErrorCodeClass(rootError);
    }

    private void generateErrorCodeClass(RootErrorDefinition rootError) {
        inj.errorCodeClassWriter.write(sourceDirPath, rootError, rootError.code().number().isPresent());
    }

    private void generateErrors(
            ErrorDefinition error,
            Optional<ErrorClassFile> parentErrorClassFile,
            Optional<ExceptionClassFile> parentExceptionClassFile
    ) {
        ExceptionClassFile exceptionClassFile = inj.exceptionClassWriter.write(
                sourceDirPath, rootExceptionClassFile, error, parentExceptionClassFile, options
        );
        ErrorClassFile errorClassFile = inj.errorClassWriter.write(
                sourceDirPath,
                rootErrorClassFile,
                rootExceptionClassFile,
                error,
                exceptionClassFile,
                parentErrorClassFile
        );

        if (!rootErrorClassFile.isPresent()) {
            rootErrorClassFile = Optional.of(errorClassFile);
            rootExceptionClassFile = Optional.of(exceptionClassFile);
        }

        errorExceptionPairs.add(new ErrorExceptionClassDefinitionPair(
                errorClassFile.classDefinition(), exceptionClassFile.classDefinition()
        ));

        ErrorDefinition[] subErrors = error.errors();
        for (ErrorDefinition subError : subErrors) {
            generateErrors(
                    subError,
                    Optional.of(errorClassFile),
                    Optional.of(exceptionClassFile)
            );
        }
    }

    private void generateInformationClasses() {
        checkState(
                rootErrorClassFile.isPresent() && rootExceptionClassFile.isPresent(),
                "rootErrorClassFile or rootExceptionClassFile fields must be present"
        );
        checkState(!errorExceptionPairs.isEmpty(), "errorExceptionPairs is empty");

        inj.informationClassesWriter.write(
                sourceDirPath,
                rootErrorClassFile.get(),
                rootExceptionClassFile.get(),
                ImmutableList.copyOf(errorExceptionPairs),
                options
        );
    }

    private void generateSupportClasses() {
        if (options.optionalClassType() == OptionalClassType.CUSTOM) {
            inj.optionalClassWriter.write(sourceDirPath, rootErrorClassFile.get());
        }
    }

    //TODO refactor this class, it seems to be huge?
}
