package ru.mirea.task12;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        // 1. Написать тестовый класс, который создает массив класса Student и
        //сортирует массив iDNumber и сортирует его вставками.
        Task1();

        // 2. Напишите класс SortingStudentsByGPA, который реализует интерфейс
        //Comparator таким образом, чтобы сортировать список студентов по их итоговым
        //баллам в порядке убывания с использованием алгоритма быстрой сортировки.
        //Task2();

        // 3. Напишите программу, которая объединяет два списка данных о студентах
        //в один отсортированный список с использованием алгоритма сортировки
        //слиянием.
        //Task3();
    }

    static void Task1()
    {
        TestStudent ts = new TestStudent();
        ts.Test();
    }

    static void Task2()
    {
        Student[] array = new Student[3];
        array[0] = new Student("Сидоров", 3, 80);
        array[1] = new Student("Петров", 2, 90);
        array[2] = new Student("Иванов", 1, 100);

        System.out.print("Исходный массив: \n");
        for (int i = 0; i < array.length; i++)
            System.out.print(i + ". " + array[i].getName() + " (ID: " + array[i].getId() + ") (Score: " + array[i].getScore() + ")\n");

        System.out.print("< Сортировка Quick-Sort>\n");
        Sorting.quickSort(array, new SortingStudentsByGPA());

        System.out.print("Конечный массив: \n");
        for (int i = 0; i < array.length; i++)
            System.out.print(i + ". " + array[i].getName() + " (ID: " + array[i].getId() + ") (Score: " + array[i].getScore() + ")\n");
    }

    static void Task3()
    {
        Student[] array1 = new Student[2];
        Student[] array2 = new Student[2];
        Student[] array;
        array1[0] = new Student("Сидоров", 3, 80);
        array1[1] = new Student("Петров", 2, 90);
        array2[0] = new Student("Иванов", 1, 100);
        array2[1] = new Student("Федоров", 4, 95);

        System.out.print("Исходные массивы: \n");
        System.out.print("- Первый массив: \n");
        printStudentsArray(array1);
        System.out.print("- Второй массив: \n");
        printStudentsArray(array2);

        System.out.print("< Сортировка Merge-Sort>\n");
        array = Sorting.mergeSort(array1, array2, new SortingStudentsByGPA());

        System.out.print("Конечный массив: \n");
        printStudentsArray(array);
    }

    static void printStudentsArray(Student[] array)
    {
        for (int i = 0; i < array.length; i++)
            System.out.print(i + ". " + array[i].getName() + " (ID: " + array[i].getId() + ") (Score: " + array[i].getScore() + ")\n");
    }
}
