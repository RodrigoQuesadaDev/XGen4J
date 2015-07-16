package com.rodrigodev.xgen4j_table_generator.model.information;

/**
 * Created by Rodrigo Quesada on 15/07/15.
 */
public interface ErrorDescriptionWrapper {

    Object description();

    default boolean usesCustomMessageGenerator() {
        return false;
    }
}
