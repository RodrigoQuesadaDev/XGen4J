package com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError;

import com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.ErrorInfo.CustomMessageGeneratorErrorDescription;
import com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.ErrorInfo.PlainTextErrorDescription;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class Information {

    private static List<ErrorInfo> errorInfoList;
    private static Map<String, ErrorInfo> idToErrorInfoMap;
    private static Map<String, ErrorInfo> numericIdToErrorInfoMap;

    private static final AtomicBoolean loaded = new AtomicBoolean();

    private static void load() {
        if (loaded.compareAndSet(false, true)) {
            errorInfoList = new ArrayList<>();
            idToErrorInfoMap = new HashMap<>();
            numericIdToErrorInfoMap = new HashMap<>();

            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.RootError.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.RootException.class),
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.RootError.CODE,
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.c1.C1Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.c1.C1Exception.class),
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.c1.C1Error.CODE,
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.c1.c2.C2Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.c1.c2.C2Exception.class),
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.c1.c2.C2Error.CODE,
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.c1.c2.c3.C3Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.c1.c2.c3.C3Exception.class),
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.c1.c2.c3.C3Error.CODE,
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.e1.E1Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.e1.E1Exception.TYPE, com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.e1.E1Exception.class),
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.e1.E1Error.CODE,
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.e1.e2.E2Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.e1.e2.E2Exception.TYPE, com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.e1.e2.E2Exception.class),
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.e1.e2.E2Error.CODE,
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.e1.e2.e3.E3Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.e1.e2.e3.E3Exception.TYPE, com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.e1.e2.e3.E3Exception.class),
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.e1.e2.e3.E3Error.CODE,
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.eb1.EB1Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.eb1.EB1Exception.TYPE, com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.eb1.EB1Exception.class),
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.eb1.EB1Error.CODE,
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.eb1.eb2.EB2Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.eb1.eb2.EB2Exception.TYPE, com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.eb1.eb2.EB2Exception.class),
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.eb1.eb2.EB2Error.CODE,
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.eb1.eb2.eb3.EB3Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.eb1.eb2.eb3.EB3Exception.TYPE, com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.eb1.eb2.eb3.EB3Exception.class),
                    com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.eb1.eb2.eb3.EB3Error.CODE,
                    false
            ));
            errorInfoList = Collections.unmodifiableList(errorInfoList);

            for (ErrorInfo errorInfo : errorInfoList) {
                idToErrorInfoMap.put(errorInfo.code().id(), errorInfo);
                numericIdToErrorInfoMap.put(errorInfo.code().numericId(), errorInfo);
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

    public static ErrorInfo forNumericId(String numericId) {
        if (numericId == null) throw new IllegalArgumentException("numericId");

        load();
        return numericIdToErrorInfoMap.get(numericId);
    }
}