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

package com.rodrigodev.xgen4j.model.error.code;

import com.rodrigodev.xgen4j.model.common.template.model.ClassTemplateModel;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 25/06/15.
 */
@Value
@EqualsAndHashCode(callSuper = true)
public class ErrorCodeClassTemplateModel extends ClassTemplateModel {

    private boolean hasNumber;

    private ErrorCodeClassTemplateModel(
            ErrorCodeClassTemplateModelBuilder builder,
            @NonNull ErrorCodeClassFile errorCodeClassFile
    ) {
        super(builder);
        this.hasNumber = errorCodeClassFile.classDefinition().hasNumber();
    }

    protected ErrorCodeClassTemplateModel(ErrorCodeClassTemplateModelBuilder builder) {
        this(builder, builder.errorCodeClassFile);
    }

    public static ErrorCodeClassTemplateModelBuilder builder() {
        return new ErrorCodeClassTemplateModelBuilder();
    }

    @Setter
    @Accessors(fluent = true)
    public static class ErrorCodeClassTemplateModelBuilder extends ClassTemplateModelBuilder<ErrorCodeClassTemplateModel, ErrorCodeClassTemplateModelBuilder> {

        private ErrorCodeClassFile errorCodeClassFile;

        @Override
        public ErrorCodeClassTemplateModel build() {
            return new ErrorCodeClassTemplateModel(this);
        }
    }
}
