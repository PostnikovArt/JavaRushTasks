package com.javarush.task.task20.task2027;

import java.util.ArrayList;
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

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */

        //System.out.println((char)crossword[4][1]);
        detectAllWords(crossword, "home", "same");
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        /*   метод был пуст   */
        ArrayList<String> allStrings = new ArrayList<>();

        /* horizontal rows */
        for (int i = 0; i < crossword.length; i++) {
            //System.out.print(" " + i + " - ");
            StringBuilder stringBuilderHorizontal = new StringBuilder();
            for (int j = 0; j < crossword[i].length; j++) {
                stringBuilderHorizontal.append((char)crossword[i][j]);
                //System.out.print((char)crossword[i][j] + " / ");
            }
            allStrings.add(stringBuilderHorizontal.toString());
            allStrings.add(stringBuilderHorizontal.reverse().toString());
            //System.out.println();
        }

        /* vertical columns */
        int crosswordLineLengthMAX = 0;
        for (int i = 0; i < crossword.length; i++) {
            if (crossword[i].length > crosswordLineLengthMAX)
                crosswordLineLengthMAX = crossword[i].length;
        }
        for (int j = 0; j < crosswordLineLengthMAX; j++) {

            for (int i = 0; i < crossword.length; i++) {
                if (j < crossword[i].length) {
                System.out.print((char) crossword[i][j]);
                }
            }
            System.out.println();
        }

        /* diagonal rows */
        for (int i = 0; i < crossword.length; i++) {

        }


//        for (String allString : allStrings) {
//            System.out.println(allString);
//        }
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
