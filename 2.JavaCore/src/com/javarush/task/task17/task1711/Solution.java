package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
        Person person = null;

        switch (args[0]) {
            case "-c" : {
                synchronized (allPeople) {
                    String name = "";
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    for (int i = 1; i < args.length; i++) {
                        if (args[i].equals("м")) {
                            try {
                                i++;
                                Date date = format.parse(args[i]);
                                allPeople.add(Person.createMale(name.trim(), date));
                                System.out.println(allPeople.size() -1);
                                i++;
                                if (i >= args.length) break;
                                name = "";
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                        if (args[i].equals("ж")) {
                            try {
                                i++;
                                Date date = format.parse(args[i]);
                                allPeople.add(Person.createFemale(name.trim(), date));
                                System.out.println(allPeople.size() -1);
                                i++;
                                if (i >= args.length) break;
                                name = "";
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                        name += args[i] + " ";
                    }
                }

                break;
            }
            case "-u" : {

                synchronized (allPeople) {
                    int id = Integer.parseInt(args[1]);
                    String name = "";
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    for (int i = 2; i < args.length; i++) {
                        if (args[i].equals("м")) {
                            try {
                                i++;
                                Date date = format.parse(args[i]);
                                person = allPeople.get(id);
                                person.setName(name.trim());
                                person.setSex(Sex.MALE);
                                person.setBirthDate(date);
                                i++;
                                if (i < args.length) {
                                    id = Integer.parseInt(args[i]);
                                    i++;
                                } else {
                                    break;
                                }
                                name = "";
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                        if (args[i].equals("ж")) {
                            try {
                                i++;
                                Date date = format.parse(args[i]);
                                person = allPeople.get(id);
                                person.setName(name.trim());
                                person.setSex(Sex.FEMALE);
                                person.setBirthDate(date);
                                i++;
                                if (i < args.length) {
                                    id = Integer.parseInt(args[i]);
                                    i++;
                                } else {
                                    break;
                                }
                                name = "";
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                        name += args[i] + " ";
                    }
                }

                break;
            }
            case "-d" : {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                    }
                }
                break;
            }
            case "-i" : {

                synchronized (allPeople) {
                    SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        if (person.getSex().equals(Sex.MALE)) {
                            System.out.println(person.getName() + " м " + format.format(person.getBirthDate()));
                        } else {
                            System.out.println(person.getName() + " ж " + format.format(person.getBirthDate()));
                        }
                    }
                }
                break;
            }
            default:
                synchronized (allPeople) {
                    throw new IllegalStateException("Unexpected value: " + args[0]);
                }
        }

//        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
//        for (Person allPerson : allPeople) {
//            System.out.println(allPerson.getName() + " " + format.format(allPerson.getBirthDate()));
//        }

    }
}
