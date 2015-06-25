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
    @NonNull @Getter private String packagePath;

    public ClassDefinition(String name, String packagePath) {
        this.name = name;
        this.packagePath = packagePath;
    }

    public String fullyQualifiedName() {
        return packagePath + DOT + name;
    }
}
