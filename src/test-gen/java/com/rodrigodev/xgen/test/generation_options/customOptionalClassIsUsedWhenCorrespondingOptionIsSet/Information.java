package com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet;

import com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.ErrorInfo.PlainTextErrorDescription;
import com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.ErrorInfo.CustomMessageGeneratorErrorDescription;

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
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.CustomRootError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.CustomRootException.class),
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.CustomRootError.CODE,
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_c1.CustomC1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_c1.CustomC1Exception.class),
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_c1.CustomC1Error.CODE,
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_c1.custom_c2.CustomC2Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_c1.custom_c2.CustomC2Exception.class),
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_c1.custom_c2.CustomC2Error.CODE,
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_c1.custom_c2.custom_c3_1.CustomC3_1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_c1.custom_c2.custom_c3_1.CustomC3_1Exception.class),
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_c1.custom_c2.custom_c3_1.CustomC3_1Error.CODE,
                new PlainTextErrorDescription("Message for C3_1 error."),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_c1.custom_c2.custom_c3_2.CustomC3_2Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_c1.custom_c2.custom_c3_2.CustomC3_2Exception.class),
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_c1.custom_c2.custom_c3_2.CustomC3_2Error.CODE,
                new PlainTextErrorDescription("{param1: '%s', param2: %d, param3: '%s'}"),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_c1.custom_c2.custom_c3_3.CustomC3_3Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_c1.custom_c2.custom_c3_3.CustomC3_3Exception.class),
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_c1.custom_c2.custom_c3_3.CustomC3_3Error.CODE,
                new CustomMessageGeneratorErrorDescription<>(com.rodrigodev.xgen.test.common.doubles.error.message.TestMessageGeneratorObject.class),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.CustomE1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.CustomE1Exception.TYPE, com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.CustomE1Exception.class),
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.CustomE1Error.CODE,
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.custom_e2.CustomE2Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.custom_e2.CustomE2Exception.TYPE, com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.custom_e2.CustomE2Exception.class),
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.custom_e2.CustomE2Error.CODE,
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.custom_e2.custom_e3_1.CustomE3_1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.custom_e2.custom_e3_1.CustomE3_1Exception.TYPE, com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.custom_e2.custom_e3_1.CustomE3_1Exception.class),
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.custom_e2.custom_e3_1.CustomE3_1Error.CODE,
                new PlainTextErrorDescription("Message for E3_1 error."),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.custom_e2.custom_e3_2.CustomE3_2Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.custom_e2.custom_e3_2.CustomE3_2Exception.TYPE, com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.custom_e2.custom_e3_2.CustomE3_2Exception.class),
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.custom_e2.custom_e3_2.CustomE3_2Error.CODE,
                new PlainTextErrorDescription("{param1: '%s', param2: %d, param3: '%s'}"),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.custom_e2.custom_e3_3.CustomE3_3Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.custom_e2.custom_e3_3.CustomE3_3Exception.TYPE, com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.custom_e2.custom_e3_3.CustomE3_3Exception.class),
                com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.custom_e2.custom_e3_3.CustomE3_3Error.CODE,
                new CustomMessageGeneratorErrorDescription<>(com.rodrigodev.xgen.test.common.doubles.error.message.TestMessageGeneratorObject.class),
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
