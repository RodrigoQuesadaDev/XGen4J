package com.rodrigodev.xgen.generators;

import com.rodrigodev.xgen.model.error.code.ErrorCodeClassWriter;
import com.rodrigodev.xgen.model.error.configuration.definition.RootErrorDefinition;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import javax.inject.Inject;

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
    private RootErrorDefinition rootError;

    protected BaseClassesGenerator(
            @NonNull InjectedFields injectedFields, String sourceDirPath, @NonNull RootErrorDefinition rootError
    ) {
        super(sourceDirPath);
        this.inj = injectedFields;
        this.rootError = rootError;
    }

    @Override
    public void generate() {
        generateErrorCodeClass();
    }

    private void generateErrorCodeClass() {
        inj.errorCodeClassWriter.write(sourceDirPath, rootError, rootError.code().number().isPresent());
    }
}
