package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        int sum = 0;
        int count = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int number = Integer.parseInt(reader.readLine());
            if (number == -1) {
                reader.close();
                break;
            }
            count++;
            sum += number;
        }

        double result = sum * 1.0 / count;
        System.out.println(result);
    }
}

