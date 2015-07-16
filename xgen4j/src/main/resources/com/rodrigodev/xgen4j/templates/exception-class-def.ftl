package ${packagePath};

<#if parent??>import ${parent.canonicalName};</#if>
<#if root??>import ${root.canonicalName};</#if>

/**
 * Autogenerated by XGen on ${currentDate}.
 */
public class ${name} extends <#if parent??>${parent.name}<#elseif checkedException>Exception<#else>RuntimeException</#if> {

    <#if hasType>
    public static final ExceptionType TYPE = new ExceptionType();
    </#if>

    <#if root??>
    <#if !common>
    private static class ExceptionType extends ${root.name}.ExceptionType {

        @Override
        protected ${root.name} createException(String message) {
            return new ${name}(message);
        }

        @Override
        protected ${root.name} createException(String message, Throwable cause) {
            return new ${name}(message, cause);
        }
    }
    </#if>
    <#else>
    public abstract static class ExceptionType {

        protected ExceptionType() {
        }

        protected abstract ${name} createException(String message);

        protected abstract ${name} createException(String message, Throwable cause);
    }
    </#if>

    protected ${name}(String message) {
        super(message);
    }

    protected ${name}(String message, Throwable cause) {
        super(message, cause);
    }
}