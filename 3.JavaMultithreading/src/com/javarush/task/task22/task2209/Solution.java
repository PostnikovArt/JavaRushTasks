package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        String fileName = null;
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String[] buffer = reader.readLine().split(" ");
                for (String s : buffer) {
                    if ( ! s.isEmpty()) {
                    words.add(s);
                }
            }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        ArrayList<String> words = new ArrayList<>(); //TODO !!!!!!!!!!!!!!!!!
//        words.add("Вена");
//        words.add("Амстердам");
//        words.add("Киев");
//        words.add("Нью-Йорк");
//        words.add("Мельбурн");   //TODO !!!!!!!!!!!!!!!!!!!


        String[] strings = words.toArray(new String[words.size()]);
        //...
        StringBuilder result = getLine(strings);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder stringBuilder = new StringBuilder();
        if (words.equals(null)||words.length == 0) return stringBuilder;

        ArrayList<String> list = new ArrayList<>();

        Collections.addAll(list, words);
        Collections.shuffle(list);
        int max = list.size();
        int count = 0;

        LinkedList<String> result = new LinkedList<>();
        while (true) {
            if (list.size() != max +1) {
                count = 0;
                list.clear();
                result.clear();
                Collections.addAll(list, words);
                Collections.shuffle(list);
            }
            result.add(list.remove(0));
            while (list.size() >= 0 && count < max) {

                for (int i = list.size() -1; i > 0; i--) {

                    if (result.get(0).substring(0, 1).toLowerCase().
                            equals(list.get(i).substring(list.get(i).length() -1).toLowerCase())) {
                        result.add(0, list.remove(i));
                        i--;
                    }
                    String lastIndex = result.get(result.size() -1);

                    if (lastIndex.substring(lastIndex.length() -1).toLowerCase().
                            equals(list.get(i).substring(0, 1).toLowerCase())) {
                        result.add(list.remove(i));
                    }
                }

                if (list.size() == 0) {
                    stringBuilder.append(result.get(0));
                    for (int i = 1; i < result.size(); i++) {
                        stringBuilder.append(" " + result.get(i));
                    }
                    return stringBuilder;
                }
                count++;
            }
        }

    }

}
