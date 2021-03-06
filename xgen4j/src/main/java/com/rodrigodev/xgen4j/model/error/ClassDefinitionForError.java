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

package com.rodrigodev.xgen4j.model.error;

import com.rodrigodev.xgen4j.model.common.clazz.ClassDefinition;
import com.rodrigodev.xgen4j.model.error.configuration.definition.ErrorDefinition;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

/**
 * Created by Rodrigo Quesada on 25/05/15.
 */
@Accessors(fluent = true)
@FieldDefaults(makeFinal = true)
public abstract class ClassDefinitionForError extends ClassDefinition {

    public static final String UNDERSCORE = "_";
    public static final String NON_WORD_CHAR_REGEX = "[^\\w]";

    @NonNull @Getter private ErrorDefinition errorDefinition;

    public ClassDefinitionForError(@NonNull ErrorDefinition errorDefinition, String nameSuffix) {
        super(generateName(errorDefinition, nameSuffix), errorDefinition.packagePath());
        this.errorDefinition = errorDefinition;
    }

    private static String generateName(ErrorDefinition errorDefinition, String nameSuffix) {
        return errorDefinition.name().replaceAll(NON_WORD_CHAR_REGEX, UNDERSCORE) + nameSuffix;
    }

    public boolean isConcrete() {
        return errorDefinition.description().isPresent();
    }
}
