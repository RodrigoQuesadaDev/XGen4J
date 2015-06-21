package com.rodrigodev.xgen.writer.template;

import dagger.Module;
import dagger.Provides;
import freemarker.template.Configuration;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
@Module
public class TemplateModule {

    @Provides
    Configuration providesConfiguration() {
        return TemplateConfig.configuration();
    }
}
