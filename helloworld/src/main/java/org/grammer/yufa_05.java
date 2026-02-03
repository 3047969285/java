package org.grammer;

public class yufa_05 {
    public static void main(String[] args) {
        getValue("大", 10, 20, 30);
        getValue("小", 10, 20, 30);
    }
    public static void getValue(String ext,int a,int b,int c)
    {
        switch (ext) {
            case "大":
                System.out.println("最大值为：" + getMax(a, b, c));
                break;
            case "小":
                System.out.println("最小值为：" + getMin(a, b, c));
        }
    }

    public static int getMax(int a,int b,int c)
    {
        if(a>b&&a>c)
            return a;
        else if(b>a&&b>c)
            return b;
        else
            return c;

    }
    public static int getMin(int a,int b,int c)
    {
        if(a<b&&a<c)
            return a;
        else if(b<a&&b<c)
            return b;
        else
            return c;

    }
}
