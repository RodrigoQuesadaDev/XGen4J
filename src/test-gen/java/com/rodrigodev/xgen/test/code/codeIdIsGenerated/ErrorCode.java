package com.rodrigodev.xgen.test.code.codeIdIsGenerated;

/**
* Autogenerated by XGen on July 1, 2015.
*/
public class ErrorCode {

    private final String id;
    //private final String number;

    public ErrorCode(String id/*, String number*/){
        this.id = id;
        //this.number = number;
    }

    public String id(){
        return id;
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
