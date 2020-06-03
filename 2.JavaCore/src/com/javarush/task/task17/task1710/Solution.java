package com.javarush.task.task17.task1710;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

        for (int i = 0; i < args.length; i++) {

            String[] parameters = args[i].split(" ");

            if (parameters[0].equals("-c")) {
                if (parameters[2].equals("м")) {
                    allPeople.add(Person.createMale(parameters[1], new Date(parameters[3])));
                }
                else allPeople.add(Person.createFemale(parameters[1], new Date(parameters[3])));
                System.out.println(allPeople.size() - 1);
            }

            if (parameters[0].equals("-u")) {
                if (parameters[3].equals("MALE")) {
                    allPeople.add(Integer.parseInt(parameters[1]), Person.createMale(parameters[2], new Date(parameters[4])));
                }
                else allPeople.add(Integer.parseInt(parameters[1]),Person.createFemale(parameters[2], new Date(parameters[4])));
            }

            if (parameters[0].equals("-d")) {
                allPeople.remove(Integer.parseInt(parameters[1]));
            }

            if (parameters[0].equals("-i")) {
                Person person = allPeople.get(Integer.parseInt(parameters[1]));
                System.out.print(person.getName() + " ");
                if (person.getSex().equals(Sex.MALE)) {
                    System.out.print("м" + " ");
                }
                else System.out.print("ж" + " ");
                System.out.println(person.getBirthDate());
            }
        }
    }
}
