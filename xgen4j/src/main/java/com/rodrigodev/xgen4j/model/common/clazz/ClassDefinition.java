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

package com.rodrigodev.xgen4j.model.common.clazz;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

import static com.google.common.base.Preconditions.*;
import static java.lang.Character.isJavaIdentifierStart;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
@Accessors(fluent = true)
public abstract class ClassDefinition {

    public static final String DOT = ".";

    @NonNull @Getter private String name;
    @NonNull @Getter private String packagePath;

    public ClassDefinition(@NonNull String name, @NonNull String packagePath) {
        checkArgument(!name.isEmpty(), "name is empty");
        checkArgument(
                isJavaIdentifierStart(name.codePointAt(0))
                        && name.codePoints().allMatch(Character::isJavaIdentifierPart),
                "Class name contains invalid characters."
        );

        this.name = name;
        this.packagePath = packagePath;
    }

    public String fullyQualifiedName() {
        return packagePath + DOT + name;
    }
}
