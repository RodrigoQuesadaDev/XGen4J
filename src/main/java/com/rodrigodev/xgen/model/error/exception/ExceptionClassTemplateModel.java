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

    public ExceptionClassTemplateModel(ClassTemplateModel model, ExceptionClassDefinition root, boolean common) {
        super(model);
        this.root = root != null ? new TypeTemplateModel(root) : null;
        this.common = common;
    }

    public static ExceptionClassTemplateModelBuilder builder() {
        return new ExceptionClassTemplateModelBuilder();
    }

    @Setter
    @Accessors(fluent = true)
    public static class ExceptionClassTemplateModelBuilder extends ClassTemplateModelBuilder<ExceptionClassTemplateModel, ExceptionClassTemplateModelBuilder> {

        private ExceptionClassDefinition root;
        private boolean common;

        @Override
        protected ExceptionClassTemplateModelBuilder self() {
            return this;
        }

        @Override
        protected ExceptionClassTemplateModel build(ClassTemplateModel model) {
            return new ExceptionClassTemplateModel(model, root, common);
        }
    }
}
