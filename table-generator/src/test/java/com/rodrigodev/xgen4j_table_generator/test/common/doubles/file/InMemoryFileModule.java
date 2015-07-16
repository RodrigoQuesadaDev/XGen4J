package com.rodrigodev.xgen4j_table_generator.test.common.doubles.file;

import com.rodrigodev.xgen4j_table_generator.service.file.FileModule;
import com.rodrigodev.xgen4j_table_generator.service.file.FileService;

/**
 * Created by Rodrigo Quesada on 27/06/15.
 */
public class InMemoryFileModule extends FileModule {

    @Override
    public FileService provideFileService() {
        return new InMemoryFileService();
    }
}