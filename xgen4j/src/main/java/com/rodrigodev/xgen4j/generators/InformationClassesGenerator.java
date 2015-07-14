package com.rodrigodev.xgen.generators;

import com.google.common.collect.ImmutableList;
import com.rodrigodev.xgen.GenerationOptions;
import com.rodrigodev.xgen.model.common.clazz.ErrorExceptionClassDefinitionPair;
import com.rodrigodev.xgen.model.error.ErrorClassFile;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassFile;
import com.rodrigodev.xgen.model.information.InformationClassesWriter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import javax.inject.Inject;
import java.util.List;

import static com.google.common.base.Preconditions.*;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@FieldDefaults(makeFinal = true)
public class InformationClassesGenerator extends ClassesGenerator {

    public static class InjectedFields {
        @Inject InformationClassesWriter informationClassesWriter;

        @Inject
        public InjectedFields() {
        }
    }

    private InjectedFields inj;
    private ErrorClassFile rootErrorClassFile;
    private ExceptionClassFile rootExceptionClassFile;
    private List<ErrorExceptionClassDefinitionPair> errorExceptionPairs;
    private GenerationOptions options;

    protected InformationClassesGenerator(
            @NonNull InjectedFields injectedFields,
            String sourceDirPath,
            @NonNull ErrorClassFile rootErrorClassFile,
            @NonNull ExceptionClassFile rootExceptionClassFile,
            @NonNull List<ErrorExceptionClassDefinitionPair> errorExceptionPairs,
            @NonNull GenerationOptions options
    ) {
        super(sourceDirPath);
        this.inj = injectedFields;
        this.rootErrorClassFile = rootErrorClassFile;
        this.rootExceptionClassFile = rootExceptionClassFile;
        this.errorExceptionPairs = errorExceptionPairs;
        this.options = options;
    }

    @Override
    public void generate() {
        checkState(!errorExceptionPairs.isEmpty(), "errorExceptionPairs is empty");

        inj.informationClassesWriter.write(
                sourceDirPath,
                rootErrorClassFile,
                rootExceptionClassFile,
                ImmutableList.copyOf(errorExceptionPairs),
                options
        );
    }
}
