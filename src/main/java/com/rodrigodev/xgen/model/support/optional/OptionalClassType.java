package com.rodrigodev.xgen.model.support.optional;

import lombok.NonNull;

import java.util.Optional;

import static com.google.common.base.Preconditions.*;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
public enum OptionalClassType {
    JAVA_8(Optional.class, "empty"),
    GUAVA(com.google.common.base.Optional.class, "absent"),
    CUSTOM("Optional", "empty");

    private static final String DOT = ".";

    private Optional<Class<?>> type;
    private Optional<String> typeName;
    private String emptyMethodName;

    OptionalClassType(
            @NonNull Optional<Class<?>> type,
            @NonNull Optional<String> typeName,
            @NonNull String emptyMethodName
    ) {
        this.type = type;
        this.typeName = typeName;
        this.emptyMethodName = emptyMethodName;
    }

    OptionalClassType(Class<?> type, String emptyMethodName) {
        this(Optional.of(type), Optional.empty(), emptyMethodName);
    }

    OptionalClassType(String typeName, String emptyMethodName) {
        this(Optional.empty(), Optional.of(typeName), emptyMethodName);
    }

    public Optional<Class<?>> type() {
        return type;
    }

    public String typeName() {
        checkState(typeName.isPresent(), "typeName is not present");

        return typeName.get();
    }

    public String customCanonicalName(String packagePath) {
        return packagePath + DOT + typeName();
    }

    public String emptyMethodName() {
        return emptyMethodName;
    }
}
