package com.rodrigodev.xgen.model.information;

import com.google.common.collect.ImmutableList;
import com.rodrigodev.xgen.model.common.clazz.ErrorExceptionClassDefinitionPair;
import com.rodrigodev.xgen.model.common.template.model.ClassTemplateModel;
import com.rodrigodev.xgen.model.common.template.model.TypeTemplateModel;
import com.rodrigodev.xgen.model.error.configuration.CustomMessageGeneratorDefinition;
import com.rodrigodev.xgen.model.error.configuration.ErrorDefinition;
import com.rodrigodev.xgen.model.error.configuration.ErrorDescriptionDefinition;
import com.rodrigodev.xgen.model.error.exception.ExceptionClassDefinition;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.Optional;

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

    @Value
    public static class ErrorTemplateModel extends TypeTemplateModel {

        @NonNull private ExceptionTemplateModel exception;
        private boolean common;
        private DescriptionTemplateModel description;

        public ErrorTemplateModel(@NonNull ErrorExceptionClassDefinitionPair errorExceptionPair) {
            super(errorExceptionPair.error());

            this.exception = new ExceptionTemplateModel(errorExceptionPair.exception());

            ErrorDefinition errorDefinition = errorExceptionPair.error().errorDefinition();
            this.common = errorDefinition.isCommon();

            Optional<ErrorDescriptionDefinition> descriptionDefinition = errorDefinition.description();
            Optional<CustomMessageGeneratorDefinition> customMessageGenerator = errorDefinition.customMessageGenerator();
            this.description = descriptionDefinition.isPresent() || customMessageGenerator.isPresent()
                    ?
                    new DescriptionTemplateModel(
                            descriptionDefinition.isPresent()
                                    ? descriptionDefinition.get().format()
                                    : customMessageGenerator.get().type().getCanonicalName() + ".class",
                            descriptionDefinition.isPresent()
                    )
                    : null;
        }
    }

    @Value
    public static class ExceptionTemplateModel extends TypeTemplateModel {

        private boolean hasType;

        public ExceptionTemplateModel(ExceptionClassDefinition classDefinition) {
            super(classDefinition);
            this.hasType = classDefinition.hasType();
        }
    }

    @Value
    public static class DescriptionTemplateModel {

        private String content;
        private boolean plainText;
    }
}
