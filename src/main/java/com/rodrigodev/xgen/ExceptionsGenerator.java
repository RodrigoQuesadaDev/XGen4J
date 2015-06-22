package com.rodrigodev.xgen;

import com.rodrigodev.xgen.configuration.ErrorDefinition;
import com.rodrigodev.xgen.writer.ErrorWriter;
import com.rodrigodev.xgen.writer.ExceptionWriter;
import com.rodrigodev.xgen.writer.file_definition.ExceptionClassFile;
import com.rodrigodev.xgen.writer.template.TemplateModule;
import dagger.Component;
import lombok.NonNull;

import javax.inject.Inject;

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
        DaggerExceptionsGenerator_ExceptionsGeneratorComponent.create().inject(this);
        this.sourceDirPath = sourceDirPath;
    }

    public void generate(@NonNull ErrorDefinition error) {

        ExceptionClassFile exceptionClassFile = exceptionWriter.write(sourceDirPath, error);
        errorWriter.write(sourceDirPath, error, exceptionClassFile);

        ErrorDefinition[] subErrors = error.errors();
        for (ErrorDefinition subError : subErrors) {
            generate(subError);
        }
    }
}
