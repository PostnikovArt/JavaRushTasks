package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private  final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String string = fileScanner.next();
            return null;                                  // TO DO !!!!!!!!!!!!!!!
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
