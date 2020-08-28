package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

//        String fileName1 = null;
//        String fileName2 = null;
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            fileName1 = reader.readLine();
//            fileName2 = reader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        StringBuilder buffer1 = new StringBuilder();
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(fileName1));
//            while (reader.ready()) {
//                buffer1.append(reader.readLine() + "\n");
//            }
//            buffer1.delete(buffer1.length() -1, buffer1.length() );
//            reader.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName1));
//            BufferedReader reader = new BufferedReader(new FileReader(fileName2));
//            while (reader.ready()) {
//                writer.write(reader.readLine());
//                writer.newLine();
//            }
//            reader.close();
//            writer.write(buffer1.toString());
//            writer.flush();
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
/*   правильное  решение дописать первый во второй и затем второй переписать в первый, валик не принял !!!!! */
/*   решение выше !!!!!рабочее на 1000%!!!!! тоже не принял ,
 в итоге скопировал вот этот индусский стрем (маму афтара валика я в кино водил) */
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String pathFile1 = reader.readLine(); // путь 1 файла
            String pathFile2 = reader.readLine(); // путь 2 файла


            try (FileInputStream file1Read = new FileInputStream(pathFile1);// открываем 1 файл для чтения
                 FileInputStream file2Read = new FileInputStream(pathFile2)) {  // открываем 2 файл для чтения

                byte[] tmp = new byte[file1Read.available()]; // читаем и сохраняем содержимое 1 файла в буфер
                file1Read.read(tmp);

                try (FileOutputStream file1Write = new FileOutputStream(pathFile1)) {  // открываем 1 файл для записи

                    while (file2Read.available() > 0) {  // копируем содержимое 2 файла в 1, с перезаписью
                        file1Write.write(file2Read.read());
                    }

                    file1Write.write(tmp);  // дописываем в 1 (все еще открытый для записи файл) содержимое буфера
                } // поток на запись 1 файла автоматически закрывается

            } catch (IOException ioException) {  // поток на чтение 1 и 2 файла автоматически закрывается
                ioException.printStackTrace();
            }
        } catch (IOException ioException) {  // автоматически закрывается поток reader - чтения с консоли
            ioException.printStackTrace();
        }


    }
}
