package com.rodrigodev.xgen4j.test.organization.hierarchy;

import com.rodrigodev.xgen4j.test.organization.hierarchy.RootException.ExceptionType;
import java.util.Optional;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class ExceptionInfo {

    final private Class<? extends RootException> clazz;
    final private Optional<ExceptionType> type;

    private ExceptionInfo(Optional<ExceptionType> type, Class<? extends RootException> clazz) {
        this.type = type;
        this.clazz = clazz;
    }

    public ExceptionInfo(Class<? extends RootException> clazz) {
        this(Optional.empty(), clazz);
    }

    public ExceptionInfo(ExceptionType type, Class<? extends RootException> clazz) {
        this(Optional.of(type), clazz);
    }

    public Class<? extends RootException> clazz() {
        return clazz;
    }

    public Optional<ExceptionType> type() {
        return type;
    }
}
