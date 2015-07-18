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

package com.rodrigodev.xgen4j;

import com.rodrigodev.xgen4j.generators.*;
import com.rodrigodev.xgen4j.model.error.configuration.definition.RootErrorDefinition;
import lombok.NonNull;

import javax.inject.Inject;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.google.common.base.Preconditions.*;

/**
 * Created by Rodrigo Quesada on 12/05/15.
 */
public class ExceptionsGenerator {

    public static class InjectedFields {

        @Inject BaseClassesGeneratorFactory baseClassesGeneratorFactory;
        @Inject ErrorClassesGeneratorFactory errorClassesGeneratorFactory;
        @Inject InformationClassesGeneratorFactory informationClassesGeneratorFactory;
        @Inject SupportClassesGeneratorFactory supportClassesGeneratorFactory;

        @Inject
        public InjectedFields() {
        }
    }

    @Inject InjectedFields inj;
    private final String sourceDirPath;

    ExceptionsGenerator(@NonNull InjectedFields injectedFields, @NonNull String sourceDirPath) {
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

    public void generate(@NonNull RootErrorDefinition rootError, @NonNull GenerationOptions options) {
        BaseClassesGenerator baseClassesGenerator = inj.baseClassesGeneratorFactory.create(sourceDirPath, rootError);
        baseClassesGenerator.generate();
        ErrorClassesGenerator errorClassesGenerator = inj.errorClassesGeneratorFactory.create(
                sourceDirPath, rootError, options
        );
        errorClassesGenerator.generate();
        inj.informationClassesGeneratorFactory.create(
                sourceDirPath,
                errorClassesGenerator.rootErrorClassFile(),
                errorClassesGenerator.rootExceptionClassFile(),
                baseClassesGenerator.errorCodeClassFile(),
                errorClassesGenerator.errorExceptionPairs(),
                options
        ).generate();
        inj.supportClassesGeneratorFactory.create(
                sourceDirPath, errorClassesGenerator.rootErrorClassFile(), options
        ).generate();
    }

    public void generate(@NonNull RootErrorDefinition rootError) {
        generate(rootError, GenerationOptions.builder().build());
    }
}
