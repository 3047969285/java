package yufa;

import java.util.Scanner;

public class yufa001 {
    public static void main(String[] args) {


        double weight;
        double height;

        System.out.println("请输入体重：");
        Scanner sc = new Scanner(System.in);
        weight = sc.nextDouble();

        System.out.println("请输入身高：");
        height = sc.nextDouble();

        double bmi = weight / (height * height);
        System.out.println("BMI:" + bmi);

        if (bmi < 18.5) {
            System.out.println("过轻");
        } else if (bmi >= 18.5 && bmi < 24) {
            System.out.println("正常");
        } else if (bmi >= 24 && bmi < 27) {
            System.out.println("过重");
        } else if (bmi >= 27 && bmi < 30) {
            System.out.println("肥胖");
        } else {
            System.out.println("严重肥胖");
        }
    }
}