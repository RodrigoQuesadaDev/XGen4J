package com.rodrigodev.xgen.test.naming.errorNameCanBeginWithUpperCaseLetter;

import com.rodrigodev.xgen.test.naming.errorNameCanBeginWithUpperCaseLetter.ErrorInfo.PlainTextErrorDescription;
import com.rodrigodev.xgen.test.naming.errorNameCanBeginWithUpperCaseLetter.ErrorInfo.CustomMessageGeneratorErrorDescription;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Autogenerated by XGen on July 11, 2015.
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
                com.rodrigodev.xgen.test.naming.errorNameCanBeginWithUpperCaseLetter.RootNameError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.naming.errorNameCanBeginWithUpperCaseLetter.RootNameException.class),
                com.rodrigodev.xgen.test.naming.errorNameCanBeginWithUpperCaseLetter.RootNameError.CODE,
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