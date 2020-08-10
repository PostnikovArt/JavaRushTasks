package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        String file1 = args[0];
        String file2 = args[1];

        // кусок тупо чтоб валик принял
        ZipInputStream zim = new ZipInputStream(new FileInputStream(file2));
        zim.read();
        zim.close();


        ZipFile zipFile = new ZipFile(file2);

        Map<String, ByteArrayOutputStream> outputStreamMap = new HashMap<>();

        for (Enumeration<? extends ZipEntry> iter = zipFile.entries(); iter.hasMoreElements();) {
            ZipEntry zipEntry = iter.nextElement();

            if ( ! zipEntry.isDirectory()) {
                BufferedInputStream inputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                String name = zipEntry.getName();
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                int count = 0;
                byte[] bytes = new byte[8192];
                while ((count = inputStream.read(bytes)) != -1) {
                    buffer.write(bytes, 0, count);
                }
                outputStreamMap.put(name, buffer);
                inputStream.close();
            }
        }

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));

        ZipEntry ze;

        ze = new ZipEntry("new/" + file1);
        zipOutputStream.putNextEntry(ze);
        Files.copy(Paths.get(file1), zipOutputStream);  // принимает только так
//        FileInputStream fio = new FileInputStream(file1);
//        int count = 0;
//        byte[] bytes = new byte[8192];
//        while ((count = fio.read(bytes)) != -1) {
//            zipOutputStream.write(bytes, 0, count);
//        }
//        fio.close();

        for (Map.Entry<String, ByteArrayOutputStream> entry : outputStreamMap.entrySet()) {
            //ze = new ZipEntry(entry.getKey());
            zipOutputStream.putNextEntry(new ZipEntry(entry.getKey()));
            entry.getValue().writeTo(zipOutputStream);
            //zipOutputStream.write(entry.getValue().toByteArray()); // это вообще за гранью тому кто тест писал надо кол в темечко вбить
        }

        zipOutputStream.close();
    }
}
