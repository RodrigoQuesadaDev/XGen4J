package com.rodrigodev.xgen4j.model.support.optional;

import com.rodrigodev.xgen4j.model.common.template.FreemarkerClassTemplate;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
public class OptionalClassTemplate extends FreemarkerClassTemplate<OptionalClassTemplateModel, OptionalClassDefinition> {

    private static final String TEMPLATE_FILE_NAME = "optional-class-def.ftl";

    protected OptionalClassTemplate(
            InjectedFields injectedFields,
            OptionalClassFile optionalClassFile
    ) {
        super(
                injectedFields,
                TEMPLATE_FILE_NAME,
                OptionalClassTemplateModel.builder(),
                optionalClassFile,
                Optional.empty()
        );
    }
}
