package com.rodrigodev.xgen.model.support.optional;

import com.rodrigodev.xgen.model.common.template.model.ClassTemplateModel;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
public class OptionalClassTemplateModel extends ClassTemplateModel {

    protected OptionalClassTemplateModel(ClassTemplateModelBuilder builder) {
        super(builder);
    }

    public static OptionalClassTemplateModelBuilder builder() {
        return new OptionalClassTemplateModelBuilder();
    }

    @Setter
    @Accessors(fluent = true)
    public static class OptionalClassTemplateModelBuilder extends ClassTemplateModelBuilder<OptionalClassTemplateModel, OptionalClassTemplateModelBuilder> {

        @Override
        public OptionalClassTemplateModel build() {
            return new OptionalClassTemplateModel(this);
        }
    }
}
