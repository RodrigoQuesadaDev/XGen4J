package com.rodrigodev.xgen.model.error.configuration.definition.description;

import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static com.google.common.base.Preconditions.*;

/**
 * Created by Rodrigo Quesada on 02/07/15.
 */
@Value
@Accessors(fluent = true)
public class CustomMessageGeneratorDefinition {

    private static final String MESSAGE_METHOD_NAME = "message";

    @NonNull private Class<?> type;
    @NonNull private String name;

    public CustomMessageGeneratorDefinition(Class<?> type, String name) {
        checkArgument(typeHasMessageMethod(type),
                      "Custom message generator doesn't implement a non-private 'message' method.");

        this.type = type;
        this.name = name;
    }

    private static boolean typeHasMessageMethod(Class<?> type) {
        Method messageMethod = null;
        try {
            messageMethod = type.getMethod(MESSAGE_METHOD_NAME);
        }
        catch (Exception e) {
        }
        return messageMethod != null && !Modifier.isPrivate(messageMethod.getModifiers());
    }
}
