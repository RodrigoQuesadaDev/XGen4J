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

package com.rodrigodev.xgen4j.model.common.template.model;

import com.rodrigodev.xgen4j.model.error.ErrorClassFile;
import com.rodrigodev.xgen4j.model.support.optional.OptionalClassType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Getter
@FieldDefaults(makeFinal = true)
@ToString
public class OptionalTypeTemplateModel extends TypeTemplateModel {

    private String emptyMethod;

    private OptionalTypeTemplateModel(OptionalClassType optionalClassType, String name, String canonicalName) {
        super(name, canonicalName);
        this.emptyMethod = optionalClassType.emptyMethodName();
    }

    private OptionalTypeTemplateModel(OptionalClassType optionalClassType) {
        super(optionalClassType.type().get());
        this.emptyMethod = optionalClassType.emptyMethodName();
    }

    public static OptionalTypeTemplateModelBuilder builder() {
        return new OptionalTypeTemplateModelBuilder();
    }

    @Setter
    @Accessors(fluent = true)
    public static class OptionalTypeTemplateModelBuilder {

        private ErrorClassFile rootErrorClassFile;
        private OptionalClassType optionalClassType;

        public OptionalTypeTemplateModel build() {

            OptionalTypeTemplateModel model;

            Optional<Class<?>> type = optionalClassType.type();
            if (type.isPresent()) {
                model = new OptionalTypeTemplateModel(optionalClassType);
            }
            else {
                model = new OptionalTypeTemplateModel(
                        optionalClassType,
                        optionalClassType.typeName(),
                        optionalClassType.customCanonicalName(rootErrorClassFile.classDefinition().packagePath())
                );
            }

            return model;
        }
    }
}
