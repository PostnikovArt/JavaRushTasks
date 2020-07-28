package com.javarush.task.task09.task0922;

/* 
Какое сегодня число?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String interDate = reader.readLine();
        reader.close();

        SimpleDateFormat interFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = interFormat.parse(interDate);
        SimpleDateFormat outFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        System.out.println(outFormat.format(date).toUpperCase());
    }
}
