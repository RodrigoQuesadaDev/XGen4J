package com.rodrigodev.xgen.model.error.exception;

import com.rodrigodev.xgen.model.common.template.model.ClassTemplateModel;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
@Value
public class ExceptionClassTemplateModel extends ClassTemplateModel {

    public ExceptionClassTemplateModel(ClassTemplateModel model) {
        super(model);
    }

    public static ExceptionClassTemplateModelBuilder builder() {
        return new ExceptionClassTemplateModelBuilder();
    }

    @Setter
    @Accessors(fluent = true)
    public static class ExceptionClassTemplateModelBuilder extends ClassTemplateModelBuilder<ExceptionClassTemplateModel, ExceptionClassTemplateModelBuilder> {

        @Override
        protected ExceptionClassTemplateModelBuilder self() {
            return this;
        }

        @Override
        protected ExceptionClassTemplateModel build(ClassTemplateModel model) {
            return new ExceptionClassTemplateModel(model);
        }
    }
}
