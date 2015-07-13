package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified;

import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.ErrorInfo.PlainTextErrorDescription;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.ErrorInfo.CustomMessageGeneratorErrorDescription;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Autogenerated by XGen on July 13, 2015.
 */
public class Information {

    private static List<ErrorInfo> errorInfoList;
    private static Map<String, ErrorInfo> idToErrorInfoMap;
    private static Map<String, ErrorInfo> numericIdToErrorInfoMap;

    private static final AtomicBoolean loaded = new AtomicBoolean();

    private static void load() {
        if (loaded.compareAndSet(false, true)) {
            errorInfoList = new ArrayList<>();

            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.RootNameError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.RootNameException.class),
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.RootNameError.CODE,
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.CommonName1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.CommonName1Exception.class),
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.CommonName1Error.CODE,
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.CommonName2Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.CommonName2Exception.class),
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.CommonName2Error.CODE,
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.common_name3_1.CommonName3_1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.common_name3_1.CommonName3_1Exception.class),
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.common_name3_1.CommonName3_1Error.CODE,
                new PlainTextErrorDescription("ABCDE"),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.common_name3_2.CommonName3_2Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.common_name3_2.CommonName3_2Exception.class),
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.common_name3_2.CommonName3_2Error.CODE,
                new PlainTextErrorDescription("ABCDE"),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.common_name3_3.CommonName3_3Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.common_name3_3.CommonName3_3Exception.class),
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.common_name3_3.CommonName3_3Error.CODE,
                new PlainTextErrorDescription("ABCDE"),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.ErrorName1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.ErrorName1Exception.TYPE, com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.ErrorName1Exception.class),
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.ErrorName1Error.CODE,
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.ErrorName2Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.ErrorName2Exception.TYPE, com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.ErrorName2Exception.class),
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.ErrorName2Error.CODE,
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_1.ErrorName3_1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_1.ErrorName3_1Exception.TYPE, com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_1.ErrorName3_1Exception.class),
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_1.ErrorName3_1Error.CODE,
                new PlainTextErrorDescription("ABCDE"),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_2.ErrorName3_2Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_2.ErrorName3_2Exception.TYPE, com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_2.ErrorName3_2Exception.class),
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_2.ErrorName3_2Error.CODE,
                new PlainTextErrorDescription("ABCDE"),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_3.ErrorName3_3Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_3.ErrorName3_3Exception.TYPE, com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_3.ErrorName3_3Exception.class),
                com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_3.ErrorName3_3Error.CODE,
                new PlainTextErrorDescription("ABCDE"),
                false
            ));

            errorInfoList = Collections.unmodifiableList(errorInfoList);
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
