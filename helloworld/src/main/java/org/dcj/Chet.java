package org.dcj;

public class Chet extends dcj_02{

    public Chet() {
        super();

    }

    @Override
    public void work(String name, String id, double salary) {
        System.out.println("工号为："+id+"姓名为："+name+"的"+name+"工资为："+salary+"的厨师正在炒菜...");
    }

    @Override
    public void eat(String name, String id, double salary) {
            System.out.println("工号为："+id+"姓名为："+name+"的"+name+"工资为："+salary+"的厨师正在吃饭...");
    }
}
