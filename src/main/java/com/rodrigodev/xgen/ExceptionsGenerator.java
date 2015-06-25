package com.rodrigodev.xgen;

import com.rodrigodev.xgen.configuration.ErrorDefinition;
import com.rodrigodev.xgen.writer.ErrorWriter;
import com.rodrigodev.xgen.writer.ExceptionWriter;
import com.rodrigodev.xgen.writer.file_definition.ErrorClassFile;
import com.rodrigodev.xgen.writer.file_definition.ExceptionClassFile;
import com.rodrigodev.xgen.writer.template.TemplateModule;
import dagger.Component;
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

    @Component(modules = TemplateModule.class)
    public interface ExceptionsGeneratorComponent {

        void inject(ExceptionsGenerator exceptionsGenerator);
    }

    private String sourceDirPath;

    @Inject ErrorWriter errorWriter;
    @Inject ExceptionWriter exceptionWriter;

    public ExceptionsGenerator(@NonNull String sourceDirPath) {
        checkArgument(Files.exists(Paths.get(sourceDirPath)), "Source directory doesn't exist.");

        DaggerExceptionsGenerator_ExceptionsGeneratorComponent.create().inject(this);
        this.sourceDirPath = sourceDirPath;
    }

    public void generate(@NonNull ErrorDefinition error) {
        generate(error, Optional.empty(), Optional.empty());
    }

    private void generate(
            ErrorDefinition error,
            Optional<ErrorClassFile> parentErrorClassFile,
            Optional<ExceptionClassFile> parentExceptionClassFile
    ) {
        ExceptionClassFile exceptionClassFile = exceptionWriter.write(sourceDirPath, error, parentExceptionClassFile);
        ErrorClassFile errorClassFile = errorWriter
                .write(sourceDirPath, error, exceptionClassFile, parentErrorClassFile);

        ErrorDefinition[] subErrors = error.errors();
        for (ErrorDefinition subError : subErrors) {
            generate(subError, Optional.of(errorClassFile), Optional.of(exceptionClassFile));
        }
    }
}
