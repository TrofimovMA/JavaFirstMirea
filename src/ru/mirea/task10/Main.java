package ru.mirea.task10;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Вариант 31

        // 14. Цифры числа слева направо
        Task14();

        // 15. Цифры числа справа налево
        Task15();

        // 16. Количество элементов, равных максимуму
        Task16();

        // 17. Максимум последовательности
        Task17();

        // 1. Треугольная последовательность
        Task1();

    }

    static void Task14()
    {
        System.out.println("Задание 14 : Цифры числа слева направо");
        System.out.print("Введите число: ");
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();

        System.out.print("Цифры числа слева направо: ");
        Task14Helper(inp);
        System.out.print(System.lineSeparator());
    }
    static void Task14Helper(int a)
    {
        if(a >= 10)
            Task14Helper(a / 10);

        System.out.print(a % 10 + " ");
    }

    static void Task15()
    {
        System.out.println("Задание 15 : Цифры числа справа налево");
        System.out.print("Введите число: ");
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();

        System.out.print("Цифры числа справа налево: ");
        Task15Helper(inp);
        System.out.print(System.lineSeparator());
    }
    static void Task15Helper(int a)
    {
        System.out.print(a % 10 + " ");

        if(a >= 10)
            Task15Helper(a / 10);
    }

    static void Task16()
    {
        System.out.println("Задание 16 : Количество элементов, равных максимуму");
        System.out.println("Введите последовательность натуральных чисел (одно число в строке), завершающуюся числом 0: ");

        Task16Helper(0, 0);
    }
    static void Task16Helper(int c, int max)
    {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        if(a==0) {
            System.out.println("Количество элементов, равных максимуму: " + Integer.toString(c));
            return;
        }

        if(a>max) {
            max = a;
            c = 1;
        }else if(a==max) {
            c++;
        }

        Task16Helper(c, max);
    }

    static void Task17()
    {
        System.out.println("Задание 17 : Максимум последовательности");
        System.out.println("Введите последовательность натуральных чисел (одно число в строке), завершающуюся числом 0: ");

        System.out.println("Максимум последовательности: " + Integer.toString(Task17Helper()));
    }
    static int Task17Helper()
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a==0) {
            return 0;
        }
        int futureMax = Task17Helper();
        if(a>futureMax)
            return a;

        return futureMax;
    }

    static void Task1()
    {
        System.out.println("Задание 1 : Треугольная последовательность");
        System.out.print("Введите число n: ");
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();

        System.out.println("Треугольная последовательность из n чисел: " + Task1Helper(inp, 1));
    }
    static String Task1Helper(int numIt, int curIt)
    {
        if(numIt==1)
            return "1 ";

        if(numIt == curIt)
            return Task1Helper(numIt-1, 1) + Integer.toString(numIt) + " ";

        return Task1Helper(numIt, ++curIt) + Integer.toString(numIt) + " ";
    }
}
