package com.rodrigodev.xgen.test.code.errorCodeEqualityIsBasedOnId_onlyName;

import com.rodrigodev.xgen.test.code.errorCodeEqualityIsBasedOnId_onlyName.ARootException.ExceptionType;

import java.util.Optional;

/**
 * Autogenerated by XGen on July 12, 2015.
 */
public class ExceptionInfo {

    final private Class<? extends ARootException> clazz;
    final private Optional<ExceptionType> type;

    private ExceptionInfo(Optional<ExceptionType> type, Class<? extends ARootException> clazz) {
        this.type = type;
        this.clazz = clazz;
    }

    public ExceptionInfo(Class<? extends ARootException> clazz) {
        this(Optional.empty(), clazz);
    }

    public ExceptionInfo(ExceptionType type, Class<? extends ARootException> clazz) {
        this(Optional.of(type), clazz);
    }

    public Class<? extends ARootException> clazz() {
        return clazz;
    }

    public Optional<ExceptionType> type() {
        return type;
    }
}
