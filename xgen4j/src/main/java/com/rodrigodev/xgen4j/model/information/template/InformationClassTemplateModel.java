package com.rodrigodev.xgen4j.model.information.template;

import com.google.common.collect.ImmutableList;
import com.rodrigodev.xgen4j.model.common.clazz.ErrorExceptionClassFilePair;
import com.rodrigodev.xgen4j.model.common.template.model.ClassTemplateModel;
import com.rodrigodev.xgen4j.model.error.code.ErrorCodeClassFile;
import com.rodrigodev.xgen4j.model.information.template.model.ErrorCodeTemplateModel;
import com.rodrigodev.xgen4j.model.information.template.model.ErrorTemplateModel;
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
public class InformationClassTemplateModel extends ClassTemplateModel {

    private ImmutableList<ErrorTemplateModel> errors;
    private ErrorCodeTemplateModel errorCode;

    private InformationClassTemplateModel(
            InformationClassTemplateModelBuilder builder,
            @NonNull ImmutableList<ErrorExceptionClassFilePair> errorExceptionPairs,
            @NonNull ErrorCodeClassFile errorCodeClassFile
    ) {
        super(builder);

        ImmutableList.Builder<ErrorTemplateModel> errorsListBuilder = ImmutableList.builder();
        errorExceptionPairs.stream()
                .map(ErrorTemplateModel::new)
                .forEach(errorsListBuilder::add);

        this.errors = errorsListBuilder.build();
        this.errorCode = new ErrorCodeTemplateModel(errorCodeClassFile);
    }

    protected InformationClassTemplateModel(InformationClassTemplateModelBuilder builder) {
        this(builder, builder.errorExceptionPairs, builder.errorCodeClassFile);
    }

    public static InformationClassTemplateModelBuilder builder() {
        return new InformationClassTemplateModelBuilder();
    }

    @Setter
    @Accessors(fluent = true)
    public static class InformationClassTemplateModelBuilder extends ClassTemplateModelBuilder<InformationClassTemplateModel, InformationClassTemplateModelBuilder> {

        private ImmutableList<ErrorExceptionClassFilePair> errorExceptionPairs;
        private ErrorCodeClassFile errorCodeClassFile;

        @Override
        public InformationClassTemplateModel build() {
            return new InformationClassTemplateModel(this);
        }
    }
}
