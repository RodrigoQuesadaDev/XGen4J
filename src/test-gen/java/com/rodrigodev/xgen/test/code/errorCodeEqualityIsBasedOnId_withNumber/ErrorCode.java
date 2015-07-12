package com.rodrigodev.xgen.test.code.errorCodeEqualityIsBasedOnId_withNumber;

/**
 * Autogenerated by XGen on July 12, 2015.
 */
public class ErrorCode {

    private final String id;
    private final String name;
    private final String numericId;
    private final int number;

    protected ErrorCode(String name, int number){
        this.id = name;
        this.name = name;
        this.numericId = String.valueOf(number);
        this.number = number;
    }

    public ErrorCode(String name, int number, ErrorCode parent){
        this.id = parent.id + "." + name;
        this.name = name;
        this.numericId = parent.numericId + ":" + number;
        this.number = number;
    }

    public String id(){
        return id;
    }

    public String name(){
        return name;
    }

    public String numericId(){
        return numericId;
    }

    public int number(){
        return number;
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
