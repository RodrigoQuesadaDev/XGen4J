package com.rodrigodev.xgen4j.model.common.file;

import com.google.common.io.Files;

import javax.inject.Singleton;
import java.io.File;
import java.io.Writer;

import static com.rodrigodev.xgen4j.common.exception.ExceptionUtils.unchecked;
import static com.rodrigodev.xgen4j.model.common.file.FileProperties.ENCODING;

/**
 * Created by Rodrigo Quesada on 26/06/15.
 */
@Singleton
public class FileService {

    public Writer newWriter(File file) {
        return unchecked(() -> Files.newWriter(file, ENCODING));
    }
}
