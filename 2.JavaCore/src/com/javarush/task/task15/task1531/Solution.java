package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        if (n == 0) {
            return "1";
        }
        if (n < 0) {
            return "0";
        }
        BigInteger result = BigInteger.valueOf(1);
        for (int i = n ; i > 1; i--) {
            BigInteger buffer = BigInteger.valueOf(i);
            result = result.multiply(buffer);
        }

        String str = String.valueOf(result);

        //return str.substring(0, str.length() - 2);
        return str;
    }
}
