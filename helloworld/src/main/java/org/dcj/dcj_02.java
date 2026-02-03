package org.dcj;

public abstract class dcj_02 {
    String name;
    String id;
    double salary;
    public dcj_02(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public dcj_02(){

    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public double getSalary() {
        return salary;
    }
    public abstract void work(String name, String id, double salary);
    public abstract void eat(String name, String id, double salary);
}
