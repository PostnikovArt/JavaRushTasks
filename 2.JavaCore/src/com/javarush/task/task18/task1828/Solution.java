package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        if (args.length <= 0) return;
        //if ( ! args[0].equals("-c")) return;


        String fileName = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (args[0].equals("-d")) {

            int deleteID = Integer.parseInt(args[1]);
            ArrayList<String> buffer = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                while (reader.ready()) {
                    String data = reader.readLine();
                    String[] params = data.split("\\D");
                    int id = Integer.parseInt(params[0]);
                    if (id != deleteID) {
                        buffer.add(data);
                    }
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                for (String s : buffer) {
                    writer.write(s);
                    writer.newLine();
                }
                writer.flush();
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if (args[0].equals("-u")) {

            int changeID = Integer.parseInt(args[1]);
            String productName = args[2];
            String price = args[3];
            String quantity = args[4];
            ArrayList<String> buffer = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                while (reader.ready()) {
                    String data = reader.readLine();
                    String[] params = data.split("\\D");
                    int id = Integer.parseInt(params[0]);
                    if (id != changeID) {
                        buffer.add(data);
                    } else {
                        String line = String.format("%-8d%-30s%-8.2f%-4d" ,
                                changeID, productName, Float.parseFloat(price), Integer.parseInt(quantity));
                        buffer.add(line);
                    }
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                for (String s : buffer) {
                    writer.write(s);
                    writer.newLine();
                }
                writer.flush();
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
