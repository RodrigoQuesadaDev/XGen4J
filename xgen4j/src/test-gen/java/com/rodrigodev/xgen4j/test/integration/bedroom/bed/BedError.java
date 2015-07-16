package com.rodrigodev.xgen4j.test.integration.bedroom.bed;

import com.rodrigodev.xgen4j.test.integration.bedroom.BedroomError;

import java.lang.String;

import com.rodrigodev.xgen4j.test.integration.ErrorCode;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class BedError extends BedroomError {

    public static final ErrorCode CODE = new ErrorCode("bed", BedroomError.CODE);

    private static String MESSAGE_FORMAT = "This bed is freaking bad. Model: %s";

    private static String createMessage(String model) {
        if(model == null) throw new NullPointerException("model");

        return String.format(MESSAGE_FORMAT, model);
    }

    public static void throwException(String model) {
        throw new BedException(createMessage(model));
    }

    public static void throwException(String model, Throwable cause) {
        throw new BedException(createMessage(model), cause);
    }


}