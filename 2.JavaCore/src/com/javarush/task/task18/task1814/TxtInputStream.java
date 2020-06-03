package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    //private FileInputStream fio;
    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        try {
            if (!fileName.endsWith(".txt")) {
                //fio = new FileInputStream(fileName);
                super.close();
                throw new UnsupportedFileNameException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}

