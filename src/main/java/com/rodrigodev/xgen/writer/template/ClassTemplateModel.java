package com.rodrigodev.xgen.writer.template;

import com.rodrigodev.xgen.writer.file_definition.ClassDefinition;
import com.rodrigodev.xgen.writer.template.common.TypeModel;
import lombok.Getter;
import lombok.NonNull;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
@Getter
public class ClassTemplateModel {

    @NonNull final private String name;
    @NonNull final private String packagePath;
    final private TypeModel parent;

    public ClassTemplateModel(String name, String packagePath, ClassDefinition parentClassDefinition) {
        this.name = name;
        this.packagePath = packagePath;
        this.parent = parentClassDefinition != null
                ? new TypeModel(parentClassDefinition.name(), parentClassDefinition.fullyQualifiedName())
                : null;
    }

    protected ClassTemplateModel(ClassTemplateModel another) {
        name = another.name;
        packagePath = another.packagePath;
        parent = another.parent;
    }

    protected static abstract class ClassTemplateModelBuilder<M extends ClassTemplateModel, B extends ClassTemplateModelBuilder<M, B>> {

        @NonNull private String name;
        @NonNull private String packagePath;
        @NonNull private ClassDefinition parent;

        protected abstract B self();

        public B name(String name) {
            this.name = name;
            return self();
        }

        public B packagePath(String packagePath) {
            this.packagePath = packagePath;
            return self();
        }

        public B parent(ClassDefinition parent) {
            this.parent = parent;
            return self();
        }

        public M build() {
            return build(new ClassTemplateModel(name, packagePath, parent));
        }

        protected abstract M build(ClassTemplateModel model);
    }
}
