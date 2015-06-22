package com.rodrigodev.xgen.writer;

import com.google.common.io.Files;
import com.rodrigodev.xgen.writer.file_definition.ClassFile;
import com.rodrigodev.xgen.writer.template.FreemarkerClassTemplate;

import javax.inject.Inject;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Created by Rodrigo Quesada on 26/05/15.
 */
public class ClassWriter {

    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    @Inject
    public ClassWriter() {
    }

    public void write(FreemarkerClassTemplate<?, ?, ?> classTemplate) {
        ClassFile classFile = classTemplate.classFile();
        try (BufferedWriter errorClassWriter = Files.newWriter(
                new File(classFile.filePath()), DEFAULT_CHARSET
        )) {
            classTemplate.template().process(classTemplate.model(), errorClassWriter);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
