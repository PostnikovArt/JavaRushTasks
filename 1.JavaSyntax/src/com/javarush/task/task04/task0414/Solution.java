package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(reader.readLine());
        reader.close();

        if (year%400 == 0) {
            System.out.println("количество дней в году: 366");
            return;
        }
        if (year%100 == 0) {
            System.out.println("количество дней в году: 365");
            return;
        }
        if (year%4 == 0) {
            System.out.println("количество дней в году: 366");
            return;
        }
            System.out.println("количество дней в году: 365");
            return;


    }
}