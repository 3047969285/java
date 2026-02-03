package yufa;

public class yufa005 {
    // 声明native方法
    public native int add(int a, int b);
    public native String sayHello(String name);
    
    // 加载本地库
    static {
        try {
            // 加载名为"native"的本地库（在Windows上是native.dll，在Linux/Mac上是libnative.so/libnative.dylib）
            System.loadLibrary("native");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("本地库未找到: " + e.getMessage());
            System.err.println("请确保本地库文件已正确编译并放置在系统路径中");
        }
    }
    
    public static void main(String[] args) {
        yufa005 obj = new yufa005();
        
        try {
            int result = obj.add(5, 3);
            System.out.println("5 + 3 = " + result);
            
            String greeting = obj.sayHello("World");
            System.out.println(greeting);
        } catch (UnsatisfiedLinkError e) {
            System.err.println("调用本地方法失败: " + e.getMessage());
            System.out.println("这表明本地库尚未正确编译或链接");
        }
    }
}