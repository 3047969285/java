package org.grammer;

public class yufa_08 {
    public static void main(String[] args) {
        num(6);
    }

    public static void num(int n) {
        if (n >= 3) {
            int sum = 0;
            while (sum <= n) {

                System.out.print(sum+" ");
                sum += 2;

            }
        }
    }
}
