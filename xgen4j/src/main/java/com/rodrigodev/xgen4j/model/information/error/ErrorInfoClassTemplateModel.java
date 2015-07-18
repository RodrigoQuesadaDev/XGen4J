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

package com.rodrigodev.xgen4j.model.information.error;

import com.rodrigodev.xgen4j.model.common.template.model.ClassTemplateModel;
import com.rodrigodev.xgen4j.model.common.template.model.OptionalTypeTemplateModel;
import com.rodrigodev.xgen4j.model.common.template.model.TypeTemplateModel;
import com.rodrigodev.xgen4j.model.error.ErrorClassFile;
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
public class ErrorInfoClassTemplateModel extends ClassTemplateModel {

    @NonNull private TypeTemplateModel rootError;
    @NonNull private OptionalTypeTemplateModel optionalType;

    private ErrorInfoClassTemplateModel(
            ErrorInfoClassTemplateModelBuilder builder,
            @NonNull ErrorInfoClassFile errorInfoClassFile,
            @NonNull ErrorClassFile rootErrorClassFile
    ) {
        super(builder);
        this.rootError = new TypeTemplateModel(rootErrorClassFile.classDefinition());
        this.optionalType = OptionalTypeTemplateModel.builder()
                .rootErrorClassFile(rootErrorClassFile)
                .optionalClassType(errorInfoClassFile.classDefinition().optionalClassType())
                .build();
    }

    protected ErrorInfoClassTemplateModel(ErrorInfoClassTemplateModelBuilder builder) {
        this(builder, builder.errorInfoClassFile, builder.rootErrorClassFile);
    }

    public static ErrorInfoClassTemplateModelBuilder builder() {
        return new ErrorInfoClassTemplateModelBuilder();
    }

    @Setter
    @Accessors(fluent = true)
    public static class ErrorInfoClassTemplateModelBuilder extends ClassTemplateModelBuilder<ErrorInfoClassTemplateModel, ErrorInfoClassTemplateModelBuilder> {

        private ErrorInfoClassFile errorInfoClassFile;
        private ErrorClassFile rootErrorClassFile;

        @Override
        public ErrorInfoClassTemplateModel build() {
            return new ErrorInfoClassTemplateModel(this);
        }
    }
}

