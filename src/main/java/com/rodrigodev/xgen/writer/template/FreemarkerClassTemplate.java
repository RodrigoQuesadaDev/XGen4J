package com.rodrigodev.xgen.writer.template;

import com.rodrigodev.xgen.writer.file_definition.ClassDefinition;
import com.rodrigodev.xgen.writer.file_definition.ClassFile;
import com.rodrigodev.xgen.writer.template.ClassTemplateModel.ClassTemplateModelBuilder;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.Getter;
import lombok.experimental.Accessors;

import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
@Accessors(fluent = true)
public abstract class FreemarkerClassTemplate<M extends ClassTemplateModel, MB extends ClassTemplateModelBuilder<M, MB>, D extends ClassDefinition> {

    public static class InjectedFields {

        @Inject Configuration configuration;

        @Inject
        public InjectedFields() {
        }
    }

    private InjectedFields inj;
    @Getter private Template template;
    @Getter private ClassFile<D> classFile;
    protected MB modelBuilder;

    protected FreemarkerClassTemplate(
            InjectedFields injectedFields, String templateFileName, MB modelBuilder, ClassFile classFile
    ) {
        try {
            inj = injectedFields;
            template = inj.configuration.getTemplate(templateFileName);
            this.classFile = classFile;
            this.modelBuilder = modelBuilder;
            initModel();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    final protected void initModel() {
        modelBuilder.name(classFile.classDefinition().name());
        modelBuilder.packagePath(classFile.classDefinition().packagePath());
        doInitModel(classFile);
    }

    protected abstract void doInitModel(ClassFile<D> classFile);

    public M model() {
        return modelBuilder.build();
    }
}
