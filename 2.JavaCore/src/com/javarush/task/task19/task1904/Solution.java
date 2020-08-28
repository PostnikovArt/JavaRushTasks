package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {


    }

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            Date date = null;
            String[] params = fileScanner.nextLine().split(" ", 4);

            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            try {
                date = format.parse(params[3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Person(params[1], params[2], params[0] , date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
