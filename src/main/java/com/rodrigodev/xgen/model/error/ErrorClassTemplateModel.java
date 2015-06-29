package com.rodrigodev.xgen.model.error;

import com.rodrigodev.xgen.model.common.template.model.ClassTemplateModel;
import com.rodrigodev.xgen.model.common.template.model.TypeTemplateModel;
import com.rodrigodev.xgen.model.error.configuration.ErrorCodeDefinition;
import com.rodrigodev.xgen.model.error.configuration.ErrorDescription;
import com.rodrigodev.xgen.model.error.configuration.ParameterDefinition;
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

    private ErrorDescriptionModel description;
    @NonNull private ErrorCodeModel code;
    @NonNull private String exceptionName;
    @NonNull private String rootPackage;

    private ErrorClassTemplateModel(
            ClassTemplateModel model,
            ErrorDescription description,
            @NonNull ErrorCodeDefinition code,
            @NonNull String exceptionName,
            @NonNull String rootPackage
    ) {
        super(model);
        this.description = description != null ? new ErrorDescriptionModel(description) : null;
        this.code = new ErrorCodeModel(code);
        this.exceptionName = exceptionName;
        this.rootPackage = rootPackage;
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
        private ErrorCodeDefinition code;
        private String exceptionName;
        private String rootPackage;

        @Override
        protected ErrorClassTemplateModelBuilder self() {
            return this;
        }

        @Override
        protected ErrorClassTemplateModel build(ClassTemplateModel model) {
            return new ErrorClassTemplateModel(model, description, code, exceptionName, rootPackage);
        }
    }

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

        @NonNull private TypeTemplateModel type;
        @NonNull private String name;

        public ParameterDefinitionModel(@NonNull ParameterDefinition param) {
            Class<?> paramClass = param.type();
            this.type = new TypeTemplateModel(paramClass.getSimpleName(), paramClass.getCanonicalName());
            this.name = param.name();
        }
    }

    @Value
    public static class ErrorCodeModel {

        @NonNull private String name;

        public ErrorCodeModel(@NonNull ErrorCodeDefinition code) {
            this.name = code.name();
        }
    }
}
