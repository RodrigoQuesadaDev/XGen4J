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
    @NonNull private String nameSuffix;
    @NonNull @Getter private String packagePath;

    public ClassDefinition(String baseName, String nameSuffix, String basePackage) {
        this.baseName = baseName;
        this.nameSuffix = nameSuffix;
        this.packagePath = basePackage;
        init();
    }

    private void init() {
        name = generateName();
    }

    private String generateName() {
        return baseName + nameSuffix;
    }

    public String fullQualifiedName() {
        return packagePath + DOT + name;
    }
}
