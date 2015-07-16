package com.rodrigodev.xgen4j.model.common.template;

import com.rodrigodev.xgen4j.ExceptionsGenerator;
import com.rodrigodev.xgen4j.model.common.file.FileProperties;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

import static com.rodrigodev.xgen4j.common.exception.ExceptionUtils.unchecked;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
public class TemplateConfig {

    private static final Version VERSION = Configuration.VERSION_2_3_22;

    public static Configuration configuration() {
        return unchecked(
                () -> {
                    Configuration configuration = new Configuration(VERSION);
                    configuration.setClassForTemplateLoading(ExceptionsGenerator.class, "templates");
                    configuration.setDefaultEncoding(FileProperties.ENCODING.name());
                    configuration.setTemplateExceptionHandler(
                            TemplateExceptionHandler.RETHROW_HANDLER);
                    return configuration;
                }
        );
    }
}
