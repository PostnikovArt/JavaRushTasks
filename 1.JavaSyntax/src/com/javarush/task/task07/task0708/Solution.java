package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        strings = new ArrayList<>(5);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
//            strings.set(i, bufferedReader.readLine());
            strings.add(bufferedReader.readLine());
        }
        bufferedReader.close();

        int maxLength = 0;

        for (String string : strings) {
            if (maxLength < string.length())
                maxLength = string.length();
        }

        for (String string : strings) {
            if (maxLength == string.length())
                System.out.println(string);
        }
    }
}
