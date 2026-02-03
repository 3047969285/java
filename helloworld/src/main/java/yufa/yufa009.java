package yufa;

import java.util.Arrays;

public class yufa009 {
    public static void main(String[] args) {
        // 示例1：数值比较
        int x = 10;
        int y = 20;
        int max = (x > y) ? x : y;
        int min = (x < y) ? x : y;
        System.out.println("Max: " + max + ", Min: " + min);
        
        // 示例2：字符串处理
        String name = null;
        String displayName = (name != null && !name.isEmpty()) ? name : "Anonymous";
        System.out.println("Display name: " + displayName);
        
        // 示例3：根据条件返回不同格式的字符串
        int score = 85;
        String grade = (score >= 90) ? "A" : 
                      (score >= 80) ? "B" : 
                      (score >= 70) ? "C" : "D";
        System.out.println("Grade: " + grade);
        
        // 示例4：数组边界检查
        int[] numbers = {1, 2, 3, 4, 5};
        int index = 10; // 超出范围的索引
        int value = (index >= 0 && index < numbers.length) ? numbers[index] : -1;
        System.out.println("Value at index " + index + ": " + value);
        
        // 示例5：对象属性获取
        User user1 = new User("Alice", 25);
        User user2 = null;
        String userName = (user2 != null) ? user2.getName() : "Guest";
        int userAge = (user2 != null) ? user2.getAge() : 0;
        System.out.println("User: " + userName + ", Age: " + userAge);
        
        // 示例6：集合大小判断
        int[] emptyArray = {};
        String arrayStatus = (emptyArray.length > 0) ? 
                            "Array has " + emptyArray.length + " elements" : 
                            "Array is empty";
        System.out.println(arrayStatus);
        
        // 示例7：价格折扣计算
        double price = 100.0;
        int quantity = 5;
        double total = (quantity >= 10) ? price * quantity * 0.9 : price * quantity; // 10件以上打9折
        System.out.println("Total price: $" + total);
        
        // 示例8：字符串长度验证
        String input = "Hello World";
        String processedInput = (input.length() > 10) ? input.substring(0, 10) + "..." : input;
        System.out.println("Processed input: " + processedInput);
        
        // 示例9：奇偶数判断
        int number = 42;
        String parity = (number % 2 == 0) ? "even" : "odd";
        System.out.println(number + " is " + parity);
        
        // 演示：不能在三元运算符中执行业务逻辑
        // 错误示例：
        // String result = (number % 2 == 0) ? System.out.println("Even") : System.out.println("Odd");
        
        // 正确做法：先执行业务逻辑，然后使用三元运算符进行值选择
        if (number % 2 == 0) {
            System.out.println("This is an even number, performing even number business logic...");
            // 执行偶数相关的业务逻辑
            performEvenNumberLogic(number);
        } else {
            System.out.println("This is an odd number, performing odd number business logic...");
            // 执行奇数相关的业务逻辑
            performOddNumberLogic(number);
        }
        
        // 或者使用三元运算符来选择要执行的函数（Java 8+ lambda）
        Runnable task = (number % 2 == 0) ? () -> performEvenNumberLogic(number) : () -> performOddNumberLogic(number);
        task.run();
        
        // 示例10：数组排序方向判断
        int[] arr = {5, 2, 8, 1, 9};
        boolean ascending = true;
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        
        // 使用三元运算符确定排序后输出格式
        String sortDirection = ascending ? "ascending" : "descending";
        System.out.println("Array will be sorted in " + sortDirection + " order");
        
        // 实际排序逻辑（这里仅演示三元运算符的应用）
        Arrays.sort(sortedArr); // 默认升序
        if (!ascending) {
            // 如果需要降序，则反转数组
            for (int i = 0; i < sortedArr.length / 2; i++) {
                int temp = sortedArr[i];
                sortedArr[i] = sortedArr[sortedArr.length - 1 - i];
                sortedArr[sortedArr.length - 1 - i] = temp;
            }
        }
        System.out.println("Original: " + Arrays.toString(arr));
        System.out.println("Sorted: " + Arrays.toString(sortedArr));
        
        // 演示三元运算符在业务逻辑中的实际应用
        double discount = calculateDiscount(1500.0, true);
        System.out.println("Discount applied: $" + discount);
    }
    
    // 演示偶数业务逻辑
    public static void performEvenNumberLogic(int number) {
        System.out.println("  Processing even number: " + number);
        System.out.println("  Even number properties: divisible by 2");
    }
    
    // 演示奇数业务逻辑
    public static void performOddNumberLogic(int number) {
        System.out.println("  Processing odd number: " + number);
        System.out.println("  Odd number properties: not divisible by 2");
    }
    
    // 使用三元运算符的实用业务方法示例
    public static double calculateDiscount(double purchaseAmount, boolean isVIP) {
        // VIP客户享受更高折扣
        double discountRate = isVIP ? 0.15 : 0.05;  // VIP 15% 折扣，普通客户 5% 折扣
        return purchaseAmount * discountRate;
    }
    
    // 辅助类
    static class User {
        private String name;
        private int age;
        
        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public String getName() {
            return name;
        }
        
        public int getAge() {
            return age;
        }
    }
}