package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {

        ZipInputStream zipInputStream = null;
        FileOutputStream outputStream = null;

        String resultFileName = args[0];

        ArrayList<InputStream> parts = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            try {
                parts.add(new FileInputStream(args[i]));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(parts));
        zipInputStream = new ZipInputStream(sequenceInputStream);

        byte[] buffer = new byte[8192];
        try {
            outputStream = new FileOutputStream(resultFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if ((zipInputStream.getNextEntry() == null)) break;

                int b = 0;
                while ((b = zipInputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, b);
                }

                zipInputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
