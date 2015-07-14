package com.rodrigodev.xgen4j;

import com.rodrigodev.xgen4j.ExceptionsGenerator.InjectedFields;
import com.rodrigodev.xgen4j.model.common.file.FileModule;
import com.rodrigodev.xgen4j.model.common.template.TemplateModule;
import com.rodrigodev.xgen4j.service.ServiceModule;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Rodrigo Quesada on 27/06/15.
 */
@Module(includes = {TemplateModule.class, FileModule.class, ServiceModule.class})
public class MainModule {

    private String sourceDirPath;

    public MainModule(String sourceDirPath) {
        this.sourceDirPath = sourceDirPath;
    }

    @Provides
    public ExceptionsGenerator provideExceptionsGenerator(InjectedFields injectedFields) {
        return new ExceptionsGenerator(injectedFields, sourceDirPath);
    }
}
