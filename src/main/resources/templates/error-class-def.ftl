package ${packagePath};

<#if parent??>import ${parent.canonicalName};</#if>
import ${rootPackage}.ErrorCode;

<#if concrete>
<#list description.params as param>import ${param.type.canonicalName};
</#list>
</#if>

/**
* Autogenerated by XGen on ${currentDate}.
*/
public abstract class ${name} <#if parent??>extends ${parent.name} </#if>{

    public static final ErrorCode CODE = new ErrorCode("${code.name}"<#if parent??>, ${parent.name}.CODE</#if>);

    <#if concrete>
    private static String MESSAGE_FORMAT = "${description.format}";

    public static void throwException(<#list description.params as param>${param.type.name} ${param.name}<#if param_has_next>, </#if></#list>) {
        throw new ${exceptionName}(String.format(MESSAGE_FORMAT<#list description.params as param>, ${param.name}</#list>));
    }
    </#if>
}
