package ${packagePath};

/**
* Autogenerated by XGen on ${currentDate}.
*/
public class ${name} {

    private final String name;
    //private final String number;

    public ${name}(String name/*, String number*/){
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
        return o instanceof ${name} && ((${name})o).name.equals(name);
    }

    @Override
    public String toString(){
        return String.format("{name: '%s'}", name);
    }
}