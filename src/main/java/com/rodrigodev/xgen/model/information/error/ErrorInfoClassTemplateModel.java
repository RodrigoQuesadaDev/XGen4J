package com.rodrigodev.xgen.model.information.error;

import com.rodrigodev.xgen.model.common.template.model.ClassTemplateModel;
import com.rodrigodev.xgen.model.common.template.model.TypeTemplateModel;
import com.rodrigodev.xgen.model.error.ErrorClassDefinition;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
@Value
public class ErrorInfoClassTemplateModel extends ClassTemplateModel {

    @NonNull private TypeTemplateModel rootError;

    protected ErrorInfoClassTemplateModel(ClassTemplateModel another, @NonNull ErrorClassDefinition rootError) {
        super(another);
        this.rootError = new TypeTemplateModel(rootError);
    }

    public static ErrorInfoClassTemplateModelBuilder builder() {
        return new ErrorInfoClassTemplateModelBuilder();
    }

    @Setter
    @Accessors(fluent = true)
    public static class ErrorInfoClassTemplateModelBuilder extends ClassTemplateModelBuilder<ErrorInfoClassTemplateModel, ErrorInfoClassTemplateModelBuilder> {

        private ErrorClassDefinition rootError;

        @Override
        protected ErrorInfoClassTemplateModelBuilder self() {
            return this;
        }

        @Override
        protected ErrorInfoClassTemplateModel build(ClassTemplateModel model) {
            return new ErrorInfoClassTemplateModel(model, rootError);
        }
    }
}

