package com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed;

import com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.ErrorInfo.CustomMessageGeneratorErrorDescription;
import com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.ErrorInfo.PlainTextErrorDescription;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Autogenerated by XGen4J on January 1, 0001.
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
                    com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.RootError.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.RootException.class),
                    com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.RootError.CODE,
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.c1.C1Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.c1.C1Exception.class),
                    com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.c1.C1Error.CODE,
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.c1.c2.C2Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.c1.c2.C2Exception.class),
                    com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.c1.c2.C2Error.CODE,
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.c1.c2.c3.C3Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.c1.c2.c3.C3Exception.class),
                    com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.c1.c2.c3.C3Error.CODE,
                    new PlainTextErrorDescription("Some description."),
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.e1.E1Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.e1.E1Exception.TYPE, com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.e1.E1Exception.class),
                    com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.e1.E1Error.CODE,
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.e1.e2.E2Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.e1.e2.E2Exception.TYPE, com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.e1.e2.E2Exception.class),
                    com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.e1.e2.E2Error.CODE,
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.e1.e2.e3.E3Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.e1.e2.e3.E3Exception.TYPE, com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.e1.e2.e3.E3Exception.class),
                    com.rodrigodev.xgen4j.test.message.descriptionWithNoParamsIsAllowed.e1.e2.e3.E3Error.CODE,
                    new PlainTextErrorDescription("Some description."),
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
