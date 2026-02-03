package org.stream;// streams/RandomWords.java
import java.net.URL;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.io.*;
import java.nio.file.*;

public class RandomWords implements Supplier<String> {
    List<String> words = new ArrayList<>();
    Random rand = new Random(47);

    RandomWords(String fname) throws IOException {
        // 首先尝试在当前目录查找文件
        Path filePath = Paths.get(fname);

        // 如果没找到，则尝试使用类加载器查找资源
        // 替换原来的类加载器代码段
        if (!Files.exists(filePath)) {
            // 使用类加载器从classpath中加载资源
            ClassLoader classLoader = getClass().getClassLoader();
            URL resourceUrl = classLoader.getResource(fname);
            if (resourceUrl != null) {
                try {
                    filePath = Paths.get(resourceUrl.toURI());
                } catch (Exception e) {
                    throw new IOException("无法转换URL到路径: " + e.getMessage());
                }
            } else {
                throw new IOException("资源不存在: " + fname);
            }
        }


        // 最终检查文件是否存在
        if (!Files.exists(filePath)) {
            // 列出当前目录的所有文件用于调试
            System.err.println("无法找到文件: " + fname);
            System.err.println("当前目录文件列表:");
            try {
                Files.list(Paths.get(".")).forEach(System.err::println);
            } catch (IOException e) {
                System.err.println("无法列出当前目录内容: " + e.getMessage());
            }
            throw new IOException("找不到文件: " + fname);
        }

        List<String> lines = Files.readAllLines(filePath);
        // 略过第一行
        for (String line : lines.subList(1, lines.size())) {
            for (String word : line.split("[ .?,]+"))
                words.add(word.toLowerCase());
        }
    }

    public String get() {
        return words.get(rand.nextInt(words.size()));
    }

    @Override
    public String toString() {
        return words.stream()
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(
                Stream.generate(new RandomWords("dat/Cheese.dat"))
                        .limit(10)
                        .collect(Collectors.joining(" ")));
    }
}
