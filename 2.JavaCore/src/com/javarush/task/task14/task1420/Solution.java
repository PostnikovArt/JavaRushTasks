package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num1 = 0;
        int num2 = 0;

        if ((num1 = Integer.parseInt(reader.readLine())) <= 0) {
             throw new Exception();
        }

         if ( (num2 = Integer.parseInt(reader.readLine())) <= 0 ) {
              throw new Exception();
        }

        reader.close();

        if (num1 >= num2) {
            for (int i = num1; i >= 1; i--) {
                if (num2%i == 0 && num1%i == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
        else for (int i = num2; i >= 1; i--) {
            if (num2%i == 0 && num1%i == 0) {
                System.out.println(i);
                break;
            }
        }


    }
}
