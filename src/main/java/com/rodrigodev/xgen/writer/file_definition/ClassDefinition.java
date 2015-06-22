package com.rodrigodev.xgen.writer.file_definition;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
@Accessors(fluent = true)
public abstract class ClassDefinition {

    public static final String DOT = ".";

    @NonNull @Getter private String name;
    @NonNull private String baseName;

    @NonNull @Getter private String packagePath;

    public ClassDefinition(String name, String basePackage) {
        this.name = name;
        this.packagePath = basePackage;
    }

    public String fullQualifiedName() {
        return packagePath + DOT + name;
    }
}
