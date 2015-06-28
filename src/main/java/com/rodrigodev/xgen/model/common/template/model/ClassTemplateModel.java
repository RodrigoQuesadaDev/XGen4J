package com.rodrigodev.xgen.model.common.template.model;

import com.rodrigodev.xgen.model.common.clazz.ClassDefinition;
import com.rodrigodev.xgen.service.time.TimeService;
import lombok.Getter;
import lombok.NonNull;

import javax.inject.Inject;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
@Getter
public class ClassTemplateModel {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);

    public static class InjectedFields {

        @Inject TimeService timeService;

        @Inject
        public InjectedFields() {
        }
    }

    @NonNull private InjectedFields inj;
    @NonNull final private String name;
    @NonNull final private String packagePath;
    final private TypeTemplateModel parent;
    private String currentDate;

    public ClassTemplateModel(
            @NonNull InjectedFields injectedFields,
            @NonNull String name,
            @NonNull String packagePath,
            ClassDefinition parentClassDefinition
    ) {
        this.inj = injectedFields;
        this.name = name;
        this.packagePath = packagePath;
        this.parent = parentClassDefinition != null
                ? new TypeTemplateModel(parentClassDefinition.name(), parentClassDefinition.fullyQualifiedName())
                : null;
    }

    protected ClassTemplateModel(@NonNull ClassTemplateModel another) {
        inj = another.inj;
        name = another.name;
        packagePath = another.packagePath;
        parent = another.parent;
        this.currentDate = DATE_TIME_FORMATTER.format(inj.timeService.now());
    }

    public static abstract class ClassTemplateModelBuilder<M extends ClassTemplateModel, B extends ClassTemplateModelBuilder> {

        private InjectedFields injectedFields;
        private String name;
        private String packagePath;
        private ClassDefinition parent;

        protected abstract B self();

        public B injectedFields(InjectedFields injectedFields) {
            this.injectedFields = injectedFields;
            return self();
        }

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
            return build(new ClassTemplateModel(injectedFields, name, packagePath, parent));
        }

        protected abstract M build(ClassTemplateModel model);
    }
}
