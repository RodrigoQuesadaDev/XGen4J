package com.rodrigodev.xgen.model.information.template;

import com.google.common.collect.ImmutableList;
import com.rodrigodev.xgen.model.common.clazz.ErrorExceptionClassDefinitionPair;
import com.rodrigodev.xgen.model.common.template.model.ClassTemplateModel;
import com.rodrigodev.xgen.model.information.template.model.ErrorTemplateModel;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 10/07/15.
 */
@Value
public class InformationClassTemplateModel extends ClassTemplateModel {

    private ImmutableList<ErrorTemplateModel> errors;

    private InformationClassTemplateModel(
            InformationClassTemplateModelBuilder builder,
            @NonNull ImmutableList<ErrorExceptionClassDefinitionPair> errorExceptionPairs
    ) {
        super(builder);

        ImmutableList.Builder<ErrorTemplateModel> errorsListBuilder = ImmutableList.builder();
        errorExceptionPairs.stream()
                .map(ErrorTemplateModel::new)
                .forEach(errorsListBuilder::add);

        this.errors = errorsListBuilder.build();
    }

    protected InformationClassTemplateModel(InformationClassTemplateModelBuilder builder) {
        this(builder, builder.errorExceptionPairs);
    }

    public static InformationClassTemplateModelBuilder builder() {
        return new InformationClassTemplateModelBuilder();
    }

    @Setter
    @Accessors(fluent = true)
    public static class InformationClassTemplateModelBuilder extends ClassTemplateModelBuilder<InformationClassTemplateModel, InformationClassTemplateModelBuilder> {

        private ImmutableList<ErrorExceptionClassDefinitionPair> errorExceptionPairs;

        @Override
        public InformationClassTemplateModel build() {
            return new InformationClassTemplateModel(this);
        }
    }
}
