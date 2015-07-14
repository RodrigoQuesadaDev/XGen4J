package com.rodrigodev.xgen.model.support.optional;

import com.rodrigodev.xgen.model.common.template.FreemarkerClassTemplate.InjectedFields;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Singleton
public class OptionalClassTemplateFactory {

    @Inject InjectedFields injectedFields;

    @Inject
    public OptionalClassTemplateFactory() {
    }

    public OptionalClassTemplate create(OptionalClassFile optionalClassFile) {
        return new OptionalClassTemplate(injectedFields, optionalClassFile);
    }
}
