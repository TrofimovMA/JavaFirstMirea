package ru.mirea.task14;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // 1. Используйте для организации хранения структуру данных Stack.
        //new Task1();

        // 2. Используйте для организации хранения структуру данных Queue.
        //new Task2();

        // 3. Используйте для организации хранения структуру данных Dequeue.
        //new Task3();

        // 4. Используйте для организации хранения структуру данных ArrayList.
        //new Task4();

        // 5. Реализуйте более усложненный вариант решения задачи из упражнения 1.
        //Реализация должна иметь интерактивный интерфейс для взаимодействия с
        //пользователем.
        //new Task5();
    }

    // Сравнение карт
    public static int compareCards(int a, int b)
    {
        if(a == 0 && b == 9)
            return 1;
        else if(a == 9 && b == 0)
            return -1;
        else if(a > b)
            return 1;
        else if(a < b)
            return -1;
        else
            return 0;
    }
}
