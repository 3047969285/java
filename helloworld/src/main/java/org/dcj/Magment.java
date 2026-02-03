package org.dcj;

public class Magment extends dcj_02{
    public Magment(){

    }

    @Override
    public void work(String name, String id, double salary) {
        System.out.println("工号："+ id+"，姓名："+name+"，月薪："+salary+"元"+"，正在工作...管理其他人");
    }

    @Override
    public void eat(String name, String id, double salary) {
        System.out.println("工号："+ id+"，姓名："+name+"，月薪："+salary+"元"+"，正在吃肉...");
    }
}
