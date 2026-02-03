package org.dcj;

public class test_03 {
    public static void main(String[] args) {
        // 使用多态形式创建对象
        Animal dog = new Dog();
        Animal cat = new Cat();
        
        // 调用eat方法
        dog.eat();
        cat.eat();
        System.out.println("------------------");
      Cat cat1 = (Cat)cat;
        cat1.catchMouse();
        Dog dog1 = (Dog)dog;
        dog1.lookHome();
    }
}