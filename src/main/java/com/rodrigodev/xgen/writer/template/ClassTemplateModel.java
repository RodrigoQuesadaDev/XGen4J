package com.rodrigodev.xgen.writer.template;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
@Value
@Builder
@Accessors(fluent = true)
public abstract class ClassTemplateModel {

    private String name;

    protected ClassTemplateModel(ClassTemplateModel another) {
        name = another.name;
    }

    public static abstract class ClassTemplateModelBuilder {
    }
}
