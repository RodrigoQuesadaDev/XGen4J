package com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet;

import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.URootException.ExceptionType;

import java.util.Optional;

/**
 * Autogenerated by XGen on July 12, 2015.
 */
public class ExceptionInfo {

    final private Class<? extends URootException> clazz;
    final private Optional<ExceptionType> type;

    private ExceptionInfo(Optional<ExceptionType> type, Class<? extends URootException> clazz) {
        this.type = type;
        this.clazz = clazz;
    }

    public ExceptionInfo(Class<? extends URootException> clazz) {
        this(Optional.empty(), clazz);
    }

    public ExceptionInfo(ExceptionType type, Class<? extends URootException> clazz) {
        this(Optional.of(type), clazz);
    }

    public Class<? extends URootException> clazz() {
        return clazz;
    }

    public Optional<ExceptionType> type() {
        return type;
    }
}