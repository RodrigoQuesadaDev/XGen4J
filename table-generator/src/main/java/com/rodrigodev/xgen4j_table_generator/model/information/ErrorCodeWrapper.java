package com.rodrigodev.xgen4j_table_generator.model.information;

/**
 * Created by Rodrigo Quesada on 15/07/15.
 */
public interface ErrorCodeWrapper {

    String id();

    default String numericId() {
        return "";
    }
}
