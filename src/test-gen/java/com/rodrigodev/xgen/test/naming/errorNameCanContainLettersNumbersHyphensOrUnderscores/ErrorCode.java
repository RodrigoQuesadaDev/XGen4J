package com.rodrigodev.xgen.test.naming.errorNameCanContainLettersNumbersHyphensOrUnderscores;

/**
* Autogenerated by XGen on July 1, 2015.
*/
public class ErrorCode {

    private final String id;
    private final String name;
    //private final String number;

    protected ErrorCode(String name/*, String number*/){
        this.id = name;
        this.name = name;
        //this.number = number;
    }

    public ErrorCode(String name, ErrorCode parent/*, String number*/){
        this.id = parent.id + "." + name;
        this.name = name;
        //this.number = number;
    }

    public String id(){
        return id;
    }

    public String name(){
        return name;
    }

    /*public String number(){
        return number;
    }*/

    @Override
    final public boolean equals(Object o){
        return o instanceof ErrorCode && ((ErrorCode)o).id.equals(id);
    }

    @Override
    public String toString(){
        return String.format("{id: '%s'}", id);
    }
}
