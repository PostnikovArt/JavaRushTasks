package com.javarush.task.task09.task0923;

/* 
Гласные и согласные
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = null;
        char[] chars = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();
            chars = str.toCharArray();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<Character> glasn = new ArrayList<>();
        ArrayList<Character> sogl = new ArrayList<>();

        for (char aChar : chars) {
            if (isVowel(aChar)) {
                glasn.add(aChar);
            }
            else {
                if ( aChar != ' ') {
                    sogl.add(aChar);
                }
            }
        }

        for (Character character : glasn) {
            System.out.print(character + " ");
        }

        System.out.println();

        for (Character character : sogl) {
            System.out.print(character + " ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}