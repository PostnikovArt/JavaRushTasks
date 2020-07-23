package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double t = Double.parseDouble(reader.readLine());
        reader.close();
        Double minutes = t%5;
        if (minutes >= 0 && minutes < 3) {
            System.out.println("зелёный");
            return;
        }
        if (minutes >= 3 && minutes < 4) {
            System.out.println("жёлтый");
            return;
        }
        if (minutes >= 4 ) {
            System.out.println("красный");
            return;
        }
    }
}