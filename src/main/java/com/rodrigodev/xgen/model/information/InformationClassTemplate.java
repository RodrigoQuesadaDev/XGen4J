package com.rodrigodev.xgen.model.information;

import com.google.common.collect.ImmutableList;
import com.rodrigodev.xgen.model.common.clazz.ErrorExceptionClassDefinitionPair;
import com.rodrigodev.xgen.model.common.template.FreemarkerClassTemplate;
import com.rodrigodev.xgen.model.information.InformationClassTemplateModel.InformationClassTemplateModelBuilder;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
public class InformationClassTemplate extends FreemarkerClassTemplate<InformationClassTemplateModel, InformationClassDefinition> {

    public static final String TEMPLATE_FILE_NAME = "information-class-def.ftl";

    public InformationClassTemplate(
            InjectedFields injectedFields,
            InformationClassFile informationClassFile,
            ImmutableList<ErrorExceptionClassDefinitionPair> errorExceptionPairs
    ) {
        super(
                injectedFields,
                TEMPLATE_FILE_NAME,
                modelBuilder(errorExceptionPairs),
                informationClassFile,
                Optional.empty()
        );
    }

    private static InformationClassTemplateModelBuilder modelBuilder(
            ImmutableList<ErrorExceptionClassDefinitionPair> errorExceptionPairs
    ) {
        InformationClassTemplateModelBuilder modelBuilder = InformationClassTemplateModel.builder();
        modelBuilder.errorExceptionPairs(errorExceptionPairs);
        return modelBuilder;
    }
}
