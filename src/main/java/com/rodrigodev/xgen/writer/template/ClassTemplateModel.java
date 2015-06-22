package com.rodrigodev.xgen.writer.template;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
@Getter
@AllArgsConstructor
public class ClassTemplateModel {

    final private String name;

    protected ClassTemplateModel(ClassTemplateModel another) {
        name = another.name;
    }

    protected static abstract class ClassTemplateModelBuilder<M extends ClassTemplateModel, B extends ClassTemplateModelBuilder<M, B>> {

        private String name;

        protected abstract B self();

        public B name(String name) {
            this.name = name;
            return self();
        }

        public M build() {
            return build(new ClassTemplateModel(name));
        }

        protected abstract M build(ClassTemplateModel model);
    }
}
