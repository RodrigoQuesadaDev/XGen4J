package com.rodrigodev.xgen.model.information.template;

import com.google.common.collect.ImmutableList;
import com.rodrigodev.xgen.model.common.clazz.ErrorExceptionClassDefinitionPair;
import com.rodrigodev.xgen.model.common.template.FreemarkerClassTemplate.InjectedFields;
import com.rodrigodev.xgen.model.information.InformationClassFile;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
@Singleton
public class InformationClassTemplateFactory {

    @Inject InjectedFields injectedFields;

    @Inject
    public InformationClassTemplateFactory() {
    }

    public InformationClassTemplate create(
            InformationClassFile informationClassFile,
            ImmutableList<ErrorExceptionClassDefinitionPair> errorExceptionPairs
    ) {
        return new InformationClassTemplate(injectedFields, informationClassFile, errorExceptionPairs);
    }
}
