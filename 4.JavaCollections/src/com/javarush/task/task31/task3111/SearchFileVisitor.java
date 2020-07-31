package com.javarush.task.task31.task3111;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName = "";
    private String partOfContent = "";
    private int minSize = 0;
    private int maxSize = Integer.MAX_VALUE;
    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public String getPartOfName() {
        return partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public int getMinSize() {
        return minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length


        if (file.toFile().getName().contains(getPartOfName())
                && (content.length > getMinSize()) && content.length < getMaxSize()) {

            List<String> strings = Files.readAllLines(file);
            StringBuilder stringBuilder = new StringBuilder();

            for (String string : strings) {
                stringBuilder.append(string + " ");
            }

            if (stringBuilder.toString().contains(getPartOfContent())) {
                foundFiles.add(file);
            }
        }
//        if (file.toFile().getName().contains(getPartOfName()) && stringBuilder.toString().contains(getPartOfContent())
//                && (content.length > getMinSize()) && content.length < getMaxSize()) {
//            foundFiles.add(file);
//        }

        return super.visitFile(file, attrs);
    }
}
