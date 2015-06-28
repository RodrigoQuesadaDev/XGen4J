package com.rodrigodev.xgen.model.error.code;

import com.rodrigodev.xgen.model.common.template.model.ClassTemplateModel;

/**
 * Created by Rodrigo Quesada on 25/06/15.
 */
public class ErrorCodeClassTemplateModel extends ClassTemplateModel {

    private ErrorCodeClassTemplateModel(ClassTemplateModel model) {
        super(model);
    }

    public static ErrorCodeClassTemplateModelBuilder builder() {
        return new ErrorCodeClassTemplateModelBuilder();
    }

    public static class ErrorCodeClassTemplateModelBuilder extends ClassTemplateModelBuilder<ErrorCodeClassTemplateModel, ErrorCodeClassTemplateModelBuilder> {

        @Override
        protected ErrorCodeClassTemplateModelBuilder self() {
            return this;
        }

        @Override
        protected ErrorCodeClassTemplateModel build(ClassTemplateModel model) {
            return new ErrorCodeClassTemplateModel(model);
        }
    }
}
