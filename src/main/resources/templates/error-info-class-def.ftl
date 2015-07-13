package ${packagePath};

import ${optionalType.canonicalName};

/**
 * Autogenerated by XGen on ${currentDate}.
 */
public class ${name} {

    final private Class<? extends ${rootError.name}> clazz;
    final private ExceptionInfo exceptionInfo;
    final private ErrorCode code;
    final private Optional<ErrorDescription> description;
    final private boolean isCommon;

    private ${name}(
            Class<? extends ${rootError.name}> clazz,
            ExceptionInfo exceptionInfo,
            ErrorCode code,
            Optional<ErrorDescription> description,
            boolean isCommon
    ) {
        this.clazz = clazz;
        this.exceptionInfo = exceptionInfo;
        this.code = code;
        this.description = description;
        this.isCommon = isCommon;
    }

    public ${name}(
            Class<? extends ${rootError.name}> clazz,
            ExceptionInfo exceptionInfo,
            ErrorCode code,
            boolean isCommon
    ) {
        this(clazz, exceptionInfo, code, Optional.${optionalType.emptyMethod}(), isCommon);
    }

    public ${name}(
            Class<? extends ${rootError.name}> clazz,
            ExceptionInfo exceptionInfo,
            ErrorCode code,
            ErrorDescription description,
            boolean isCommon
    ) {
        this(clazz, exceptionInfo, code, Optional.of(description), isCommon);
    }

    public Class<? extends ${rootError.name}> clazz() {
        return clazz;
    }

    public ExceptionInfo exceptionInfo() {
        return exceptionInfo;
    }

    public ErrorCode code() {
        return code;
    }

    public Optional<ErrorDescription> description() {
        return description;
    }

    public boolean isCommon() {
        return isCommon;
    }

    @Override
    final public boolean equals(Object o){
        return o instanceof ${name} && ((${name})o).code.equals(code);
    }

    public static abstract class ErrorDescription {

        private boolean usesCustomMessageGenerator;

        public ErrorDescription(boolean usesCustomMessageGenerator) {
            this.usesCustomMessageGenerator = usesCustomMessageGenerator;
        }

        public abstract Object description();

        public boolean usesCustomMessageGenerator() {
            return usesCustomMessageGenerator;
        }
    }

    public static class PlainTextErrorDescription extends ErrorDescription {

        private String description;

        public PlainTextErrorDescription(String description) {
            super(false);
            this.description = description;
        }

        @Override
        public String description() {
            return description;
        }
    }

    public static class CustomMessageGeneratorErrorDescription<T> extends ErrorDescription {

        private Class<T> description;

        public CustomMessageGeneratorErrorDescription(Class<T> description) {
            super(true);
            this.description = description;
        }

        @Override
        public Class<T> description() {
            return description;
        }
    }
}
