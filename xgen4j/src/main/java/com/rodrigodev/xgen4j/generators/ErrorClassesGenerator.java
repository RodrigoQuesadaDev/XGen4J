/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Rodrigo Quesada <rodrigoquesada.dev@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.rodrigodev.xgen4j.generators;

import com.rodrigodev.xgen4j.GenerationOptions;
import com.rodrigodev.xgen4j.model.common.clazz.ErrorExceptionClassFilePair;
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
    @Getter private List<ErrorExceptionClassFilePair> errorExceptionPairs;
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

        errorExceptionPairs.add(new ErrorExceptionClassFilePair(errorClassFile, exceptionClassFile));

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
