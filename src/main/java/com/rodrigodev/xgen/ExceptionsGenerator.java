package com.rodrigodev.xgen;

import com.rodrigodev.xgen.model.error.configuration.ErrorDefinition;
import com.rodrigodev.xgen.model.error.code.ErrorCodeWriter;
import com.rodrigodev.xgen.model.error.ErrorWriter;
import com.rodrigodev.xgen.model.error.exception.ExceptionWriter;
import com.rodrigodev.xgen.model.error.ErrorClassFile;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassFile;
import lombok.NonNull;

import javax.inject.Inject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import static com.google.common.base.Preconditions.*;

/**
 * Created by Rodrigo Quesada on 12/05/15.
 */
public class ExceptionsGenerator {

    public static class InjectedFields {

        @Inject ErrorCodeWriter errorCodeWriter;
        @Inject ErrorWriter errorWriter;
        @Inject ExceptionWriter exceptionWriter;

        @Inject
        public InjectedFields() {
        }
    }

    @Inject InjectedFields inj;
    private String sourceDirPath;

    ExceptionsGenerator(
            InjectedFields injectedFields,
            String sourceDirPath
    ) {
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

    public void generate(@NonNull ErrorDefinition rootError) {
        generateBaseClasses(rootError);
        generateErrors(rootError.packagePath(), rootError, Optional.empty(), Optional.empty());
    }

    private void generateBaseClasses(ErrorDefinition rootError) {
        generateErrorCodeClass(rootError);
    }

    private void generateErrorCodeClass(ErrorDefinition rootError) {
        inj.errorCodeWriter.write(sourceDirPath, rootError);
    }

    private void generateErrors(
            String rootPackage,
            ErrorDefinition error,
            Optional<ErrorClassFile> parentErrorClassFile,
            Optional<ExceptionClassFile> parentExceptionClassFile
    ) {
        ExceptionClassFile exceptionClassFile = inj.exceptionWriter.write(sourceDirPath, error, parentExceptionClassFile);
        ErrorClassFile errorClassFile = inj.errorWriter
                .write(sourceDirPath, rootPackage, error, exceptionClassFile, parentErrorClassFile);

        ErrorDefinition[] subErrors = error.errors();
        for (ErrorDefinition subError : subErrors) {
            generateErrors(rootPackage, subError, Optional.of(errorClassFile), Optional.of(exceptionClassFile));
        }
    }
}
