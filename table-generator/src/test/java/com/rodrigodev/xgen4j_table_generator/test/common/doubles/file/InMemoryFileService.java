package com.rodrigodev.xgen4j_table_generator.test.common.doubles.file;

import com.rodrigodev.xgen4j_table_generator.service.file.FileService;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Quesada on 28/06/15.
 */
public class InMemoryFileService extends FileService {

    private List<ByteArrayOutputStream> files;

    public InMemoryFileService() {
        reset();
    }

    public void reset() {
        this.files = new ArrayList<>();
    }

    public List<ByteArrayOutputStream> files() {
        return files;
    }

    @Override
    public OutputStream openFile(File file) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        files.add(output);
        return output;
    }
}
