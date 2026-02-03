package org.stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Generator implements Supplier<String> {
    Random rand = new Random(47);
    char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    char[] numbers = "0123456789".toCharArray();

    private boolean generateNumbers = false;

    // 添加构造函数控制生成类型
    public Generator(boolean generateNumbers) {
        this.generateNumbers = generateNumbers;
    }

    // 默认构造函数保持原有行为
    public Generator() {
        this.generateNumbers = false;
    }

    public String get() {
        if (generateNumbers) {
            return "" + numbers[rand.nextInt(numbers.length)];
        } else {
            return "" + letters[rand.nextInt(letters.length)];
        }
    }

    // 移除 getNumber 方法，因为 Supplier 接口只使用 get()

    public static void main(String[] args) {
        String word = Stream.generate(new Generator())
                .limit(30)
                .collect(Collectors.joining());
        System.out.println(word);

        String number = Stream.generate(new Generator(true))
                .limit(10)
                .collect(Collectors.joining());
        System.out.println(number);
    }
}
