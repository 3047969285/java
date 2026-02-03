package org.arr_grammer;

public class arr_06 {
    public static void main(String[] args) {

        String[] standardAnswers = {"A", "D", "B", "C", "D"};

        String[][] studentsAnswers = {
            {"D", "C", "B", "A", "D"},
            {"A", "D", "B", "C", "D"},
            {"A", "D", "B", "C", "A"},
            {"A", "B", "C", "D", "D"}
        };

        String[] studentNames = {"小张", "小李", "小王", "小赵"};

        for (int i = 0; i < studentsAnswers.length; i++) {
            int score = 0;
            for (int j = 0; j < studentsAnswers[i].length; j++) {
                if (studentsAnswers[i][j].equals(standardAnswers[j])) {
                    score += 2;
                }
            }
            System.out.println(studentNames[i] + "的最终得分：" + score);
        }
    }
}