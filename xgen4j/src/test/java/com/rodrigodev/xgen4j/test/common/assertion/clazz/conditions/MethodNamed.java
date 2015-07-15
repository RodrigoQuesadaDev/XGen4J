package com.rodrigodev.xgen4j.test.common.assertion.clazz.conditions;

import org.assertj.core.api.Condition;

import java.lang.reflect.Method;

/**
 * Created by Rodrigo Quesada on 14/07/15.
 */
public class MethodNamed extends Condition<Method> {

    private String name;

    public MethodNamed(String name) {
        this.name = name;
    }

    @Override
    public boolean matches(Method method) {
        return method.getName().equals(name);
    }
}
