package org.stream;

import java.util.stream.*;
public class Fibonacci {
    int x = 1;

    Stream<Integer> numbers() {
        return Stream.iterate(1, i -> {
            int result = x + i;
            x = i;
            return result;
        });
    }

    public static void main(String[] args) {
        new Fibonacci().numbers()
                .limit(10)
                .forEach(System.out::println);

        new Fibonacci().numbers()
                .skip(20)
                .limit(10)
                .forEach(System.out::println);
    }
}