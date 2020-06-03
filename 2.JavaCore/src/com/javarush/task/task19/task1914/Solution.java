package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream outStream = System.out;
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(arrayOutputStream);
        System.setOut(stream);

        testString.printSomething();
        System.setOut(outStream);

        String[] strings = arrayOutputStream.toString().split(" ");
        int result = 0;
        if (strings[1].equals("+")) {
            result = Integer.parseInt(strings[0]) + Integer.parseInt(strings[2]);
        }
        if (strings[1].equals("*")) {
            result = Integer.parseInt(strings[0]) * Integer.parseInt(strings[2]);
        }
        if (strings[1].equals("-")) {
            result = Integer.parseInt(strings[0]) - Integer.parseInt(strings[2]);
        }
        for (int i = 0; i < strings.length -1; i++) {
            System.out.print(strings[i] + " ");
        }
        System.out.println(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

