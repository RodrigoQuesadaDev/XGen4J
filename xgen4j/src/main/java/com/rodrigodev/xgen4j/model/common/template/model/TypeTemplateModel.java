package com.rodrigodev.xgen4j.model.common.template.model;

import com.rodrigodev.xgen4j.model.common.clazz.ClassDefinition;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 24/06/15.
 */
@Value
@NonFinal
public class TypeTemplateModel {

    private String packagePath;
    private String name;
    private String canonicalName;

    private TypeTemplateModel(
            @NonNull Optional<String> packagePath, @NonNull String name, @NonNull String canonicalName
    ) {
        this.packagePath = packagePath.orElse(null);
        this.name = name;
        this.canonicalName = canonicalName;
    }

    public TypeTemplateModel(@NonNull TypeTemplateModel another) {
        this(Optional.ofNullable(another.packagePath), another.name, another.canonicalName);
    }

    public TypeTemplateModel(String packagePath, String name, String canonicalName) {
        this(Optional.of(packagePath), name, canonicalName);
    }

    public TypeTemplateModel(String name, String canonicalName) {
        this(Optional.empty(), name, canonicalName);
    }

    public TypeTemplateModel(Class<?> type) {
        this(type.getPackage().getName(), type.getSimpleName(), type.getCanonicalName());
    }

    public TypeTemplateModel(ClassDefinition classDefinition) {
        this(classDefinition.packagePath(), classDefinition.name(), classDefinition.fullyQualifiedName());
    }

    @Override
    final public int hashCode() {
        return canonicalName.hashCode();
    }

    @Override
    final public boolean equals(Object o) {
        return o instanceof TypeTemplateModel && canonicalName.equals(((TypeTemplateModel) o).canonicalName);
    }
}
