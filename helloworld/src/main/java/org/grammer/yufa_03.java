package org.grammer;

public class yufa_03 {
    public static void main(String[] args) {
           char ch = getChar(80);
           System.out.println(ch);
           String str =  getString(80);
           System.out.println(str);
    }
    public static char getChar(int num){
        char ch = (char) num;
        if(num >= 65 && num <= 90) {
            return ch;
        }
        else if(num >= 97 && num <= 122) {
            return ch;
        }
        else if(num >= 48 && num <= 57) {
            return ch;
        }
        else {
            return ' ';
        }
    }

    public static String getString(int num){
        char ch = getChar(num);
        if(ch == ' ') {
            return "";
        }

        String result = "";
        for(int i = 0; i < 4; i++) {
            result += ch;
        }
        return result;
    }
}