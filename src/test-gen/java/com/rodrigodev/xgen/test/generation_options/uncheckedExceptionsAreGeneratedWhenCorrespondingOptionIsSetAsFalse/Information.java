package com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse;

import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.ErrorInfo.PlainTextErrorDescription;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.ErrorInfo.CustomMessageGeneratorErrorDescription;

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
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.U2RootError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.U2RootException.class),
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.U2RootError.CODE,
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2c1.U2C1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2c1.U2C1Exception.class),
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2c1.U2C1Error.CODE,
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2c1.u2c2.U2C2Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2c1.u2c2.U2C2Exception.class),
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2c1.u2c2.U2C2Error.CODE,
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2c1.u2c2.u2c3_1.U2C3_1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2c1.u2c2.u2c3_1.U2C3_1Exception.class),
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2c1.u2c2.u2c3_1.U2C3_1Error.CODE,
                new PlainTextErrorDescription("Message for C3_1 error."),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2c1.u2c2.u2c3_2.U2C3_2Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2c1.u2c2.u2c3_2.U2C3_2Exception.class),
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2c1.u2c2.u2c3_2.U2C3_2Error.CODE,
                new PlainTextErrorDescription("{param1: '%s', param2: %d, param3: '%s'}"),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2c1.u2c2.u2c3_3.U2C3_3Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2c1.u2c2.u2c3_3.U2C3_3Exception.class),
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2c1.u2c2.u2c3_3.U2C3_3Error.CODE,
                new CustomMessageGeneratorErrorDescription<>(com.rodrigodev.xgen.test.common.doubles.error.message.TestMessageGeneratorObject.class),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.U2E1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.U2E1Exception.TYPE, com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.U2E1Exception.class),
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.U2E1Error.CODE,
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.U2E2Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.U2E2Exception.TYPE, com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.U2E2Exception.class),
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.U2E2Error.CODE,
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_1.U2E3_1Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_1.U2E3_1Exception.TYPE, com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_1.U2E3_1Exception.class),
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_1.U2E3_1Error.CODE,
                new PlainTextErrorDescription("Message for E3_1 error."),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_2.U2E3_2Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_2.U2E3_2Exception.TYPE, com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_2.U2E3_2Exception.class),
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_2.U2E3_2Error.CODE,
                new PlainTextErrorDescription("{param1: '%s', param2: %d, param3: '%s'}"),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_3.U2E3_3Error.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_3.U2E3_3Exception.TYPE, com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_3.U2E3_3Exception.class),
                com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_3.U2E3_3Error.CODE,
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
