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
import com.rodrigodev.xgen4j.generators.InformationClassesGenerator.InjectedFields;
import com.rodrigodev.xgen4j.model.common.clazz.ErrorExceptionClassFilePair;
import com.rodrigodev.xgen4j.model.error.ErrorClassFile;
import com.rodrigodev.xgen4j.model.error.code.ErrorCodeClassFile;
import com.rodrigodev.xgen4j.model.error.exception.ExceptionClassFile;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Singleton
public class InformationClassesGeneratorFactory {

    @Inject protected InjectedFields injectedFields;

    @Inject
    public InformationClassesGeneratorFactory() {
    }

    public InformationClassesGenerator create(
            String sourceDirPath,
            ErrorClassFile rootErrorClassFile,
            ExceptionClassFile rootExceptionClassFile,
            ErrorCodeClassFile errorCodeClassFile,
            List<ErrorExceptionClassFilePair> errorExceptionPairs,
            GenerationOptions options
    ) {
        return new InformationClassesGenerator(
                injectedFields,
                sourceDirPath,
                rootErrorClassFile,
                rootExceptionClassFile,
                errorCodeClassFile,
                errorExceptionPairs,
                options
        );
    }
}
