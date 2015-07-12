package com.rodrigodev.xgen.model.error.exception;

import com.rodrigodev.xgen.model.common.template.model.ClassTemplateModel;
import com.rodrigodev.xgen.model.common.template.model.TypeTemplateModel;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
@Value
public class ExceptionClassTemplateModel extends ClassTemplateModel {

    private TypeTemplateModel root;
    private boolean common;
    private boolean hasType;
    private boolean checkedException;

    private ExceptionClassTemplateModel(
            ExceptionClassTemplateModelBuilder builder,
            ExceptionClassDefinition root,
            boolean common,
            boolean hasType,
            boolean checkedException
    ) {
        super(builder);
        this.root = root != null ? new TypeTemplateModel(root) : null;
        this.common = common;
        this.hasType = hasType;
        this.checkedException = checkedException;
    }

    protected ExceptionClassTemplateModel(ExceptionClassTemplateModelBuilder builder) {
        this(builder, builder.root, builder.common, builder.hasType, builder.checkedException);
    }

    public static ExceptionClassTemplateModelBuilder builder() {
        return new ExceptionClassTemplateModelBuilder();
    }

    @Setter
    @Accessors(fluent = true)
    public static class ExceptionClassTemplateModelBuilder extends ClassTemplateModelBuilder<ExceptionClassTemplateModel, ExceptionClassTemplateModelBuilder> {

        private ExceptionClassDefinition root;
        private boolean common;
        private boolean hasType;
        private boolean checkedException;

        @Override
        public ExceptionClassTemplateModel build() {
            return new ExceptionClassTemplateModel(this);
        }
    }
}
