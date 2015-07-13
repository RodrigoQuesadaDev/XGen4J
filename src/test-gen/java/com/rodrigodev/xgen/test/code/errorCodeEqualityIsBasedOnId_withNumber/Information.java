package com.rodrigodev.xgen.test.code.errorCodeEqualityIsBasedOnId_withNumber;

import com.rodrigodev.xgen.test.code.errorCodeEqualityIsBasedOnId_withNumber.ErrorInfo.PlainTextErrorDescription;
import com.rodrigodev.xgen.test.code.errorCodeEqualityIsBasedOnId_withNumber.ErrorInfo.CustomMessageGeneratorErrorDescription;

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
                com.rodrigodev.xgen.test.code.errorCodeEqualityIsBasedOnId_withNumber.BRootError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.code.errorCodeEqualityIsBasedOnId_withNumber.BRootException.class),
                com.rodrigodev.xgen.test.code.errorCodeEqualityIsBasedOnId_withNumber.BRootError.CODE,
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.code.errorCodeEqualityIsBasedOnId_withNumber.bc1.BC1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.code.errorCodeEqualityIsBasedOnId_withNumber.bc1.BC1Exception.class),
                com.rodrigodev.xgen.test.code.errorCodeEqualityIsBasedOnId_withNumber.bc1.BC1Error.CODE,
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.code.errorCodeEqualityIsBasedOnId_withNumber.bc1.bc2.BC2Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.code.errorCodeEqualityIsBasedOnId_withNumber.bc1.bc2.BC2Exception.class),
                com.rodrigodev.xgen.test.code.errorCodeEqualityIsBasedOnId_withNumber.bc1.bc2.BC2Error.CODE,
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.code.errorCodeEqualityIsBasedOnId_withNumber.bc1.bc2.bc3_1.BC3_1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.code.errorCodeEqualityIsBasedOnId_withNumber.bc1.bc2.bc3_1.BC3_1Exception.class),
                com.rodrigodev.xgen.test.code.errorCodeEqualityIsBasedOnId_withNumber.bc1.bc2.bc3_1.BC3_1Error.CODE,
                true
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
