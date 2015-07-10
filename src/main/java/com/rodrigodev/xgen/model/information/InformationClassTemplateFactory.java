package com.rodrigodev.xgen.model.information;

import com.google.common.collect.ImmutableList;
import com.rodrigodev.xgen.model.common.clazz.ErrorExceptionClassDefinitionPair;
import com.rodrigodev.xgen.model.common.template.FreemarkerClassTemplate.InjectedFields;

import javax.inject.Inject;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
public class InformationClassTemplateFactory {

    @Inject InjectedFields injectedFields;

    @Inject
    public InformationClassTemplateFactory() {
    }

    public InformationClassTemplate create(
            InformationClassFile informationClassFile, ImmutableList<ErrorExceptionClassDefinitionPair> errorExceptionPairs
    ) {
        return new InformationClassTemplate(injectedFields, informationClassFile, errorExceptionPairs);
    }
}
