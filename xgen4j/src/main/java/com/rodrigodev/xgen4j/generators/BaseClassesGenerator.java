package com.rodrigodev.xgen4j.generators;

import com.rodrigodev.xgen4j.model.error.code.ErrorCodeClassFile;
import com.rodrigodev.xgen4j.model.error.code.ErrorCodeClassWriter;
import com.rodrigodev.xgen4j.model.error.configuration.definition.RootErrorDefinition;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@FieldDefaults(makeFinal = true)
public class BaseClassesGenerator extends ClassesGenerator {

    public static class InjectedFields {
        @Inject ErrorCodeClassWriter errorCodeClassWriter;

        @Inject
        public InjectedFields() {
        }
    }

    private InjectedFields inj;
    @NonFinal private Optional<ErrorCodeClassFile> errorCodeClassFile;
    private RootErrorDefinition rootError;

    protected BaseClassesGenerator(
            @NonNull InjectedFields injectedFields, String sourceDirPath, @NonNull RootErrorDefinition rootError
    ) {
        super(sourceDirPath);
        this.inj = injectedFields;
        this.errorCodeClassFile = Optional.empty();
        this.rootError = rootError;
    }

    public ErrorCodeClassFile errorCodeClassFile() {
        return errorCodeClassFile.get();
    }

    @Override
    public void generate() {
        generateErrorCodeClass();
    }

    private void generateErrorCodeClass() {
        errorCodeClassFile = Optional.of(inj.errorCodeClassWriter.write(
                sourceDirPath, rootError, rootError.code().number().isPresent()
        ));
    }
}
