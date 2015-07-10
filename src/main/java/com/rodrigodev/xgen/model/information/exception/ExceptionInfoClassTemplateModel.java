package com.rodrigodev.xgen.model.information.exception;

import com.rodrigodev.xgen.model.common.template.model.ClassTemplateModel;
import com.rodrigodev.xgen.model.common.template.model.TypeTemplateModel;
import com.rodrigodev.xgen.model.error.ErrorClassDefinition;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassDefinition;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
@Value
public class ExceptionInfoClassTemplateModel extends ClassTemplateModel {

    @NonNull private RootErrorTemplateModel rootError;

    protected ExceptionInfoClassTemplateModel(
            ClassTemplateModel another,
            @NonNull ErrorClassDefinition rootError,
            @NonNull ExceptionClassDefinition rootException
    ) {
        super(another);
        this.rootError = new RootErrorTemplateModel(rootError, rootException);
    }

    public static ExceptionInfoClassTemplateModelBuilder builder() {
        return new ExceptionInfoClassTemplateModelBuilder();
    }

    @Setter
    @Accessors(fluent = true)
    public static class ExceptionInfoClassTemplateModelBuilder extends ClassTemplateModelBuilder<ExceptionInfoClassTemplateModel, ExceptionInfoClassTemplateModelBuilder> {

        private ErrorClassDefinition rootError;
        private ExceptionClassDefinition rootException;

        @Override
        protected ExceptionInfoClassTemplateModelBuilder self() {
            return this;
        }

        @Override
        protected ExceptionInfoClassTemplateModel build(ClassTemplateModel model) {
            return new ExceptionInfoClassTemplateModel(model, rootError, rootException);
        }
    }

    @Value
    public class RootErrorTemplateModel extends TypeTemplateModel {

        @NonNull private TypeTemplateModel exception;

        public RootErrorTemplateModel(@NonNull ErrorClassDefinition error,
                                      @NonNull ExceptionClassDefinition rootException) {
            super(error);
            exception = new TypeTemplateModel(rootException);
        }
    }
}