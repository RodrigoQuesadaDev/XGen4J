package com.rodrigodev.xgen.model.information.exception.template;

import com.rodrigodev.xgen.model.common.template.model.ClassTemplateModel;
import com.rodrigodev.xgen.model.error.ErrorClassFile;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassFile;
import com.rodrigodev.xgen.model.information.exception.template.model.RootErrorTemplateModel;
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

    private ExceptionInfoClassTemplateModel(
            ExceptionInfoClassTemplateModelBuilder builder,
            @NonNull ErrorClassFile rootErrorClassFile,
            @NonNull ExceptionClassFile rootExceptionClassFile
    ) {
        super(builder);
        this.rootError = new RootErrorTemplateModel(
                rootErrorClassFile.classDefinition(),
                rootExceptionClassFile.classDefinition()
        );
    }

    protected ExceptionInfoClassTemplateModel(ExceptionInfoClassTemplateModelBuilder builder) {
        this(builder, builder.rootErrorClassFile, builder.rootExceptionClassFile);
    }

    public static ExceptionInfoClassTemplateModelBuilder builder() {
        return new ExceptionInfoClassTemplateModelBuilder();
    }

    @Setter
    @Accessors(fluent = true)
    public static class ExceptionInfoClassTemplateModelBuilder extends ClassTemplateModelBuilder<ExceptionInfoClassTemplateModel, ExceptionInfoClassTemplateModelBuilder> {

        private ErrorClassFile rootErrorClassFile;
        private ExceptionClassFile rootExceptionClassFile;

        @Override
        public ExceptionInfoClassTemplateModel build() {
            return new ExceptionInfoClassTemplateModel(this);
        }
    }
}
