package com.rodrigodev.xgen.model.error.configuration;

import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 12/05/15.
 */
@Value
@Accessors(fluent = true)
public class ErrorCodeDefinition {

    public static final String DOT = ".";
    @NonNull private Optional<String> name;
    @NonNull private Optional<String> number;

    public ErrorCodeDefinition(@NonNull Optional<String> name, @NonNull Optional<String> number) {
        this.name = name;
        this.number = number;
    }

    public ErrorCodeDefinition withParent(ErrorCodeDefinition parentCode) {
        return parentCode.name.isPresent()
                ? new ErrorCodeDefinition(Optional.of(addParentName(parentCode.name().get())), parentCode.number())
                : this;
    }

    private String addParentName(String parentName) {
        return parentName + DOT + name.get();
    }
}
