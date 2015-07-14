package com.rodrigodev.xgen4j.model.error.code;

import com.rodrigodev.xgen4j.model.common.template.model.ClassTemplateModel;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 25/06/15.
 */
@Value
@EqualsAndHashCode(callSuper = true)
public class ErrorCodeClassTemplateModel extends ClassTemplateModel {

    private boolean hasNumber;

    private ErrorCodeClassTemplateModel(
            ErrorCodeClassTemplateModelBuilder builder,
            @NonNull ErrorCodeClassFile errorCodeClassFile
    ) {
        super(builder);
        this.hasNumber = errorCodeClassFile.classDefinition().hasNumber();
    }

    protected ErrorCodeClassTemplateModel(ErrorCodeClassTemplateModelBuilder builder) {
        this(builder, builder.errorCodeClassFile);
    }

    public static ErrorCodeClassTemplateModelBuilder builder() {
        return new ErrorCodeClassTemplateModelBuilder();
    }

    @Setter
    @Accessors(fluent = true)
    public static class ErrorCodeClassTemplateModelBuilder extends ClassTemplateModelBuilder<ErrorCodeClassTemplateModel, ErrorCodeClassTemplateModelBuilder> {

        private ErrorCodeClassFile errorCodeClassFile;

        @Override
        public ErrorCodeClassTemplateModel build() {
            return new ErrorCodeClassTemplateModel(this);
        }
    }
}
