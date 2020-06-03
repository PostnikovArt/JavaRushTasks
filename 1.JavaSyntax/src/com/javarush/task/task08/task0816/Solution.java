package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне2", dateFormat.parse("JUN 1 2012"));
        map.put("Сталлоне3", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне4", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне5", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне6", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне7", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне8", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне9", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне10", dateFormat.parse("MAY 1 2012"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        Calendar calendarBegin = new GregorianCalendar(2012, 4, 31);
        Date dateBegin = calendarBegin.getTime();
        Calendar calendarEnd = new GregorianCalendar(2012, 8, 1);
        Date dateEnd = calendarEnd.getTime();

        Map<String, Date> buffer = new HashMap<>();
        buffer.putAll(map);

        for (Map.Entry<String, Date> stringDateEntry : buffer.entrySet()) {
            if (stringDateEntry.getValue().after(dateBegin) && stringDateEntry.getValue().before(dateEnd)) {
                map.remove(stringDateEntry.getKey(), stringDateEntry.getValue());
            }
        }

    }

    public static void main(String[] args) {

    }
}
