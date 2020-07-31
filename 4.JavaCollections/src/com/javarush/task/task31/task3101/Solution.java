package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {

        //   #1 Task
        File pathDirectory = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");

        //   #2 Task
        if (FileUtils.isExist(allFilesContent)) {
            FileUtils.deleteFile(allFilesContent);
        }
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

        // #3 Task
        FileWriter writer;
        List<File> files = new ArrayList<>();
        List<String> strings;

        try {
            Files.walkFileTree(pathDirectory.toPath(), new MyFileVisitor(files));
            Collections.sort(files, new Comparator<File>() {
                @Override
                public int compare(File f1, File f2) {
                    return f1.getName().compareTo(f2.getName());
                }
            });

            writer = new FileWriter(allFilesContent);

            for (File file : files) {
                strings = Files.readAllLines(Paths.get(file.getAbsolutePath()));
                for (String string : strings) {
                    writer.write(string);
                }
                writer.write("\n");
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static class MyFileVisitor extends SimpleFileVisitor<Path> {

        List<File> files;

        public MyFileVisitor(List<File> files) {
            this.files = files;
        }

        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
            if (path.toFile().isFile() && path.toFile().length() <= 50) {
                files.add(path.toFile());
            }
            return FileVisitResult.CONTINUE;
        }
    }

//    public static class MyFileVisitor extends SimpleFileVisitor {
//
//        public FileVisitResult visitFile(
//                Path path, File file, FileWriter writer) throws IOException {
//
//            if (path.toFile().isFile() && path.toFile().length() <= 50) {
//                List<String> strings = Files.readAllLines(path);
//                for (String string : strings) {
//                    writer.write(string);
//                }
//            }
//            return FileVisitResult.CONTINUE;
//        }
//    }
}
