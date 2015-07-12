package com.rodrigodev.xgen.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed;

/**
 * Autogenerated by XGen on July 12, 2015.
 */
public class ErrorCode {

    private final String id;
    private final String name;

    protected ErrorCode(String name){
        this.id = name;
        this.name = name;
    }

    public ErrorCode(String name, ErrorCode parent){
        this.id = parent.id + "." + name;
        this.name = name;
    }

    public String id(){
        return id;
    }

    public String name(){
        return name;
    }

    @Override
    final public boolean equals(Object o){
        return o instanceof ErrorCode && ((ErrorCode)o).id.equals(id);
    }

    @Override
    public String toString(){
        return String.format("{id: '%s'}", id);
    }
}
