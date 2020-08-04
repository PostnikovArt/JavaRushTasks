package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (args.length <= 0) return;
        if ( ! args[0].equals("-c")) return;


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();

        int maxID = 0;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            String data = reader.readLine();
            String[] params = data.split("\\D");
            int id = Integer.parseInt(params[0]);
            if (maxID < id) maxID = id;
        }
        reader.close();

        String productName = args[1];
        String price = args[2];
        String quantity = args[3];
        String line = String.format("\n%-8d%-30s%-8.2f%-4d" ,
                maxID+1, productName, Float.parseFloat(price), Integer.parseInt(quantity));

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.write(line);
        writer.flush();
        writer.close();

    }
}
