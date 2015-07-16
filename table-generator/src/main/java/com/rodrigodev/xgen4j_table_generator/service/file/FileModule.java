package com.rodrigodev.xgen4j_table_generator.service.file;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 15/07/15.
 */
@Module
public class FileModule {

    @Provides
    @Singleton
    public FileService provideFileService() {
        return new FileService();
    }
}
