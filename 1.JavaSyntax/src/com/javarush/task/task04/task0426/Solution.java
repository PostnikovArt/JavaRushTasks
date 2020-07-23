package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        reader.close();
        if (a == 0) {
            System.out.println("ноль");
            return;
        }
        if (a > 0) {
            if (a%2 == 0) {
                System.out.println("положительное четное число");
            }
            else System.out.println("положительное нечетное число");
        }
        else {
            if (a%2 == 0) {
                System.out.println("отрицательное четное число");
            }
            else System.out.println("отрицательное нечетное число");
        }
    }
}
