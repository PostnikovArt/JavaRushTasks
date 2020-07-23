package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        switch (args[0]) {
            case "-c" :
                synchronized (allPeople) {

                }

                break;

            case "-u" :
                synchronized (allPeople) {

                    HashMap<Integer, String> map = new HashMap<>();
                    Integer key = null;
                    String buffer = "";

                    for (int i = 1; i < args.length; i++) {

                        if ( ! args[i].matches("\\d")) {

                            buffer += args[i] + " ";

                        }
                        else {

                            if (key != null) {
                                map.put(key, buffer.trim());
                            }
                            buffer = "";
                            key = Integer.parseInt(args[i]);
                        }
                    }


                    for (Map.Entry<Integer, String> entry : map.entrySet()) {
                        System.out.println(entry.getKey() + " -- " + entry.getValue());
                    }
//                    for (int i = 1; i < args.length; i++) {
//                        if (allPeople.get(Integer.parseInt(args[i])) == null) {
//                            allPeople.add(Integer.parseInt(args[i]),
//                                    new Person());
//                        }
//                        else {
//                            Person deletedPerson = allPeople.get(Integer.parseInt(args[i]));
//                            deletedPerson.setName(null);
//                            deletedPerson.setSex(null);
//                            deletedPerson.setBirthDate(null);
//                        }
//                    }
                }

                break;

            case "-d" :
                synchronized (allPeople) {

                    for (int i = 1; i < args.length; i++) {
                        if (allPeople.get(Integer.parseInt(args[i])) == null) {
                            allPeople.add(Integer.parseInt(args[i]), new Person(null, null, null));
                        }
                        else {
                            Person deletedPerson = allPeople.get(Integer.parseInt(args[i]));
                            deletedPerson.setName(null);
                            deletedPerson.setSex(null);
                            deletedPerson.setBirthDate(null);
                        }
                    }
                }
                break;

            case "-i" :
                synchronized (allPeople) {

                    for (int i = 1; i < args.length; i++) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        if (person.getName() == null) {
                            System.out.println("null null null");
                        }
                        else {
                            format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                            String birthdayDate = format.format(person.getBirthDate());
                            if (person.getSex() == Sex.MALE) {
                                System.out.println(person.getName() + " м " + birthdayDate);
                            }
                            else {
                                System.out.println(person.getName() + " ж " + birthdayDate);
                            }
                        }
                    }
                }
                break;

        }
    }
}
