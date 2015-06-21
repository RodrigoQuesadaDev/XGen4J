package com.rodrigodev.xgen.writer.file_definition;

import com.rodrigodev.common.lang.PackageUtil;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.io.File;

/**
 * Created by Rodrigo Quesada on 25/05/15.
 */
@Accessors(fluent = true)
public class ErrorClassFile implements ClassFile {

    public static final String FILE_EXTENSION = ".java";

    @NonNull private String baseDirectory;
    @NonNull private ErrorClassDefinition errorClass;
    @NonNull @Getter private String filePath;

    public ErrorClassFile(@NonNull String baseDirectory, @NonNull ErrorClassDefinition errorClass) {
        this.baseDirectory = baseDirectory;
        this.errorClass = errorClass;
        init();
    }

    private void init() {
        filePath = generateFilePath();
    }

    private String generateFilePath() {
        return baseDirectory + File.separator + PackageUtil.toFilePath(errorClass.fullQualifiedName()) + FILE_EXTENSION;
    }
}
