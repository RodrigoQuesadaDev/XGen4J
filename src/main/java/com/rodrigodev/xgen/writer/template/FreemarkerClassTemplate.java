package com.rodrigodev.xgen.writer.template;

import com.rodrigodev.xgen.writer.file_definition.ClassFile;
import com.rodrigodev.xgen.writer.template.ClassTemplateModel.ClassTemplateModelBuilder;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

import java.io.File;
import java.io.IOException;

import static com.rodrigodev.common.exception.ExceptionUtils.unchecked;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
public abstract class FreemarkerClassTemplate<M extends ClassTemplateModel, MB extends ClassTemplateModelBuilder> {

    private static final Version VERSION = Configuration.VERSION_2_3_22;
    private static final String TEMPLATES_BASE_DIR = "src/main/resources/templates";
    private static final String ENCODING = "UTF-8";

    private Template template;
    protected MB modelBuilder;

    protected FreemarkerClassTemplate(String templateFileName, MB modelBuilder, ClassFile classFile) {
        try {
            template = configuration().getTemplate(templateFileName);
            this.modelBuilder = modelBuilder;
            initModel(classFile);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected Configuration configuration() {
        return unchecked(
                () -> {
                    Configuration configuration = new Configuration(VERSION);
                    configuration.setDirectoryForTemplateLoading(new File(TEMPLATES_BASE_DIR));
                    configuration.setDefaultEncoding(ENCODING);
                    configuration.setTemplateExceptionHandler(
                            TemplateExceptionHandler.RETHROW_HANDLER);
                    return configuration;
                }
        );
    }

    final protected void initModel(ClassFile classFile) {
        modelBuilder.name(classFile.classDefinition().name());
        doInitModel(classFile);
    }

    protected abstract void doInitModel();

    public Template template() {
        return template;
    }

    public abstract M model();
}
