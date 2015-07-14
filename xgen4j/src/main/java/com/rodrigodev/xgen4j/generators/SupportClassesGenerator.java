package com.rodrigodev.xgen.generators;

import com.rodrigodev.xgen.GenerationOptions;
import com.rodrigodev.xgen.model.error.ErrorClassFile;
import com.rodrigodev.xgen.model.support.optional.OptionalClassType;
import com.rodrigodev.xgen.model.support.optional.OptionalClassWriter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import javax.inject.Inject;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@FieldDefaults(makeFinal = true)
public class SupportClassesGenerator extends ClassesGenerator {

    public static class InjectedFields {
        @Inject OptionalClassWriter optionalClassWriter;

        @Inject
        public InjectedFields() {
        }
    }

    private InjectedFields inj;
    private ErrorClassFile rootErrorClassFile;
    private GenerationOptions options;

    protected SupportClassesGenerator(
            @NonNull InjectedFields injectedFields,
            String sourceDirPath,
            @NonNull ErrorClassFile rootErrorClassFile,
            @NonNull GenerationOptions options
    ) {
        super(sourceDirPath);
        this.inj = injectedFields;
        this.rootErrorClassFile = rootErrorClassFile;
        this.options = options;
    }

    @Override
    public void generate() {
        if (options.optionalClassType() == OptionalClassType.CUSTOM) {
            inj.optionalClassWriter.write(sourceDirPath, rootErrorClassFile);
        }
    }
}
