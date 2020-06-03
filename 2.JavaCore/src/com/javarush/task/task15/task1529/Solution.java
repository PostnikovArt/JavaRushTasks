package com.javarush.task.task15.task1529;

/* 
Осваивание статического блока
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static CanFly result;

    public static void reset() {
        //add your code here - добавьте код тут
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String objectName = reader.readLine();
            if (objectName.equals("helicopter")) {
                result = new Helicopter();
            }
            if (objectName.equals("plane")) {
                int capacity = Integer.parseInt(reader.readLine());
                result = new Plane(capacity);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
