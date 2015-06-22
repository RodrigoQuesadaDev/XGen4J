package com.rodrigodev.xgen.writer.template;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
@Getter
@AllArgsConstructor
public class ClassTemplateModel {

    @NonNull final private String name;
    @NonNull final private String packagePath;

    protected ClassTemplateModel(ClassTemplateModel another) {
        name = another.name;
        packagePath = another.packagePath;
    }

    protected static abstract class ClassTemplateModelBuilder<M extends ClassTemplateModel, B extends ClassTemplateModelBuilder<M, B>> {

        private String name;
        private String packagePath;

        protected abstract B self();

        public B name(String name) {
            this.name = name;
            return self();
        }

        public B packagePath(String packagePath) {
            this.packagePath = packagePath;
            return self();
        }

        public M build() {
            return build(new ClassTemplateModel(name, packagePath));
        }

        protected abstract M build(ClassTemplateModel model);
    }
}
