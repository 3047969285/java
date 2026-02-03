package org.Proxy;

public class BigStar implements Base {
    /**
     * 唱歌
     */
    @Override
    public String sing(String name) {
        System.out.println("I'm a big star, I'm singing: " + name);
        return "Sing: " + name;
    }

    /**
     * 跳舞
     */
    @Override
    public void dance() {
        System.out.println("I'm a big star, I'm dancing");
    }
}