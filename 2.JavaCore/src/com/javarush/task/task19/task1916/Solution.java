package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {

        String fileName1 = "";
        String fileName2 = "";

        BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileName1 = nameReader.readLine();
            fileName2 = nameReader.readLine();
            nameReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        String fileName1 = "/home/artic/Tests/test1";
//        String fileName2 = "/home/artic/Tests/test2";

        BufferedReader reader1 = null;
        BufferedReader reader2 = null;

        try {
            reader1 = new BufferedReader(new FileReader(fileName1));
            reader2 = new BufferedReader(new FileReader(fileName2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String firstfileString1 = "";
        String secondfileString1 = "";
        String firstfileString2 = "";
        String secondfileString2 = "";

        try {
            firstfileString1 = reader1.readLine();
            secondfileString1 = reader2.readLine();
            firstfileString2 = reader1.readLine();
            secondfileString2 = reader2.readLine();

            while (!firstfileString1.isEmpty() || !secondfileString1.isEmpty()) {

                if (firstfileString1.equals(secondfileString1)) {
                    lines.add(new LineItem(Type.SAME, firstfileString1));
                    if (!firstfileString2.isEmpty()) {
                        firstfileString1 = firstfileString2;
                    } else {
                        firstfileString1 = "";
                    }
                    if (reader1.ready()) {
                        firstfileString2 = reader1.readLine();
                    }
                    if (!secondfileString2.isEmpty()) {
                        secondfileString1 = secondfileString2;
                    } else {
                        secondfileString1 = "";
                    }
                    if (reader2.ready()) {
                        secondfileString2 = reader2.readLine();
                    }
                }
                else {
                    if (firstfileString1.equals(secondfileString2) || secondfileString1.isEmpty()) {

                        if ( !secondfileString1.isEmpty()) {
                            lines.add(new LineItem(Type.ADDED, secondfileString1));
                            secondfileString1 = secondfileString2;
                        } else {
                            lines.add(new LineItem(Type.REMOVED, firstfileString1));
                            firstfileString1 = "";
                        }
                        if (reader2.ready()) {
                            secondfileString2 = reader2.readLine();
                        } else secondfileString2 = "";

                    } else if (secondfileString1.equals(firstfileString2) || firstfileString1.isEmpty() ) {

                        if ( !firstfileString1.isEmpty()) {
                            lines.add(new LineItem(Type.REMOVED, firstfileString1));
                            firstfileString1 = firstfileString2;
                        } else {
                            lines.add(new LineItem(Type.ADDED, secondfileString1));
                            secondfileString1 = "";
                        }
                        if (reader1.ready()) {
                            firstfileString2 = reader1.readLine();
                        } else firstfileString2 = "";

                    }
                }
            }
            reader1.close();
            reader2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (LineItem line : lines) {
            System.out.println(line.type + " " + line.line);
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
