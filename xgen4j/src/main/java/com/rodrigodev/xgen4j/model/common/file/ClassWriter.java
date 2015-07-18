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

package com.rodrigodev.xgen4j.model.common.file;

import com.rodrigodev.xgen4j.model.common.clazz.ClassFile;
import com.rodrigodev.xgen4j.model.common.template.FreemarkerClassTemplate;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.File;
import java.io.Writer;

/**
 * Created by Rodrigo Quesada on 26/05/15.
 */
@Singleton
public class ClassWriter {

    @Inject FileService fileService;

    @Inject
    public ClassWriter() {
    }

    public void write(FreemarkerClassTemplate<?, ?> classTemplate) {
        ClassFile classFile = classTemplate.classFile();
        try (Writer errorClassWriter = fileService.newWriter(createPackagePath(classFile))) {
            classTemplate.template().process(classTemplate.model(), errorClassWriter);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private File createPackagePath(ClassFile classFile) {
        File file = new File(classFile.filePath());
        File parentDir = file.getParentFile();
        if (parentDir != null) {
            parentDir.mkdirs();
        }
        return file;
    }
}
