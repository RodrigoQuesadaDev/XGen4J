package com.rodrigodev.xgen4j.test.throwing;

import com.rodrigodev.xgen4j.test.throwing.ErrorInfo.CustomMessageGeneratorErrorDescription;
import com.rodrigodev.xgen4j.test.throwing.ErrorInfo.PlainTextErrorDescription;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class Information {

    private static List<ErrorInfo> errorInfoList;
    private static Map<String, ErrorInfo> idToErrorInfoMap;

    private static final AtomicBoolean loaded = new AtomicBoolean();

    private static void load() {
        if (loaded.compareAndSet(false, true)) {
            errorInfoList = new ArrayList<>();
            idToErrorInfoMap = new HashMap<>();

            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.throwing.RootError.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.throwing.RootException.class),
                    com.rodrigodev.xgen4j.test.throwing.RootError.CODE,
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.throwing.c1.C1Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.throwing.c1.C1Exception.class),
                    com.rodrigodev.xgen4j.test.throwing.c1.C1Error.CODE,
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.throwing.c1.c2.C2Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.throwing.c1.c2.C2Exception.class),
                    com.rodrigodev.xgen4j.test.throwing.c1.c2.C2Error.CODE,
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_1.C3_1Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_1.C3_1Exception.class),
                    com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_1.C3_1Error.CODE,
                    new PlainTextErrorDescription("Message for C3_1 error."),
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_2.C3_2Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_2.C3_2Exception.class),
                    com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_2.C3_2Error.CODE,
                    new PlainTextErrorDescription("{param1: '%s', param2: %d, param3: '%s'}"),
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_3.C3_3Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_3.C3_3Exception.class),
                    com.rodrigodev.xgen4j.test.throwing.c1.c2.c3_3.C3_3Error.CODE,
                    new CustomMessageGeneratorErrorDescription<>(com.rodrigodev.xgen4j.test.common.doubles.error.message.TestMessageGeneratorObject.class),
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.throwing.e1.E1Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.throwing.e1.E1Exception.TYPE, com.rodrigodev.xgen4j.test.throwing.e1.E1Exception.class),
                    com.rodrigodev.xgen4j.test.throwing.e1.E1Error.CODE,
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.throwing.e1.e2.E2Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.throwing.e1.e2.E2Exception.TYPE, com.rodrigodev.xgen4j.test.throwing.e1.e2.E2Exception.class),
                    com.rodrigodev.xgen4j.test.throwing.e1.e2.E2Error.CODE,
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_1.E3_1Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_1.E3_1Exception.TYPE, com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_1.E3_1Exception.class),
                    com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_1.E3_1Error.CODE,
                    new PlainTextErrorDescription("Message for E3_1 error."),
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_2.E3_2Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_2.E3_2Exception.TYPE, com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_2.E3_2Exception.class),
                    com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_2.E3_2Error.CODE,
                    new PlainTextErrorDescription("{param1: '%s', param2: %d, param3: '%s'}"),
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_3.E3_3Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_3.E3_3Exception.TYPE, com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_3.E3_3Exception.class),
                    com.rodrigodev.xgen4j.test.throwing.e1.e2.e3_3.E3_3Error.CODE,
                    new CustomMessageGeneratorErrorDescription<>(com.rodrigodev.xgen4j.test.common.doubles.error.message.TestMessageGeneratorObject.class),
                    false
            ));
            errorInfoList = Collections.unmodifiableList(errorInfoList);

            for (ErrorInfo errorInfo : errorInfoList) {
                idToErrorInfoMap.put(errorInfo.code().id(), errorInfo);
            }

            loaded.set(true);
        }
    }

    public static List<ErrorInfo> list() {
        load();
        return errorInfoList;
    }

    public static ErrorInfo forId(String id) {
        if (id == null) throw new IllegalArgumentException("id");

        load();
        return idToErrorInfoMap.get(id);
    }

}