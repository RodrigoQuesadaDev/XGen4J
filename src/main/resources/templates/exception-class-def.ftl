package ${packagePath};

<#if parent??>import ${parent.fullQualifiedName};</#if>

/**
* Autogenerated by XGen on 25/05/15.
*/
public class ${name} extends <#if parent??>${parent.name}<#else>RuntimeException</#if> {

    protected ${name}(String message) {
        super(message);
    }
}
