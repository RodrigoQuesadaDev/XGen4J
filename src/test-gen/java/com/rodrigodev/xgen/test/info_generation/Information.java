package com.rodrigodev.xgen.test.info_generation;

import com.rodrigodev.xgen.test.info_generation.ErrorInfo.PlainTextErrorDescription;
import com.rodrigodev.xgen.test.info_generation.ErrorInfo.CustomMessageGeneratorErrorDescription;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Autogenerated by XGen on July 12, 2015.
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
                com.rodrigodev.xgen.test.info_generation.RootError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.info_generation.RootException.class),
                com.rodrigodev.xgen.test.info_generation.RootError.CODE,
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.info_generation.c1.C1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.info_generation.c1.C1Exception.class),
                com.rodrigodev.xgen.test.info_generation.c1.C1Error.CODE,
                new PlainTextErrorDescription("Message for C1 error."),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.info_generation.c1.c2.C2Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.info_generation.c1.c2.C2Exception.class),
                com.rodrigodev.xgen.test.info_generation.c1.c2.C2Error.CODE,
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.info_generation.c1.c2.c3_1.C3_1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.info_generation.c1.c2.c3_1.C3_1Exception.class),
                com.rodrigodev.xgen.test.info_generation.c1.c2.c3_1.C3_1Error.CODE,
                new PlainTextErrorDescription("Message for C3_1 error."),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.info_generation.c1.c2.c3_2.C3_2Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.info_generation.c1.c2.c3_2.C3_2Exception.class),
                com.rodrigodev.xgen.test.info_generation.c1.c2.c3_2.C3_2Error.CODE,
                new PlainTextErrorDescription("C3_2: {param1: '%s', param2: %d, param3: '%s'}"),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.info_generation.c1.c2.c3_3.C3_3Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.info_generation.c1.c2.c3_3.C3_3Exception.class),
                com.rodrigodev.xgen.test.info_generation.c1.c2.c3_3.C3_3Error.CODE,
                new CustomMessageGeneratorErrorDescription<>(com.rodrigodev.xgen.test.info_generation.InfoGenerationTests.TestMessageGeneratorObject1.class),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.info_generation.ea1.EA1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.info_generation.ea1.EA1Exception.TYPE, com.rodrigodev.xgen.test.info_generation.ea1.EA1Exception.class),
                com.rodrigodev.xgen.test.info_generation.ea1.EA1Error.CODE,
                new PlainTextErrorDescription("Message for EA1 error."),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.info_generation.ea1.ea2.EA2Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.info_generation.ea1.ea2.EA2Exception.TYPE, com.rodrigodev.xgen.test.info_generation.ea1.ea2.EA2Exception.class),
                com.rodrigodev.xgen.test.info_generation.ea1.ea2.EA2Error.CODE,
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.info_generation.ea1.ea2.ea3_1.EA3_1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.info_generation.ea1.ea2.ea3_1.EA3_1Exception.TYPE, com.rodrigodev.xgen.test.info_generation.ea1.ea2.ea3_1.EA3_1Exception.class),
                com.rodrigodev.xgen.test.info_generation.ea1.ea2.ea3_1.EA3_1Error.CODE,
                new PlainTextErrorDescription("Message for EA3_1 error."),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.info_generation.ea1.ea2.ea3_2.EA3_2Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.info_generation.ea1.ea2.ea3_2.EA3_2Exception.TYPE, com.rodrigodev.xgen.test.info_generation.ea1.ea2.ea3_2.EA3_2Exception.class),
                com.rodrigodev.xgen.test.info_generation.ea1.ea2.ea3_2.EA3_2Error.CODE,
                new PlainTextErrorDescription("EA3_2: {param1: '%s', param2: %d, param3: '%s'}"),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.info_generation.ea1.ea2.ea3_3.EA3_3Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.info_generation.ea1.ea2.ea3_3.EA3_3Exception.TYPE, com.rodrigodev.xgen.test.info_generation.ea1.ea2.ea3_3.EA3_3Exception.class),
                com.rodrigodev.xgen.test.info_generation.ea1.ea2.ea3_3.EA3_3Error.CODE,
                new CustomMessageGeneratorErrorDescription<>(com.rodrigodev.xgen.test.info_generation.InfoGenerationTests.TestMessageGeneratorObject2.class),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.info_generation.eb1.EB1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.info_generation.eb1.EB1Exception.TYPE, com.rodrigodev.xgen.test.info_generation.eb1.EB1Exception.class),
                com.rodrigodev.xgen.test.info_generation.eb1.EB1Error.CODE,
                new PlainTextErrorDescription("Message for EB1 error."),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.info_generation.eb1.eb2.EB2Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.info_generation.eb1.eb2.EB2Exception.TYPE, com.rodrigodev.xgen.test.info_generation.eb1.eb2.EB2Exception.class),
                com.rodrigodev.xgen.test.info_generation.eb1.eb2.EB2Error.CODE,
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.info_generation.eb1.eb2.eb3_1.EB3_1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.info_generation.eb1.eb2.eb3_1.EB3_1Exception.TYPE, com.rodrigodev.xgen.test.info_generation.eb1.eb2.eb3_1.EB3_1Exception.class),
                com.rodrigodev.xgen.test.info_generation.eb1.eb2.eb3_1.EB3_1Error.CODE,
                new PlainTextErrorDescription("Message for EB3_1 error."),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.info_generation.eb1.eb2.eb3_2.EB3_2Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.info_generation.eb1.eb2.eb3_2.EB3_2Exception.TYPE, com.rodrigodev.xgen.test.info_generation.eb1.eb2.eb3_2.EB3_2Exception.class),
                com.rodrigodev.xgen.test.info_generation.eb1.eb2.eb3_2.EB3_2Error.CODE,
                new PlainTextErrorDescription("EB3_2: {param1: '%s', param2: %d, param3: '%s'}"),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.info_generation.eb1.eb2.eb3_3.EB3_3Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.info_generation.eb1.eb2.eb3_3.EB3_3Exception.TYPE, com.rodrigodev.xgen.test.info_generation.eb1.eb2.eb3_3.EB3_3Exception.class),
                com.rodrigodev.xgen.test.info_generation.eb1.eb2.eb3_3.EB3_3Error.CODE,
                new CustomMessageGeneratorErrorDescription<>(com.rodrigodev.xgen.test.info_generation.InfoGenerationTests.TestMessageGeneratorObject3.class),
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
