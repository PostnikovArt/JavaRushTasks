package com.javarush.task.task20.task2027;

import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */

//        System.out.println((char) crossword[0][0]);
//        System.out.println((char) crossword[1][1]);
//        System.out.println((char) crossword[2][2]);
//        System.out.println((char) crossword[3][3]);
//
//        System.out.println((char) crossword[0][0]);
//        System.out.println((char) crossword[1][0]);
//        System.out.println((char) crossword[2][0]);
//        System.out.println((char) crossword[3][0]);
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        //horizontal
//        for (int i = 0; i < crossword.length; i++) {
//            for (int j = 0; j < crossword[i].length; j++) {
//                System.out.print((char) crossword[i][j] + " ");
//            }
//            System.out.println();
//        }
        //vertical
        for (int i = 0; i < crossword[0].length; i++) {
            for (int j = 0; j < crossword.length; j++) {
                System.out.print((char) crossword[j][i] + " ");
            }
            System.out.println();
        }



        return null;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
