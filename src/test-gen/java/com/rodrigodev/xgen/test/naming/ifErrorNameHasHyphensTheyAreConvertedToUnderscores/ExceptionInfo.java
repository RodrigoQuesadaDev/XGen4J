package com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores;

import com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores.Root_name7Exception.ExceptionType;
import java.util.Optional;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class ExceptionInfo {

    final private Class<? extends Root_name7Exception> clazz;
    final private Optional<ExceptionType> type;

    private ExceptionInfo(Optional<ExceptionType> type, Class<? extends Root_name7Exception> clazz) {
        this.type = type;
        this.clazz = clazz;
    }

    public ExceptionInfo(Class<? extends Root_name7Exception> clazz) {
        this(Optional.empty(), clazz);
    }

    public ExceptionInfo(ExceptionType type, Class<? extends Root_name7Exception> clazz) {
        this(Optional.of(type), clazz);
    }

    public Class<? extends Root_name7Exception> clazz() {
        return clazz;
    }

    public Optional<ExceptionType> type() {
        return type;
    }
}
