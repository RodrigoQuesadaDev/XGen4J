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

package com.rodrigodev.xgen4j.model.support.optional;

import lombok.NonNull;

import java.util.Optional;

import static com.google.common.base.Preconditions.*;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
public enum OptionalClassType {
    JAVA_8(Optional.class, "empty"),
    GUAVA(com.google.common.base.Optional.class, "absent"),
    CUSTOM("Optional", "empty");

    private static final String DOT = ".";

    private Optional<Class<?>> type;
    private Optional<String> typeName;
    private String emptyMethodName;

    OptionalClassType(
            @NonNull Optional<Class<?>> type,
            @NonNull Optional<String> typeName,
            @NonNull String emptyMethodName
    ) {
        this.type = type;
        this.typeName = typeName;
        this.emptyMethodName = emptyMethodName;
    }

    OptionalClassType(Class<?> type, String emptyMethodName) {
        this(Optional.of(type), Optional.empty(), emptyMethodName);
    }

    OptionalClassType(String typeName, String emptyMethodName) {
        this(Optional.empty(), Optional.of(typeName), emptyMethodName);
    }

    public Optional<Class<?>> type() {
        return type;
    }

    public String typeName() {
        checkState(typeName.isPresent(), "typeName is not present");

        return typeName.get();
    }

    public String customCanonicalName(String packagePath) {
        return packagePath + DOT + typeName();
    }

    public String emptyMethodName() {
        return emptyMethodName;
    }
}
