package com.rodrigodev.xgen.writer.template.error;

import com.rodrigodev.xgen.configuration.ErrorDescription;
import com.rodrigodev.xgen.configuration.ParameterDefinition;
import com.rodrigodev.xgen.writer.template.ClassTemplateModel;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
@Value
public class ErrorClassTemplateModel extends ClassTemplateModel {

    @Value
    public static class ErrorDescriptionModel {

        @NonNull private String format;
        @NonNull private ParameterDefinitionModel[] params;

        public ErrorDescriptionModel(@NonNull ErrorDescription description) {
            format = description.format();
            params = Arrays.stream(description.params())
                    .map(ParameterDefinitionModel::new)
                    .toArray(ParameterDefinitionModel[]::new);
        }
    }

    @Value
    public static class ParameterDefinitionModel {

        @NonNull private String type;
        @NonNull private String name;

        public ParameterDefinitionModel(@NonNull ParameterDefinition param) {
            type = param.type().getSimpleName();
            name = param.name();
        }
    }

    @NonNull private Optional<ErrorDescriptionModel> description;

    public ErrorClassTemplateModel(ClassTemplateModel model, @NonNull Optional<ErrorDescription> description) {
        super(model);
        this.description = description.isPresent()
                ? Optional.of(new ErrorDescriptionModel(description.get()))
                : Optional.empty();
    }

    public static ErrorClassTemplateModelBuilder builder() {
        return new ErrorClassTemplateModelBuilder();
    }

    public boolean isConcrete() {
        return description.isPresent();
    }

    public ErrorDescriptionModel getDescription() {
        return description.get();
    }

    @Setter
    @Accessors(fluent = true)
    public static class ErrorClassTemplateModelBuilder extends ClassTemplateModelBuilder<ErrorClassTemplateModel> {

        private ErrorDescription description;

        @Override
        protected ClassTemplateModelBuilder<ErrorClassTemplateModel> self() {
            return this;
        }

        @Override
        protected ErrorClassTemplateModel build(ClassTemplateModel model) {
            return new ErrorClassTemplateModel(model, Optional.ofNullable(description));
        }
    }
}
