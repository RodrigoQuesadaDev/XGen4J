package com.rodrigodev.xgen.writer.template.exception;

import com.rodrigodev.xgen.writer.file_definition.ClassFile;
import com.rodrigodev.xgen.writer.file_definition.ExceptionClassDefinition;
import com.rodrigodev.xgen.writer.file_definition.ExceptionClassFile;
import com.rodrigodev.xgen.writer.template.FreemarkerClassTemplate;
import com.rodrigodev.xgen.writer.template.exception.ExceptionClassTemplateModel.ExceptionClassTemplateModelBuilder;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
public class ExceptionClassTemplate extends FreemarkerClassTemplate<ExceptionClassTemplateModel, ExceptionClassTemplateModelBuilder, ExceptionClassDefinition> {

    public static final String TEMPLATE_FILE_NAME = "exception-class-def.ftl";

    //TODO change to builder?
    public ExceptionClassTemplate(InjectedFields injectedFields, ExceptionClassFile classFile) {
        super(injectedFields, TEMPLATE_FILE_NAME, ExceptionClassTemplateModel.builder(), classFile);
    }

    @Override
    protected void doInitModel(ClassFile<ExceptionClassDefinition> classFile) {
        //DO NOTHING
    }
}
