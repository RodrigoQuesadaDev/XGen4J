package com.rodrigodev.xgen.model.common.file;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 26/06/15.
 */
@Module
public class FileModule {

    @Provides
    @Singleton
    public FileService provideFileService() {
        return new FileService();
    }
}
