package com.rodrigodev.xgen.model.common.template;

import com.rodrigodev.xgen.model.common.file.FileProperties;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

import java.io.File;

import static com.rodrigodev.xgen.common.exception.ExceptionUtils.unchecked;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
public class TemplateConfig {

    private static final Version VERSION = Configuration.VERSION_2_3_22;
    private static final String TEMPLATES_BASE_DIR = "src/main/resources/templates";

    public static Configuration configuration() {
        return unchecked(
                () -> {
                    Configuration configuration = new Configuration(VERSION);
                    configuration.setDirectoryForTemplateLoading(new File(TEMPLATES_BASE_DIR));
                    configuration.setDefaultEncoding(FileProperties.ENCODING.name());
                    configuration.setTemplateExceptionHandler(
                            TemplateExceptionHandler.RETHROW_HANDLER);
                    return configuration;
                }
        );
    }
}
