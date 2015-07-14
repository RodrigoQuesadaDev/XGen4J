package com.rodrigodev.xgen4j.generators;

import com.rodrigodev.xgen4j.GenerationOptions;
import com.rodrigodev.xgen4j.model.common.clazz.ErrorExceptionClassDefinitionPair;
import com.rodrigodev.xgen4j.model.error.ErrorClassFile;
import com.rodrigodev.xgen4j.model.error.ErrorClassWriter;
import com.rodrigodev.xgen4j.model.error.configuration.definition.ErrorDefinition;
import com.rodrigodev.xgen4j.model.error.configuration.definition.RootErrorDefinition;
import com.rodrigodev.xgen4j.model.error.exception.ExceptionClassFile;
import com.rodrigodev.xgen4j.model.error.exception.ExceptionClassWriter;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@FieldDefaults(makeFinal = true)
@Accessors(fluent = true)
public class ErrorClassesGenerator extends ClassesGenerator {

    public static class InjectedFields {
        @Inject ErrorClassWriter errorClassWriter;
        @Inject ExceptionClassWriter exceptionClassWriter;

        @Inject
        public InjectedFields() {
        }
    }

    private InjectedFields inj;
    private RootErrorDefinition rootError;
    @NonFinal private Optional<ErrorClassFile> rootErrorClassFile;
    @NonFinal private Optional<ExceptionClassFile> rootExceptionClassFile;
    @Getter private List<ErrorExceptionClassDefinitionPair> errorExceptionPairs;
    private GenerationOptions options;

    protected ErrorClassesGenerator(
            @NonNull InjectedFields injectedFields,
            String sourceDirPath,
            @NonNull RootErrorDefinition rootError,
            @NonNull GenerationOptions options
    ) {
        super(sourceDirPath);
        this.inj = injectedFields;
        this.rootError = rootError;
        this.rootErrorClassFile = Optional.empty();
        this.rootExceptionClassFile = Optional.empty();
        this.errorExceptionPairs = new ArrayList<>();
        this.options = options;
    }

    public ErrorClassFile rootErrorClassFile() {
        return rootErrorClassFile.get();
    }

    public ExceptionClassFile rootExceptionClassFile() {
        return rootExceptionClassFile.get();
    }

    @Override
    public void generate() {
        generate(rootError, Optional.empty(), Optional.empty());
    }

    private void generate(
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
            generate(
                    subError,
                    Optional.of(errorClassFile),
                    Optional.of(exceptionClassFile)
            );
        }
    }
}
