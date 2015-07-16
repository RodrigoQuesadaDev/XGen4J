package com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation;

import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.ErrorInfo.CustomMessageGeneratorErrorDescription;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.ErrorInfo.PlainTextErrorDescription;

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
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.RootNameError.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.RootNameException.class),
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.RootNameError.CODE,
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.C1Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.C1Exception.class),
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.C1Error.CODE,
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.CommonName2Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.CommonName2Exception.class),
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.CommonName2Error.CODE,
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.common_name3_1.CommonName3_1Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.common_name3_1.CommonName3_1Exception.class),
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.common_name3_1.CommonName3_1Error.CODE,
                    new PlainTextErrorDescription("ABCDE"),
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.c3_2.C3_2Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.c3_2.C3_2Exception.class),
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.c3_2.C3_2Error.CODE,
                    new PlainTextErrorDescription("ABCDE"),
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.common_name3_3.CommonName3_3Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.common_name3_3.CommonName3_3Exception.class),
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.common_name3_3.CommonName3_3Error.CODE,
                    new PlainTextErrorDescription("ABCDE"),
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.E1Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.E1Exception.TYPE, com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.E1Exception.class),
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.E1Error.CODE,
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.ErrorName2Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.ErrorName2Exception.TYPE, com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.ErrorName2Exception.class),
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.ErrorName2Error.CODE,
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.error_name3_1.ErrorName3_1Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.error_name3_1.ErrorName3_1Exception.TYPE, com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.error_name3_1.ErrorName3_1Exception.class),
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.error_name3_1.ErrorName3_1Error.CODE,
                    new PlainTextErrorDescription("ABCDE"),
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.e3_2.E3_2Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.e3_2.E3_2Exception.TYPE, com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.e3_2.E3_2Exception.class),
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.e3_2.E3_2Error.CODE,
                    new PlainTextErrorDescription("ABCDE"),
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.error_name3_3.ErrorName3_3Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.error_name3_3.ErrorName3_3Exception.TYPE, com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.error_name3_3.ErrorName3_3Exception.class),
                    com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.error_name3_3.ErrorName3_3Error.CODE,
                    new PlainTextErrorDescription("ABCDE"),
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
