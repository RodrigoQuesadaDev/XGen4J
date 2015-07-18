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

package com.rodrigodev.xgen4j.model.common.template;

import com.rodrigodev.xgen4j.model.common.clazz.ClassDefinition;
import com.rodrigodev.xgen4j.model.common.clazz.ClassFile;
import com.rodrigodev.xgen4j.model.common.template.model.ClassTemplateModel;
import com.rodrigodev.xgen4j.model.common.template.model.ClassTemplateModel.ClassTemplateModelBuilder;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
@Accessors(fluent = true)
public abstract class FreemarkerClassTemplate<M extends ClassTemplateModel, D extends ClassDefinition> {

    public static class InjectedFields {

        @Inject Configuration configuration;
        @Inject ClassTemplateModel.InjectedFields modelInjectedFields;

        @Inject
        public InjectedFields() {
        }
    }

    @NonNull private InjectedFields inj;
    @NonNull @Getter private Template template;
    @NonNull @Getter private ClassFile<D> classFile;
    @NonNull private Optional<? extends ClassFile<?>> parentClassFile;
    @NonNull @Getter protected M model;

    protected FreemarkerClassTemplate(
            @NonNull InjectedFields injectedFields,
            @NonNull String templateFileName,
            @NonNull ClassTemplateModelBuilder<M, ?> modelBuilder,
            @NonNull ClassFile<D> classFile,
            @NonNull Optional<? extends ClassFile<?>> parentClassFile
    ) {
        try {
            inj = injectedFields;
            template = inj.configuration.getTemplate(templateFileName);
            this.classFile = classFile;
            this.parentClassFile = parentClassFile;
            initModel(modelBuilder);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initModel(ClassTemplateModelBuilder<M, ?> modelBuilder) {
        modelBuilder.injectedFields(inj.modelInjectedFields);
        modelBuilder.name(classFile.classDefinition().name());
        modelBuilder.packagePath(classFile.classDefinition().packagePath());
        parentClassFile.ifPresent(p -> modelBuilder.parent(p.classDefinition()));
        this.model = modelBuilder.build();
    }
}
