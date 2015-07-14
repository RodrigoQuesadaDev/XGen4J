package com.rodrigodev.xgen4j.model.common.template;

import dagger.Module;
import dagger.Provides;
import freemarker.template.Configuration;

import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
@Module
public class TemplateModule {

    @Provides
    @Singleton
    Configuration provideConfiguration() {
        return TemplateConfig.configuration();
    }
}
