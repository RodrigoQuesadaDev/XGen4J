package com.rodrigodev.xgen4j.test.info_generation.methodForRetrievingErrorInfoByItsNumericIdIsNotGeneratedWhenErrorCodeDoesNotHaveNumericId;

import com.rodrigodev.xgen4j.test.info_generation.methodForRetrievingErrorInfoByItsNumericIdIsNotGeneratedWhenErrorCodeDoesNotHaveNumericId.ErrorInfo.CustomMessageGeneratorErrorDescription;
import com.rodrigodev.xgen4j.test.info_generation.methodForRetrievingErrorInfoByItsNumericIdIsNotGeneratedWhenErrorCodeDoesNotHaveNumericId.ErrorInfo.PlainTextErrorDescription;

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
                    com.rodrigodev.xgen4j.test.info_generation.methodForRetrievingErrorInfoByItsNumericIdIsNotGeneratedWhenErrorCodeDoesNotHaveNumericId.RootError.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.info_generation.methodForRetrievingErrorInfoByItsNumericIdIsNotGeneratedWhenErrorCodeDoesNotHaveNumericId.RootException.class),
                    com.rodrigodev.xgen4j.test.info_generation.methodForRetrievingErrorInfoByItsNumericIdIsNotGeneratedWhenErrorCodeDoesNotHaveNumericId.RootError.CODE,
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.info_generation.methodForRetrievingErrorInfoByItsNumericIdIsNotGeneratedWhenErrorCodeDoesNotHaveNumericId.c1.C1Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.info_generation.methodForRetrievingErrorInfoByItsNumericIdIsNotGeneratedWhenErrorCodeDoesNotHaveNumericId.c1.C1Exception.class),
                    com.rodrigodev.xgen4j.test.info_generation.methodForRetrievingErrorInfoByItsNumericIdIsNotGeneratedWhenErrorCodeDoesNotHaveNumericId.c1.C1Error.CODE,
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.info_generation.methodForRetrievingErrorInfoByItsNumericIdIsNotGeneratedWhenErrorCodeDoesNotHaveNumericId.c1.c2.C2Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.info_generation.methodForRetrievingErrorInfoByItsNumericIdIsNotGeneratedWhenErrorCodeDoesNotHaveNumericId.c1.c2.C2Exception.class),
                    com.rodrigodev.xgen4j.test.info_generation.methodForRetrievingErrorInfoByItsNumericIdIsNotGeneratedWhenErrorCodeDoesNotHaveNumericId.c1.c2.C2Error.CODE,
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.info_generation.methodForRetrievingErrorInfoByItsNumericIdIsNotGeneratedWhenErrorCodeDoesNotHaveNumericId.c1.c2.c3_1.C3_1Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.info_generation.methodForRetrievingErrorInfoByItsNumericIdIsNotGeneratedWhenErrorCodeDoesNotHaveNumericId.c1.c2.c3_1.C3_1Exception.class),
                    com.rodrigodev.xgen4j.test.info_generation.methodForRetrievingErrorInfoByItsNumericIdIsNotGeneratedWhenErrorCodeDoesNotHaveNumericId.c1.c2.c3_1.C3_1Error.CODE,
                    new PlainTextErrorDescription("ABCDE"),
                    true
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
