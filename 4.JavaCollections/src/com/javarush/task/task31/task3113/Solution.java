package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    //private static Object SimpleFileVisitor;
    static int countDirectories = -1; //preVisitDirectory считает и папку вхождения
    static int countFiles = 0;
    static long overSize = 0;

    private static SimpleFileVisitor<Path> simpleFileVisitor;

//    static {
//        simpleFileVisitor = new SimpleFileVisitor<>() {
//
//            @Override
//            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//
//                if (Files.isRegularFile(file)) {
//                    countFiles++;
//                }
//                return FileVisitResult.CONTINUE;
//            }
//
//            @Override
//            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
//                if (Files.isDirectory(dir)) {
//                    countDirectories++;
//                }
//                return FileVisitResult.CONTINUE;
//            }
//        };
//    }

    public static void main(String[] args) throws IOException {

        BufferedReader readDirectory = new BufferedReader( new InputStreamReader(System.in));
        String string = readDirectory.readLine();
        readDirectory.close();

        Path filePath = Paths.get(string);
        if ( ! Files.isDirectory(filePath)) {
            System.out.println(filePath.toAbsolutePath().toString() + " - не папка");
            return;
        }

        Files.walkFileTree(filePath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                if (Files.isRegularFile(file)) {
                    countFiles++;
                    overSize += Files.size(file);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                if (Files.isDirectory(dir)) {
                    countDirectories++;
                }
                return FileVisitResult.CONTINUE;
            }
        });

        System.out.println("Всего папок - " + countDirectories);
        System.out.println("Всего файлов - " + countFiles);
        System.out.println("Общий размер - " + overSize);
    }
}
