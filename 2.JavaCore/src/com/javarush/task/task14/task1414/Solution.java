package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        //ввести с консоли несколько ключей (строк), пункт 7
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> setKeys = new HashSet<>(Arrays.asList("soapOpera","cartoon", "thriller"));
        String key = null;
        while (true) {
            /*
    8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
    8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
    8.2 вывести на экран movie.getClass().getSimpleName()
            */
            key = reader.readLine();
            Movie movie = MovieFactory.getMovie(key);
            if ( ! (setKeys.contains(key))) break;
            System.out.println(movie.getClass().getSimpleName());

        }

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;                //можно через проверку на  null   if(null == movie)   { break; }

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }

            //напишите тут ваш код, пункты 5,6

            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }

            if ("thriller".equals(key)) {
                movie = new Thriller();
            }


            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    //Напишите тут ваши классы, пункт 3

    static class Cartoon extends Movie{

    }
    static class Thriller extends Movie{

    }

}
