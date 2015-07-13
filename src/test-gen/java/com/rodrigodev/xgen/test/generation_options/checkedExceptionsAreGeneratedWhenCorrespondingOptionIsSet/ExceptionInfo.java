package com.rodrigodev.xgen.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet;

import com.rodrigodev.xgen.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.CRootException.ExceptionType;

import java.util.Optional;

/**
 * Autogenerated by XGen on July 13, 2015.
 */
public class ExceptionInfo {

    final private Class<? extends CRootException> clazz;
    final private Optional<ExceptionType> type;

    private ExceptionInfo(Optional<ExceptionType> type, Class<? extends CRootException> clazz) {
        this.type = type;
        this.clazz = clazz;
    }

    public ExceptionInfo(Class<? extends CRootException> clazz) {
        this(Optional.empty(), clazz);
    }

    public ExceptionInfo(ExceptionType type, Class<? extends CRootException> clazz) {
        this(Optional.of(type), clazz);
    }

    public Class<? extends CRootException> clazz() {
        return clazz;
    }

    public Optional<ExceptionType> type() {
        return type;
    }
}
