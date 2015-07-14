package com.rodrigodev.xgen.test.common.doubles.file;

import com.rodrigodev.xgen.model.common.file.FileService;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Quesada on 28/06/15.
 */
public class InMemoryFileService extends FileService {

    private List<StringBuffer> files;

    public InMemoryFileService() {
        reset();
    }

    public void reset() {
        this.files = new ArrayList<>();
    }

    public List<StringBuffer> files() {
        return files;
    }

    @Override
    public Writer newWriter(File file) {
        StringWriter output = new StringWriter();
        files.add(output.getBuffer());
        return output;
    }
}
