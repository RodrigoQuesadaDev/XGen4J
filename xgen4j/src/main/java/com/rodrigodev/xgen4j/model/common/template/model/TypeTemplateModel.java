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
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 24/06/15.
 */
@Value
@NonFinal
public class TypeTemplateModel {

    private String packagePath;
    private String name;
    private String canonicalName;

    private TypeTemplateModel(
            @NonNull Optional<String> packagePath, @NonNull String name, @NonNull String canonicalName
    ) {
        this.packagePath = packagePath.orElse(null);
        this.name = name;
        this.canonicalName = canonicalName;
    }

    public TypeTemplateModel(@NonNull TypeTemplateModel another) {
        this(Optional.ofNullable(another.packagePath), another.name, another.canonicalName);
    }

    public TypeTemplateModel(String packagePath, String name, String canonicalName) {
        this(Optional.of(packagePath), name, canonicalName);
    }

    public TypeTemplateModel(String name, String canonicalName) {
        this(Optional.empty(), name, canonicalName);
    }

    public TypeTemplateModel(Class<?> type) {
        this(type.getPackage().getName(), type.getSimpleName(), type.getCanonicalName());
    }

    public TypeTemplateModel(ClassDefinition classDefinition) {
        this(classDefinition.packagePath(), classDefinition.name(), classDefinition.fullyQualifiedName());
    }

    @Override
    final public int hashCode() {
        return canonicalName.hashCode();
    }

    @Override
    final public boolean equals(Object o) {
        return o instanceof TypeTemplateModel && canonicalName.equals(((TypeTemplateModel) o).canonicalName);
    }
}
