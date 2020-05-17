package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        //add your code here
        String string = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            string = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] parseString = string.split("\\?");

        String[] parametersWithValue = parseString[1].split("&");

        String buffer= null;
        for (String s : parametersWithValue) {
            String[] param = s.split("=");
            System.out.print(param[0] + " ");

            if (param[0].matches("obj")) {
                buffer = param[1];
            }
        }
        System.out.println();

        if (buffer != null) {
            if (buffer.matches("[-]?\\d+.\\d+")) {
                try {
                    double v = Double.parseDouble(buffer);
                    alert(v);
                } catch (NumberFormatException e) {
                    alert(buffer);
                }
            } else alert(buffer);
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}

//         http://javarush.ru/alpha/index.html?obj=-3.14&name=Amigo
