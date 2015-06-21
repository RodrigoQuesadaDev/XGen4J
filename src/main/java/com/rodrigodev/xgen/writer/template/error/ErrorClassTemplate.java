package com.rodrigodev.xgen.writer.template.error;

import com.rodrigodev.xgen.writer.file_definition.ErrorClassFile;
import com.rodrigodev.xgen.writer.template.FreemarkerClassTemplate;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
public class ErrorClassTemplate extends FreemarkerClassTemplate {

    public static final String TEMPLATE_FILE_NAME = "error-class-def.ftl";



    protected ErrorClassTemplate(ErrorClassFile classFile) {
        super(TEMPLATE_FILE_NAME);
    }

    @Override
    public Object model() {
        return null;
    }
}
