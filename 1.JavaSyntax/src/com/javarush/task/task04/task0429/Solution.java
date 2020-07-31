package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int countPlus = 0;
        int countMinus = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int buffer;
        for (int i = 0; i < 3; i++) {
            if ( (buffer = Integer.parseInt(reader.readLine())) > 0) {
                countPlus++;
            } else if (buffer != 0) {
                countMinus++;
            }
        }
        reader.close();

        System.out.println("количество отрицательных чисел: " + countMinus);
        System.out.println("количество положительных чисел: " + countPlus);


    }
}
