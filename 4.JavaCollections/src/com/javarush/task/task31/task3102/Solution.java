package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {

    public static List<String> getFileTree(String root) throws IOException {

        List<String> strings = new ArrayList<>();
        Path path = Paths.get(root);
        Files.walkFileTree(path, new MyFileVisitor(strings));

        return strings;

    }

    public static void main(String[] args) {

//        try {
//            List<String> strings = getFileTree("/home/artic/IdeaProjects");
//            for (String string : strings) {
//                System.out.println(string);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static class MyFileVisitor extends SimpleFileVisitor {
        List<String> strings;

        public MyFileVisitor(List<String> strings) {
            this.strings = strings;
        }

        @Override
        public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
            Path path = (Path)file;
            strings.add(path.toFile().getAbsolutePath());
            return FileVisitResult.CONTINUE;
        }
    }

}
