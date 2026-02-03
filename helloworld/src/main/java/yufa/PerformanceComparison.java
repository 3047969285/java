package yufa;

public class PerformanceComparison {

    // 使用三元运算符的方法
    public static int getMaxTernary(int a, int b) {
        return a > b ? a : b;
    }

    // 使用if-else的方法
    public static int getMaxIfElse(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        // 预热JVM（让JIT有机会优化代码）
        for (int i = 0; i < 100000; i++) {
            getMaxTernary(i, i + 1);
            getMaxIfElse(i, i + 1);
        }

        // 测试三元运算符性能
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            getMaxTernary(i, i + 1);
        }
        long ternaryTime = System.nanoTime() - startTime;

        // 测试if-else性能
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            getMaxIfElse(i, i + 1);
        }
        long ifElseTime = System.nanoTime() - startTime;

        System.out.println("三元运算符执行时间: " + ternaryTime + " 纳秒");
        System.out.println("if-else执行时间: " + ifElseTime + " 纳秒");
        System.out.println("性能差异: " + (ifElseTime - ternaryTime) + " 纳秒");
        System.out.println("三元运算符比if-else快: " +
                String.format("%.2f", (double)ifElseTime / ternaryTime) + " 倍");
    }
}
