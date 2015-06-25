package com.rodrigodev.xgen.writer.template.error;

import com.rodrigodev.xgen.configuration.ErrorDescription;
import com.rodrigodev.xgen.configuration.ParameterDefinition;
import com.rodrigodev.xgen.writer.template.ClassTemplateModel;
import com.rodrigodev.xgen.writer.template.common.TypeModel;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.Arrays;

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

        @NonNull private TypeModel type;
        @NonNull private String name;

        public ParameterDefinitionModel(@NonNull ParameterDefinition param) {
            Class<?> paramClass = param.type();
            this.type = new TypeModel(paramClass.getSimpleName(), paramClass.getCanonicalName());
            this.name = param.name();
        }
    }

    @NonNull private ErrorDescriptionModel description;
    @NonNull private String exceptionName;

    public ErrorClassTemplateModel(
            @NonNull ClassTemplateModel model,
            ErrorDescription description,
            @NonNull String exceptionName
    ) {
        super(model);
        this.description = description != null ? new ErrorDescriptionModel(description) : null;
        this.exceptionName = exceptionName;
    }

    public static ErrorClassTemplateModelBuilder builder() {
        return new ErrorClassTemplateModelBuilder();
    }

    public boolean isConcrete() {
        return description != null;
    }

    public ErrorDescriptionModel getDescription() {
        return description;
    }

    @Setter
    @Accessors(fluent = true)
    public static class ErrorClassTemplateModelBuilder extends ClassTemplateModelBuilder<ErrorClassTemplateModel, ErrorClassTemplateModelBuilder> {

        private ErrorDescription description;
        @NonNull private String exceptionName;

        @Override
        protected ErrorClassTemplateModelBuilder self() {
            return this;
        }

        @Override
        protected ErrorClassTemplateModel build(ClassTemplateModel model) {
            return new ErrorClassTemplateModel(model, description, exceptionName);
        }
    }
}
