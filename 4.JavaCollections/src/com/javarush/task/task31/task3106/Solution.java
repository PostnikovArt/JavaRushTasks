package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {
        String resultFileName = args[0];

        Arrays.sort(args,1, args.length-1);
        List<String> allFiles = new LinkedList<>();
        for (int i = 1; i < args.length; i++) {
            allFiles.add(args[i]);
        }
        allFiles.sort(String::compareTo);   //пока не сделал сортировку по String не работало

        List<InputStream> inputStreams = new LinkedList<>();
        for (String file : allFiles) {
            try {
                inputStreams.add(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        FileOutputStream outputStream;
        ZipInputStream zin;

        SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(inputStreams));
        zin = new ZipInputStream(sequenceInputStream);

        byte[] buffer = new byte[8192];
        try {
            outputStream = new FileOutputStream(resultFileName);
            while (zin.getNextEntry() != null) {
                int b = 0;
                while ((b = zin.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, b);
                }
            }
            outputStream.flush();
            outputStream.close();
            zin.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
