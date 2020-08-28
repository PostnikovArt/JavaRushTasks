package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        String string = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!(string = reader.readLine()).equals("exit")) {
            if (string.matches("[-]?\\d+[.]\\d+")) {
                try {
                    print(Double.valueOf(string));
                    continue;
                } catch (NumberFormatException e) {
                    print(string);
                    continue;
                }
            }
            if (string.matches("[-]?\\d*")) {
                int integer = 0;
                try {
                    integer = Integer.valueOf(string);
                } catch (NumberFormatException e) {
                    print(string);
                }
                if (integer > 0 && integer < 128) {
                    try {
                        short i = Short.parseShort(string);
                        print(i);
                    } catch (NumberFormatException e) {
                        print(string);
                    }
                } else {
                    try {
                        print(integer);
                    } catch (Exception e) {
                        print(string);
                    }
                }
            }
            else print(string);
        }
        reader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
