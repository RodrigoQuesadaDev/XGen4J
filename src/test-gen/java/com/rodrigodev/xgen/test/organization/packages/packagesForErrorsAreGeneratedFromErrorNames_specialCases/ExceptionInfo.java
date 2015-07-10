package com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases;

import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.RootNameException.ExceptionType;

import java.util.Optional;

/**
 * Autogenerated by XGen on July 11, 2015.
 */
public class ExceptionInfo {

    final private Class<? extends RootNameException> clazz;
    final private Optional<ExceptionType> type;

    private ExceptionInfo(Optional<ExceptionType> type, Class<? extends RootNameException> clazz) {
        this.type = type;
        this.clazz = clazz;
    }

    public ExceptionInfo(Class<? extends RootNameException> clazz) {
        this(Optional.empty(), clazz);
    }

    public ExceptionInfo(ExceptionType type, Class<? extends RootNameException> clazz) {
        this(Optional.of(type), clazz);
    }

    public Class<? extends RootNameException> clazz() {
        return clazz;
    }

    public Optional<ExceptionType> type() {
        return type;
    }
}
