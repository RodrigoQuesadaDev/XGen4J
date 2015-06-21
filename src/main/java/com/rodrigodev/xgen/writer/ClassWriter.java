package com.rodrigodev.xgen.writer;

import com.google.common.io.Files;
import com.rodrigodev.xgen.writer.file_definition.ClassFile;
import freemarker.template.Template;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Created by Rodrigo Quesada on 26/05/15.
 */
public class ClassWriter {

    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    private Template template;

    public ClassWriter(Template template) {
        this.template = template;
    }

    public void write(ClassFile classFile) {
        try (BufferedWriter errorClassWriter = Files.newWriter(
                new File(classFile.filePath()), DEFAULT_CHARSET
        )) {
            template.process(null, errorClassWriter);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
