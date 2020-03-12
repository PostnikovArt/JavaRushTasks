package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>(5);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            strings.add(bufferedReader.readLine());
        }
        bufferedReader.close();

        int min = Integer.MAX_VALUE;

        for (String string : strings) {
            if (min > string.length())
                min = string.length();
        }

        for (String string : strings) {
            if (min == string.length())
                System.out.println(string);
        }
    }
}
