package com.rodrigodev.xgen.model.common.template;

import com.rodrigodev.xgen.model.common.clazz.ClassDefinition;
import com.rodrigodev.xgen.model.common.clazz.ClassFile;
import com.rodrigodev.xgen.model.common.template.model.ClassTemplateModel;
import com.rodrigodev.xgen.model.common.template.model.ClassTemplateModel.ClassTemplateModelBuilder;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
@Accessors(fluent = true)
public abstract class FreemarkerClassTemplate<M extends ClassTemplateModel, MB extends ClassTemplateModelBuilder<M, MB>, D extends ClassDefinition> {

    public static class InjectedFields {

        @Inject Configuration configuration;
        @Inject ClassTemplateModel.InjectedFields modelInjectedFields;

        @Inject
        public InjectedFields() {
        }
    }

    @NonNull private InjectedFields inj;
    @NonNull @Getter private Template template;
    @NonNull @Getter private ClassFile<D> classFile;
    @NonNull Optional<? extends ClassFile<?>> parentClassFile;
    @NonNull protected MB modelBuilder;

    protected FreemarkerClassTemplate(
            @NonNull InjectedFields injectedFields,
            @NonNull String templateFileName,
            @NonNull MB modelBuilder,
            @NonNull ClassFile<D> classFile,
            @NonNull Optional<? extends ClassFile<?>> parentClassFile
    ) {
        try {
            inj = injectedFields;
            template = inj.configuration.getTemplate(templateFileName);
            this.classFile = classFile;
            this.modelBuilder = modelBuilder;
            this.parentClassFile = parentClassFile;
            initModel(injectedFields.modelInjectedFields);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initModel(ClassTemplateModel.InjectedFields modelInjectedFields) {
        modelBuilder.injectedFields(modelInjectedFields);
        modelBuilder.name(classFile.classDefinition().name());
        modelBuilder.packagePath(classFile.classDefinition().packagePath());
        parentClassFile.ifPresent(p -> modelBuilder.parent(p.classDefinition()));
    }

    public M model() {
        return modelBuilder.build();
    }
}