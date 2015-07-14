package com.rodrigodev.xgen4j.model.error.exception;

import com.rodrigodev.xgen4j.model.common.template.model.ClassTemplateModel;
import com.rodrigodev.xgen4j.model.common.template.model.TypeTemplateModel;
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
public class ExceptionClassTemplateModel extends ClassTemplateModel {

    private TypeTemplateModel root;
    private boolean common;
    private boolean hasType;
    private boolean checkedException;

    private ExceptionClassTemplateModel(
            ExceptionClassTemplateModelBuilder builder,
            @NonNull Optional<ExceptionClassFile> rootClassFile,
            @NonNull ExceptionClassFile errorClassFile
    ) {
        super(builder);

        ExceptionClassDefinition classDefinition = errorClassFile.classDefinition();

        this.root = rootClassFile.isPresent() ? new TypeTemplateModel(rootClassFile.get().classDefinition()) : null;
        this.common = classDefinition.errorDefinition().isCommon();
        this.hasType = classDefinition.hasType();
        this.checkedException = classDefinition.isCheckedException();
    }

    protected ExceptionClassTemplateModel(ExceptionClassTemplateModelBuilder builder) {
        this(builder, builder.rootClassFile, builder.errorClassFile);
    }

    public static ExceptionClassTemplateModelBuilder builder() {
        return new ExceptionClassTemplateModelBuilder();
    }

    @Setter
    @Accessors(fluent = true)
    public static class ExceptionClassTemplateModelBuilder extends ClassTemplateModelBuilder<ExceptionClassTemplateModel, ExceptionClassTemplateModelBuilder> {

        private Optional<ExceptionClassFile> rootClassFile;
        private ExceptionClassFile errorClassFile;

        @Override
        public ExceptionClassTemplateModel build() {
            return new ExceptionClassTemplateModel(this);
        }
    }
}
