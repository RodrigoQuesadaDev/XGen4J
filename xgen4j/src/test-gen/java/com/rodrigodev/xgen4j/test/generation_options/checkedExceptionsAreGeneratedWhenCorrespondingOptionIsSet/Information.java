package com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet;

import com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ErrorInfo.CustomMessageGeneratorErrorDescription;
import com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ErrorInfo.PlainTextErrorDescription;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Autogenerated by XGen on January 1, 0001.
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
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.CRootError.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.CRootException.class),
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.CRootError.CODE,
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.cc1.CC1Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.cc1.CC1Exception.class),
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.cc1.CC1Error.CODE,
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.cc1.cc2.CC2Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.cc1.cc2.CC2Exception.class),
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.cc1.cc2.CC2Error.CODE,
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.cc1.cc2.cc3_1.CC3_1Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.cc1.cc2.cc3_1.CC3_1Exception.class),
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.cc1.cc2.cc3_1.CC3_1Error.CODE,
                    new PlainTextErrorDescription("Message for C3_1 error."),
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.cc1.cc2.cc3_2.CC3_2Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.cc1.cc2.cc3_2.CC3_2Exception.class),
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.cc1.cc2.cc3_2.CC3_2Error.CODE,
                    new PlainTextErrorDescription("{param1: '%s', param2: %d, param3: '%s'}"),
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.cc1.cc2.cc3_3.CC3_3Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.cc1.cc2.cc3_3.CC3_3Exception.class),
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.cc1.cc2.cc3_3.CC3_3Error.CODE,
                    new CustomMessageGeneratorErrorDescription<>(com.rodrigodev.xgen4j.test.common.doubles.error.message.TestMessageGeneratorObject.class),
                    true
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.CE1Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.CE1Exception.TYPE, com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.CE1Exception.class),
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.CE1Error.CODE,
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.CE2Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.CE2Exception.TYPE, com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.CE2Exception.class),
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.CE2Error.CODE,
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.ce3_1.CE3_1Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.ce3_1.CE3_1Exception.TYPE, com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.ce3_1.CE3_1Exception.class),
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.ce3_1.CE3_1Error.CODE,
                    new PlainTextErrorDescription("Message for E3_1 error."),
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.ce3_2.CE3_2Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.ce3_2.CE3_2Exception.TYPE, com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.ce3_2.CE3_2Exception.class),
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.ce3_2.CE3_2Error.CODE,
                    new PlainTextErrorDescription("{param1: '%s', param2: %d, param3: '%s'}"),
                    false
            ));
            errorInfoList.add(new ErrorInfo(
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.ce3_3.CE3_3Error.class,
                    new ExceptionInfo(com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.ce3_3.CE3_3Exception.TYPE, com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.ce3_3.CE3_3Exception.class),
                    com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.ce3_3.CE3_3Error.CODE,
                    new CustomMessageGeneratorErrorDescription<>(com.rodrigodev.xgen4j.test.common.doubles.error.message.TestMessageGeneratorObject.class),
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
