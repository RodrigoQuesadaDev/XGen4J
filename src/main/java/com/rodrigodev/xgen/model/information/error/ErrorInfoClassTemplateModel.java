package com.rodrigodev.xgen.model.information.error;

import com.rodrigodev.xgen.model.common.template.model.ClassTemplateModel;
import com.rodrigodev.xgen.model.common.template.model.OptionalTypeTemplateModel;
import com.rodrigodev.xgen.model.common.template.model.TypeTemplateModel;
import com.rodrigodev.xgen.model.error.ErrorClassFile;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
@Value
@EqualsAndHashCode(callSuper = true)
public class ErrorInfoClassTemplateModel extends ClassTemplateModel {

    @NonNull private TypeTemplateModel rootError;
    @NonNull private OptionalTypeTemplateModel optionalType;

    private ErrorInfoClassTemplateModel(
            ErrorInfoClassTemplateModelBuilder builder,
            @NonNull ErrorInfoClassFile errorInfoClassFile,
            @NonNull ErrorClassFile rootErrorClassFile
    ) {
        super(builder);
        this.rootError = new TypeTemplateModel(rootErrorClassFile.classDefinition());
        this.optionalType = OptionalTypeTemplateModel.builder()
                .rootErrorClassFile(rootErrorClassFile)
                .optionalClassType(errorInfoClassFile.classDefinition().optionalClassType())
                .build();
    }

    protected ErrorInfoClassTemplateModel(ErrorInfoClassTemplateModelBuilder builder) {
        this(builder, builder.errorInfoClassFile, builder.rootErrorClassFile);
    }

    public static ErrorInfoClassTemplateModelBuilder builder() {
        return new ErrorInfoClassTemplateModelBuilder();
    }

    @Setter
    @Accessors(fluent = true)
    public static class ErrorInfoClassTemplateModelBuilder extends ClassTemplateModelBuilder<ErrorInfoClassTemplateModel, ErrorInfoClassTemplateModelBuilder> {

        private ErrorInfoClassFile errorInfoClassFile;
        private ErrorClassFile rootErrorClassFile;

        @Override
        public ErrorInfoClassTemplateModel build() {
            return new ErrorInfoClassTemplateModel(this);
        }
    }
}

