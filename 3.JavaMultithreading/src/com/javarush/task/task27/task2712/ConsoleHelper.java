package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Dish> getAllDishesForOrder() {
        List<Dish> order = new ArrayList<>();
        writeMessage("Выберите блюда из меню. Для завершения введите 'exit'");
        writeMessage(Dish.allDishesToString());
        while (true) {
            String selectedDish = readString();
            if (selectedDish.equals("exit")) break;

            if (selectedDish.isEmpty()) {
                writeMessage("Блюдо не выбрано");
            }

            for (Dish dish : Dish.values()) {
                if (dish.name().equals(selectedDish)) {
                    order.add(dish);
                    break;
                } else writeMessage("Нет такого блюда");
            }
        }
        return order;
    }
}
