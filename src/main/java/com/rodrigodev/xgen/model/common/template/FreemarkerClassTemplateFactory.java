package com.rodrigodev.xgen.model.common.template;

import com.rodrigodev.xgen.model.common.template.FreemarkerClassTemplate.InjectedFields;

import javax.inject.Inject;

/**
 * Created by Rodrigo Quesada on 28/06/15.
 */
public abstract class FreemarkerClassTemplateFactory {

    @Inject protected InjectedFields injectedFields;
}
