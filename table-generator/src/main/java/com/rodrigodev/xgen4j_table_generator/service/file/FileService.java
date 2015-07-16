package com.rodrigodev.xgen4j_table_generator.service.file;

import javax.inject.Singleton;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import static com.rodrigodev.xgen4j.common.exception.ExceptionUtils.unchecked;

/**
 * Created by Rodrigo Quesada on 26/06/15.
 */
@Singleton
public class FileService {

    public OutputStream openFile(File file) {
        return unchecked(() -> new FileOutputStream(file));
    }
}
