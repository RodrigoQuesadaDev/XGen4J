package com.rodrigodev.xgen.model.common.file;

import com.rodrigodev.xgen.model.common.clazz.ClassFile;
import com.rodrigodev.xgen.model.common.template.FreemarkerClassTemplate;

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
