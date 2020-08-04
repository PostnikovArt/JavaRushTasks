package com.javarush.task.task08.task0801;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 
Set из растений
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Set<String> strings = new HashSet<>();

        String s = "арбуз\n" +
                "банан\n" +
                "вишня\n" +
                "груша\n" +
                "дыня\n" +
                "ежевика\n" +
                "женьшень\n" +
                "земляника\n" +
                "ирис\n" +
                "картофель";
        String[] a = s.split("\\n");
        strings.addAll(Arrays.asList(a));

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
