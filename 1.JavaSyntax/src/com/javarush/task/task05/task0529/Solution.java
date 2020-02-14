package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int sum = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String buffer = bufferedReader.readLine();
            if (buffer.equals("сумма")) {
                System.out.println(sum);
                break;
            }
            int number = Integer.parseInt(buffer);
            sum += number;
        }
    }
}
