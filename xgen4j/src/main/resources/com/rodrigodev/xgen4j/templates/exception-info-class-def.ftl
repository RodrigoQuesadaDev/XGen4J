package ${packagePath};

import ${rootError.exception.canonicalName}.ExceptionType;
import ${optionalType.canonicalName};

/**
 * Autogenerated by XGen4J on ${currentDate}.
 */
public class ${name} {

    final private Class<? extends ${rootError.exception.name}> clazz;
    final private Optional<ExceptionType> type;

    private ${name}(Optional<ExceptionType> type, Class<? extends ${rootError.exception.name}> clazz) {
        this.type = type;
        this.clazz = clazz;
    }

    public ${name}(Class<? extends ${rootError.exception.name}> clazz) {
        this(Optional.<ExceptionType>${optionalType.emptyMethod}(), clazz);
    }

    public ${name}(ExceptionType type, Class<? extends ${rootError.exception.name}> clazz) {
        this(Optional.of(type), clazz);
    }

    public Class<? extends ${rootError.exception.name}> clazz() {
        return clazz;
    }

    public Optional<ExceptionType> type() {
        return type;
    }
}
