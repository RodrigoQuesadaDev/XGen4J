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

package com.rodrigodev.xgen4j.model.information.exception.template;

import com.rodrigodev.xgen4j.model.common.template.model.ClassTemplateModel;
import com.rodrigodev.xgen4j.model.common.template.model.OptionalTypeTemplateModel;
import com.rodrigodev.xgen4j.model.error.ErrorClassFile;
import com.rodrigodev.xgen4j.model.error.exception.ExceptionClassFile;
import com.rodrigodev.xgen4j.model.information.exception.ExceptionInfoClassFile;
import com.rodrigodev.xgen4j.model.information.exception.template.model.RootErrorTemplateModel;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
@Value
@EqualsAndHashCode(callSuper = true)
public class ExceptionInfoClassTemplateModel extends ClassTemplateModel {

    @NonNull private RootErrorTemplateModel rootError;
    @NonNull private OptionalTypeTemplateModel optionalType;

    private ExceptionInfoClassTemplateModel(
            ExceptionInfoClassTemplateModelBuilder builder,
            @NonNull ExceptionInfoClassFile exceptionInfoClassFile,
            @NonNull ErrorClassFile rootErrorClassFile,
            @NonNull ExceptionClassFile rootExceptionClassFile
    ) {
        super(builder);
        this.rootError = new RootErrorTemplateModel(
                rootErrorClassFile.classDefinition(),
                rootExceptionClassFile.classDefinition()
        );
        this.optionalType = OptionalTypeTemplateModel.builder()
                .rootErrorClassFile(rootErrorClassFile)
                .optionalClassType(exceptionInfoClassFile.classDefinition().optionalClassType())
                .build();
    }

    protected ExceptionInfoClassTemplateModel(ExceptionInfoClassTemplateModelBuilder builder) {
        this(builder, builder.exceptionInfoClassFile, builder.rootErrorClassFile, builder.rootExceptionClassFile);
    }

    public static ExceptionInfoClassTemplateModelBuilder builder() {
        return new ExceptionInfoClassTemplateModelBuilder();
    }

    @Setter
    @Accessors(fluent = true)
    public static class ExceptionInfoClassTemplateModelBuilder extends ClassTemplateModelBuilder<ExceptionInfoClassTemplateModel, ExceptionInfoClassTemplateModelBuilder> {

        private ExceptionInfoClassFile exceptionInfoClassFile;
        private ErrorClassFile rootErrorClassFile;
        private ExceptionClassFile rootExceptionClassFile;

        @Override
        public ExceptionInfoClassTemplateModel build() {
            return new ExceptionInfoClassTemplateModel(this);
        }
    }
}
