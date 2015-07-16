package com.rodrigodev.xgen4j.test.organization.packages.basePackagePartsCanContain_LettersNumbersOrUnderscores_;

import com.rodrigodev.xgen4j.test.organization.packages.basePackagePartsCanContain_LettersNumbersOrUnderscores_.ErrorInfo.CustomMessageGeneratorErrorDescription;
import com.rodrigodev.xgen4j.test.organization.packages.basePackagePartsCanContain_LettersNumbersOrUnderscores_.ErrorInfo.PlainTextErrorDescription;

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
                    com.rodrigodev.xgen4j.test.organization.packages.basePackagePartsCanContain_LettersNumbersOrUnderscores_.RootError.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.organization.packages.basePackagePartsCanContain_LettersNumbersOrUnderscores_.RootException.class),
                    com.rodrigodev.xgen4j.test.organization.packages.basePackagePartsCanContain_LettersNumbersOrUnderscores_.RootError.CODE,
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
