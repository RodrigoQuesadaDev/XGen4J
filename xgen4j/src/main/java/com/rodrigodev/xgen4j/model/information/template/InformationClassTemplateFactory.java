package com.rodrigodev.xgen4j.model.information.template;

import com.google.common.collect.ImmutableList;
import com.rodrigodev.xgen4j.model.common.clazz.ErrorExceptionClassFilePair;
import com.rodrigodev.xgen4j.model.common.template.FreemarkerClassTemplate.InjectedFields;
import com.rodrigodev.xgen4j.model.error.code.ErrorCodeClassFile;
import com.rodrigodev.xgen4j.model.information.InformationClassFile;

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
            ImmutableList<ErrorExceptionClassFilePair> errorExceptionPairs,
            ErrorCodeClassFile errorCodeClassFile
    ) {
        return new InformationClassTemplate(
                injectedFields, informationClassFile, errorExceptionPairs, errorCodeClassFile
        );
    }
}
