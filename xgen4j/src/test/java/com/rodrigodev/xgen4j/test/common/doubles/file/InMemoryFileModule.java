package com.rodrigodev.xgen4j.test.common.doubles.file;

import com.rodrigodev.xgen4j.model.common.file.FileModule;
import com.rodrigodev.xgen4j.model.common.file.FileService;

/**
 * Created by Rodrigo Quesada on 27/06/15.
 */
public class InMemoryFileModule extends FileModule {

    @Override
    public FileService provideFileService() {
        return new InMemoryFileService();
    }
}