package com.rodrigodev.xgen.writer.template.error;

import com.rodrigodev.xgen.writer.file_definition.ClassFile;
import com.rodrigodev.xgen.writer.file_definition.ErrorClassDefinition;
import com.rodrigodev.xgen.writer.file_definition.ErrorClassFile;
import com.rodrigodev.xgen.writer.template.FreemarkerClassTemplate;
import com.rodrigodev.xgen.writer.template.error.ErrorClassTemplateModel.ErrorClassTemplateModelBuilder;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
public class ErrorClassTemplate extends FreemarkerClassTemplate<ErrorClassTemplateModel, ErrorClassTemplateModelBuilder, ErrorClassDefinition> {

    public static final String TEMPLATE_FILE_NAME = "error-class-def.ftl";

    //TODO change to builder?
    public ErrorClassTemplate(InjectedFields injectedFields, ErrorClassFile classFile) {
        super(injectedFields, TEMPLATE_FILE_NAME, ErrorClassTemplateModel.builder(), classFile);
    }

    @Override
    protected void doInitModel(ClassFile<ErrorClassDefinition> classFile) {
        classFile.classDefinition().errorDefinition().description().ifPresent(modelBuilder::description);
    }
}
