package org.stream;

import java.util.Random;
import java.util.stream.IntStream;

public class RandInts {
    private static Random r = new Random(47);

    public static IntStream rands() {
        return r.ints(10, 0, 100); // 生成10个0到99之间的随机数
    }
}
