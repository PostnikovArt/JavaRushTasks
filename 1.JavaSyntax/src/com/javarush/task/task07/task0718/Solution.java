package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            strings.add(bufferedReader.readLine());
        }
        bufferedReader.close();

        for (int i = 0; i < strings.size() - 1; i++) {
            if (strings.get(i).length() > strings.get(i +1).length()) {
                System.out.println((i + 1));
                break;
            }
        }
    }
}

