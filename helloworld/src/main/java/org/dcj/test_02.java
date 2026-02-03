package org.dcj;

public class test_02 {
    public static void main(String[] args) {
        Chet chet = new Chet();
        chet.work( "张三", "001", 5000);
        chet.eat("张三", "001", 5000);

        Magment magment = new Magment();
        magment.work("张三", "001", 5000);
        magment.eat("张三", "001", 5000);
    }
}
