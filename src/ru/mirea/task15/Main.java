package ru.mirea.task15;

import java.io.*;
import java.util.Scanner;

public class Main {
    static String fileName = "resources/task15.txt";

    public static void main(String[] args) {
        // 1. Реализовать запись в файл введённой с клавиатуры информации
        Task1();

        // 2. Реализовать вывод информации из файла на экран
        //Task2();

        // 3. Заменить информацию в файле на информацию, введённую с
        //клавиатуры
        //Task3();

        // 4. Добавить в конец исходного файла текст, введённый с клавиатуры
        //Task4();
    }

    static void Task1()
    {
        System.out.println("Введите текст для записи в файл: ");

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        try(FileWriter writer = new FileWriter(fileName, false))
        {
            writer.write(str);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println("ERROR : " + ex.getMessage());
        }
    }

    static void Task2()
    {
        System.out.println("Вывод текста из файла: ");

        try(FileReader reader = new  FileReader(fileName))
        {
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        }
        catch(IOException ex){
            System.out.println("ERROR : " + ex.getMessage());
        }
    }

    static void Task3()
    {
        System.out.println("Введите текст для записи в файл: ");

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        try(FileWriter writer = new FileWriter(fileName, false))
        {
            writer.write(str);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println("ERROR : " + ex.getMessage());
        }
    }

    static void Task4()
    {
        System.out.println("Введите текст для записи в файл: ");

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        try(FileWriter writer = new FileWriter(fileName, true))
        {
            writer.write(str);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println("ERROR : " + ex.getMessage());
        }
    }
}
