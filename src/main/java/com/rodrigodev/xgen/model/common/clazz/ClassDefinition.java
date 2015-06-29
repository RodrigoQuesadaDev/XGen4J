package com.rodrigodev.xgen.model.common.clazz;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

import static com.google.common.base.Preconditions.*;
import static java.lang.Character.isJavaIdentifierStart;

/**
 * Created by Rodrigo Quesada on 20/06/15.
 */
@Accessors(fluent = true)
public abstract class ClassDefinition {

    public static final String DOT = ".";

    @NonNull @Getter private String name;
    @NonNull @Getter private String packagePath;

    public ClassDefinition(@NonNull String name, @NonNull String packagePath) {
        checkArgument(!name.isEmpty(), "name is empty");
        checkArgument(
                isJavaIdentifierStart(name.codePointAt(0))
                        && name.codePoints().allMatch(Character::isJavaIdentifierPart),
                "Class name contains invalid characters."
        );

        this.name = name;
        this.packagePath = packagePath;
    }

    public String fullyQualifiedName() {
        return packagePath + DOT + name;
    }
}
