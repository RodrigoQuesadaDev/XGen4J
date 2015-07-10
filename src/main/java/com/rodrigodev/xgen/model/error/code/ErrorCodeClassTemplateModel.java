package com.rodrigodev.xgen.model.error.code;

import com.rodrigodev.xgen.model.common.template.model.ClassTemplateModel;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 25/06/15.
 */
@Value
public class ErrorCodeClassTemplateModel extends ClassTemplateModel {

    private boolean hasNumber;

    private ErrorCodeClassTemplateModel(ClassTemplateModel another, boolean hasNumber) {
        super(another);
        this.hasNumber = hasNumber;
    }

    public static ErrorCodeClassTemplateModelBuilder builder() {
        return new ErrorCodeClassTemplateModelBuilder();
    }

    @Setter
    @Accessors(fluent = true)
    public static class ErrorCodeClassTemplateModelBuilder extends ClassTemplateModelBuilder<ErrorCodeClassTemplateModel, ErrorCodeClassTemplateModelBuilder> {

        private boolean hasNumber;

        @Override
        protected ErrorCodeClassTemplateModelBuilder self() {
            return this;
        }

        @Override
        protected ErrorCodeClassTemplateModel build(ClassTemplateModel model) {
            return new ErrorCodeClassTemplateModel(model, hasNumber);
        }
    }
}
