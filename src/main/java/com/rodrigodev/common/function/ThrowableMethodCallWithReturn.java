package com.rodrigodev.common.function;

/**
 * Created by Rodrigo Quesada on 12/04/15.
 */
@FunctionalInterface
public interface ThrowableMethodCallWithReturn<T> {

    T call() throws Throwable;
}