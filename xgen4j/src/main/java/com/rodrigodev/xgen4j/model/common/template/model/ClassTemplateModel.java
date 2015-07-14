package com.rodrigodev.xgen4j.model.common.template.model;

import com.rodrigodev.xgen4j.model.common.clazz.ClassDefinition;
import com.rodrigodev.xgen4j.service.time.TimeService;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

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

    private ClassTemplateModel(
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
        this.currentDate = DATE_TIME_FORMATTER.format(inj.timeService.now());
    }

    protected ClassTemplateModel(@NonNull ClassTemplateModelBuilder builder) {
        this(builder.injectedFields, builder.name, builder.packagePath, builder.parent);
    }

    @Setter
    @Accessors(fluent = true)
    public static abstract class ClassTemplateModelBuilder<M extends ClassTemplateModel, B extends ClassTemplateModelBuilder<M, B>> {

        private InjectedFields injectedFields;
        private String name;
        private String packagePath;
        private ClassDefinition parent;

        public abstract M build();
    }
}
