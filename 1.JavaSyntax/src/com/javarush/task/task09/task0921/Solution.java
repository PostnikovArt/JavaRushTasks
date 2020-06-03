package com.javarush.task.task09.task0921;

/* 
Метод в try..catch
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        BufferedReader reader = null;
        ArrayList<Integer> integers = new ArrayList<>();
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String str = reader.readLine();
                if (str.matches("\\d+"))
                integers.add(Integer.parseInt(str));
                else throw new Exception();
            }

        } catch (Exception e) {
            for (Integer integer : integers) {
                System.out.println(integer);
            };
        } finally {
        }
    }
}
