package com.rodrigodev.xgen.writer.template.error;

import com.rodrigodev.xgen.writer.template.ClassTemplateModel;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
public class ErrorClassTemplateModel extends ClassTemplateModel {

    public ErrorClassTemplateModel(ClassTemplateModel model) {
        super(model);
    }

    public static ErrorClassTemplateModelBuilder builder() {
        return new ErrorClassTemplateModelBuilder();
    }

    private static class ErrorClassTemplateModelBuilder extends ClassTemplateModelBuilder {

        public ErrorClassTemplateModelBuilder() {
            super();
        }

        @Override
        public ErrorClassTemplateModel build() {
            return new ErrorClassTemplateModel(super.build());
        }
    }
}
