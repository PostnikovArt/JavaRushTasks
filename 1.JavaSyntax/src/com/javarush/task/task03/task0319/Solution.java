package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine();
        int money = Integer.parseInt(bufferedReader.readLine());
        int years = Integer.parseInt(bufferedReader.readLine());

        System.out.println(name + " получает " + money + " через " + years + " лет.");
    }
}
