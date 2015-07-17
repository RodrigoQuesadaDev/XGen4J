package com.rodrigodev.xgen4j.model.error.template;

import com.rodrigodev.xgen4j.model.common.template.model.ClassTemplateModel;
import com.rodrigodev.xgen4j.model.common.template.model.TypeTemplateModel;
import com.rodrigodev.xgen4j.model.error.ErrorClassFile;
import com.rodrigodev.xgen4j.model.error.configuration.definition.ErrorDefinition;
import com.rodrigodev.xgen4j.model.error.configuration.definition.description.CustomMessageGeneratorDefinition;
import com.rodrigodev.xgen4j.model.error.configuration.definition.description.ErrorDescriptionDefinition;
import com.rodrigodev.xgen4j.model.error.exception.ExceptionClassDefinition;
import com.rodrigodev.xgen4j.model.error.exception.ExceptionClassFile;
import com.rodrigodev.xgen4j.model.error.template.model.*;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
@Value
@EqualsAndHashCode(callSuper = true)
public class ErrorClassTemplateModel extends ClassTemplateModel {

    private ErrorDescriptionModel description;
    @NonNull private ErrorCodeModel code;
    @NonNull private ExceptionModel exception;
    @NonNull private RootTemplateModel root;
    private boolean common;

    private ErrorClassTemplateModel(
            ErrorClassTemplateModelBuilder builder,
            @NonNull Optional<ErrorClassFile> rootErrorClassFile,
            @NonNull Optional<ExceptionClassFile> rootExceptionClassFile,
            @NonNull ErrorClassFile errorClassFile,
            @NonNull ExceptionClassFile exceptionClassFile
    ) {
        super(builder);

        ErrorDefinition errorDefinition = errorClassFile.classDefinition().errorDefinition();
        ExceptionClassDefinition exceptionClassDefinition = exceptionClassFile.classDefinition();
        Optional<ErrorDescriptionDefinition> errorDescription = errorDefinition.description();
        Optional<CustomMessageGeneratorDefinition> errorMessageGenerator = errorDefinition.customMessageGenerator();

        this.description = errorDescription.isPresent()
                ? new ErrorDescriptionModel(errorDescription.get())
                :
                errorMessageGenerator.isPresent()
                        ? new ErrorDescriptionModel(errorMessageGenerator.get())
                        : null;
        this.code = new ErrorCodeModel(errorDefinition.code());
        this.exception = new ExceptionModel(exceptionClassDefinition);
        this.root = rootErrorClassFile.isPresent()
                ?
                new RootTemplateModel(
                        rootErrorClassFile.get().classDefinition(), rootExceptionClassFile.get().classDefinition()
                )
                : null;
        this.common = errorDefinition.isCommon();
    }

    protected ErrorClassTemplateModel(ErrorClassTemplateModelBuilder builder) {
        this(builder,
             builder.rootErrorClassFile,
             builder.rootExceptionClassFile,
             builder.errorClassFile,
             builder.exceptionClassFile
        );
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

    @Override
    public TypeTemplateModel getParent() {
        return super.getParent() != null ? new ParentModel(super.getParent(), root) : null;
    }

    @Accessors(fluent = true)
    public static class ErrorClassTemplateModelBuilder extends ClassTemplateModelBuilder<ErrorClassTemplateModel, ErrorClassTemplateModelBuilder> {

        private Optional<ErrorClassFile> rootErrorClassFile;
        private Optional<ExceptionClassFile> rootExceptionClassFile;
        @Setter private ErrorClassFile errorClassFile;
        @Setter private ExceptionClassFile exceptionClassFile;

        public ErrorClassTemplateModelBuilder() {
            rootErrorClassFile = Optional.empty();
            rootExceptionClassFile = Optional.empty();
        }

        public void rootErrorClassFile(@NonNull ErrorClassFile rootErrorClassFile) {
            this.rootErrorClassFile = Optional.of(rootErrorClassFile);
        }

        public void rootExceptionClassFile(@NonNull ExceptionClassFile rootExceptionClassFile) {
            this.rootExceptionClassFile = Optional.of(rootExceptionClassFile);
        }

        @Override
        public ErrorClassTemplateModel build() {
            return new ErrorClassTemplateModel(this);
        }
    }
}
