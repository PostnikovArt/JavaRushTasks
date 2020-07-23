package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут

        String[] params = args;

            Person person = null;
            String name = "";


            switch (params[0]) {

                case ("-c"):
                    for (int i = 1; i < params.length - 2; i++) {
                        if ( ! params[i].equals("")) {
                            name += params[i] + " ";
                        }
                    }
                    name = name.trim();

                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    Date parseDate = null;
                    try {
                        parseDate = format.parse(params[params.length - 1]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    person = (params[params.length - 2].equals("м")) ?
                            Person.createMale(name, parseDate) : Person.createFemale(name, parseDate);

                    allPeople.add(person);
                    System.out.println((allPeople.size() - 1));
//                    System.out.println("id=" + (allPeople.size() - 1));
                    break;

                case ("-u"):
                    for (int i = 2; i < params.length - 2; i++) {
                        if ( ! params[i].equals("")) {
                            name += params[i] + " ";
                        }
                    }
                    name = name.trim();

                    format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    parseDate = null;
                    try {
                        parseDate = format.parse(params[params.length - 1]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    if (params[params.length - 2].equals("м")) {
                        person = Person.createMale(name, parseDate);
                    } else {
                        person = Person.createFemale(name, parseDate);
                    }

                    Person person1 = allPeople.get(Integer.parseInt(params[1]));
                    person1.setName(person.getName());
                    person1.setSex(person.getSex());
                    person1.setBirthDate(person.getBirthDate());
                    break;

                case ("-d"):
                    person = allPeople.get(Integer.parseInt(params[1]));
                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDate(null);
                    break;

                case ("-i"):
                    person = allPeople.get(Integer.parseInt(params[1]));
                    format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    if (person.getSex() == null) {
                        System.out.println("null null null");
                        break;
                    }
                    String birthday = format.format(person.getBirthDate());
                    if (person.getSex() == Sex.MALE) {
                        System.out.println(person.getName() + " м " + birthday);
                    } else {
                        System.out.println(person.getName() + " ж " + birthday);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + params[0]);
            }

//            for (Person people : allPeople) {
//                if (people.getSex() != null) {
//                    if (people.getSex() == Sex.MALE) {
//                        System.out.println(people.getName() + " м " + people.getBirthDate());
//                    } else {
//                        System.out.println(people.getName() + " ж " + people.getBirthDate());
//                    }
//                } else System.out.println("null null null");
//            }
//            System.out.println("---------------------");

//        }
    }
}
