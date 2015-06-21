package com.rodrigodev.xgen.writer.template;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

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

    protected static abstract class ClassTemplateModelBuilder<B extends ClassTemplateModel> {

        private String name;

        protected abstract ClassTemplateModelBuilder<B> self();

        public ClassTemplateModelBuilder<B> name(String name) {
            this.name = name;
            return self();
        }

        public B build() {
            return build(new ClassTemplateModel(name));
        }

        protected abstract B build(ClassTemplateModel model);
    }
}
