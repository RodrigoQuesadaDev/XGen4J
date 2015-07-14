package com.rodrigodev.xgen.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet;

import com.rodrigodev.xgen.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.GuavaRootException.ExceptionType;
import com.google.common.base.Optional;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class ExceptionInfo {

    final private Class<? extends GuavaRootException> clazz;
    final private Optional<ExceptionType> type;

    private ExceptionInfo(Optional<ExceptionType> type, Class<? extends GuavaRootException> clazz) {
        this.type = type;
        this.clazz = clazz;
    }

    public ExceptionInfo(Class<? extends GuavaRootException> clazz) {
        this(Optional.absent(), clazz);
    }

    public ExceptionInfo(ExceptionType type, Class<? extends GuavaRootException> clazz) {
        this(Optional.of(type), clazz);
    }

    public Class<? extends GuavaRootException> clazz() {
        return clazz;
    }

    public Optional<ExceptionType> type() {
        return type;
    }
}
