package com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse;

import com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.U2RootException.ExceptionType;
import java.util.Optional;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class ExceptionInfo {

    final private Class<? extends U2RootException> clazz;
    final private Optional<ExceptionType> type;

    private ExceptionInfo(Optional<ExceptionType> type, Class<? extends U2RootException> clazz) {
        this.type = type;
        this.clazz = clazz;
    }

    public ExceptionInfo(Class<? extends U2RootException> clazz) {
        this(Optional.<ExceptionType>empty(), clazz);
    }

    public ExceptionInfo(ExceptionType type, Class<? extends U2RootException> clazz) {
        this(Optional.of(type), clazz);
    }

    public Class<? extends U2RootException> clazz() {
        return clazz;
    }

    public Optional<ExceptionType> type() {
        return type;
    }
}
