package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {


        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);

//        try (BufferedReader reader = new BufferedReader(new FileReader("/home/artic/IdeaProjects/Tests/test1"))) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String[] buffer = reader.readLine().split(" ");
                String name = "";
                for (int i = 0; i < buffer.length -3; i++) {
                    name += buffer[i] + " ";
                }
                String bd = "";
                for (int i = buffer.length -3; i < buffer.length; i++) {
                    bd += buffer[i] + " ";
                }
                Date date = format.parse(bd.trim());
                PEOPLE.add(new Person(name.trim(), date));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        for (Person person : PEOPLE) {
//            System.out.println(person.getName() + " " + person.getBirthDate());
//        }

    }
}
