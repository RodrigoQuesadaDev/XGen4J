package com.rodrigodev.xgen4j_table_generator.model.information;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 15/07/15.
 */
public interface ErrorInfoWrapper {

    ExceptionInfoWrapper exceptionInfo();

    ErrorCodeWrapper code();

    Optional<ErrorDescriptionWrapper> description();

    default boolean isCommon() {
        return false;
    }
}
