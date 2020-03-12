package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>(10);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            strings.add(bufferedReader.readLine());
        }
        bufferedReader.close();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String string : strings) {
            if (string.length() > max) max = string.length();
            if (string.length() < min) min = string.length();
        }

        for (String string : strings) {
            if (string.length() == min) {
                System.out.println(string);
                break;
            }
            if (string.length() == max) {
                System.out.println(string);
                break;
            }
        }
    }
}
