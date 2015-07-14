package com.rodrigodev.xgen.model.common.clazz;

import com.rodrigodev.xgen.common.lang.PackageUtil;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.io.File;

/**
 * Created by Rodrigo Quesada on 26/05/15.
 */
@Accessors(fluent = true)
public abstract class ClassFile<D extends ClassDefinition> {

    public static final String FILE_EXTENSION = ".java";

    @NonNull private String baseDirectory;
    @NonNull private D classDefinition;
    @NonNull @Getter private String filePath;

    public ClassFile(@NonNull String baseDirectory, @NonNull D classDefinition) {
        this.baseDirectory = baseDirectory;
        this.classDefinition = classDefinition;
        init();
    }

    private void init() {
        filePath = generateFilePath();
    }

    private String generateFilePath() {
        return baseDirectory + File.separator
                + PackageUtil.toFilePath(classDefinition.fullyQualifiedName())
                + FILE_EXTENSION;
    }

    public D classDefinition() {
        return classDefinition;
    }
}
