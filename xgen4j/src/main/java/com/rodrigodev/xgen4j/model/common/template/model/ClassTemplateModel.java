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

import com.rodrigodev.xgen4j.model.common.clazz.ClassDefinition;
import com.rodrigodev.xgen4j.service.time.TimeService;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.inject.Inject;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
@Getter
public class ClassTemplateModel {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);

    public static class InjectedFields {

        @Inject TimeService timeService;

        @Inject
        public InjectedFields() {
        }
    }

    @NonNull private InjectedFields inj;
    @NonNull final private String name;
    @NonNull final private String packagePath;
    final private TypeTemplateModel parent;
    private String currentDate;

    private ClassTemplateModel(
            @NonNull InjectedFields injectedFields,
            @NonNull String name,
            @NonNull String packagePath,
            ClassDefinition parentClassDefinition
    ) {
        this.inj = injectedFields;
        this.name = name;
        this.packagePath = packagePath;
        this.parent = parentClassDefinition != null
                ? new TypeTemplateModel(parentClassDefinition.name(), parentClassDefinition.fullyQualifiedName())
                : null;
        this.currentDate = DATE_TIME_FORMATTER.format(inj.timeService.now());
    }

    protected ClassTemplateModel(@NonNull ClassTemplateModelBuilder builder) {
        this(builder.injectedFields, builder.name, builder.packagePath, builder.parent);
    }

    @Setter
    @Accessors(fluent = true)
    public static abstract class ClassTemplateModelBuilder<M extends ClassTemplateModel, B extends ClassTemplateModelBuilder<M, B>> {

        private InjectedFields injectedFields;
        private String name;
        private String packagePath;
        private ClassDefinition parent;

        public abstract M build();
    }
}
