package com.rodrigodev.xgen.test.organization.packages.basePackagePartsCanBeginWithLetterOrUnderscore;

/**
* Autogenerated by XGen on June 29, 2015.
*/
public class ErrorCode {

    private final String name;
    //private final String number;

    public ErrorCode(String name/*, String number*/){
        this.name = name;
        //this.number = number;
    }

    public String name(){
        return name;
    }

    /*public String number(){
        return number;
    }*/

    @Override
    final public boolean equals(Object o){
        return o instanceof ErrorCode && ((ErrorCode)o).name.equals(name);
    }

    @Override
    public String toString(){
        return String.format("{name: '%s'}", name);
    }
}
