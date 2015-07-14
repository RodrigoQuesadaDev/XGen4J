package com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases;

import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases.ErrorInfo.PlainTextErrorDescription;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases.ErrorInfo.CustomMessageGeneratorErrorDescription;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Autogenerated by XGen on January 1, 0001.
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
                com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases.Root_name12Error.class,
                new ExceptionInfo(com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases.Root_name12Exception.class),
                com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases.Root_name12Error.CODE,
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
