package com.rodrigodev.xgen4j.model.information.template;

import com.google.common.collect.ImmutableList;
import com.rodrigodev.xgen4j.model.common.clazz.ErrorExceptionClassDefinitionPair;
import com.rodrigodev.xgen4j.model.common.template.FreemarkerClassTemplate;
import com.rodrigodev.xgen4j.model.information.InformationClassDefinition;
import com.rodrigodev.xgen4j.model.information.InformationClassFile;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
public class InformationClassTemplate extends FreemarkerClassTemplate<InformationClassTemplateModel, InformationClassDefinition> {

    private static final String TEMPLATE_FILE_NAME = "information-class-def.ftl";

    public InformationClassTemplate(
            InjectedFields injectedFields,
            InformationClassFile informationClassFile,
            ImmutableList<ErrorExceptionClassDefinitionPair> errorExceptionPairs
    ) {
        super(
                injectedFields,
                TEMPLATE_FILE_NAME,
                InformationClassTemplateModel.builder().errorExceptionPairs(errorExceptionPairs),
                informationClassFile,
                Optional.empty()
        );
    }
}
