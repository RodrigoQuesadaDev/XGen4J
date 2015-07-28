package com.rodrigodev.xgen4j.test.integration;

import com.rodrigodev.xgen4j.test.integration.HouseException.ExceptionType;
import java.util.Optional;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class ExceptionInfo {

    final private Class<? extends HouseException> clazz;
    final private Optional<ExceptionType> type;

    private ExceptionInfo(Optional<ExceptionType> type, Class<? extends HouseException> clazz) {
        this.type = type;
        this.clazz = clazz;
    }

    public ExceptionInfo(Class<? extends HouseException> clazz) {
        this(Optional.<ExceptionType>empty(), clazz);
    }

    public ExceptionInfo(ExceptionType type, Class<? extends HouseException> clazz) {
        this(Optional.of(type), clazz);
    }

    public Class<? extends HouseException> clazz() {
        return clazz;
    }

    public Optional<ExceptionType> type() {
        return type;
    }
}
