package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {

        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }

        HashMap<Byte, Integer> map = new HashMap<>();
        byte[] bytes = new byte[0];
        FileInputStream fis = new FileInputStream(fileName);
        while (fis.available() > 0 ) {
            byte b = (byte) fis.read();
            if (map.containsKey(b)) {
                map.replace(b, map.get(b) +1 );
            }
            else map.put(b, 0);
        }
        fis.close();


//            bytes = fis.readAllBytes();

//        int[] ints = new int[256];
//        for (byte b : bytes) {
//            ints[b +128] += +1;
//        }
//        for (int i = 0; i < ints.length; i++) {
//            if (ints[i] != 0) {
//                System.out.print((i - 128) + " - ");
//                System.out.println(ints[i]);
//            }
//        }
//        System.out.println();

//        HashMap<Byte, Integer> map = new HashMap<>();
//        for (byte aByte : bytes) {
//            if (map.containsKey(aByte)) {
//                map.replace(aByte, map.get(aByte) +1 );
//            }
//            else map.put(aByte, 0);
//        }

        int min = Integer.MAX_VALUE;
        for (Integer value : map.values()) {
            if (value < min) min = value;
        }

        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            if (entry.getValue() == min) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
