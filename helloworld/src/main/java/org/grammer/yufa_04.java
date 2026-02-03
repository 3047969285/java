package org.grammer;

public class yufa_04 {
    public static void main(String[] args) {
        showColor("red");
    }
    public static void showColor(String color)
        {
            switch (color) {
                case "red":
                    System.out.println("red是红色");
                    break;
                case "yellow":
                    System.out.println("yellow是黄色");
                    break;
                case "blue":
                    System.out.println("blue是蓝色");
                    break;
                default:
                    System.out.println("未知颜色");
            }
        }
}
