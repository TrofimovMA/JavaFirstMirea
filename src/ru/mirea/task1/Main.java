package ru.mirea.task1;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //1. Вывести на экран сумму чисел массива с помощью циклов
        //for, while, do while.
        //Task1();

        //2. Вывести на экран аргументы командной строки в цикле for.
        //Task2(args);

        //3. Вывести на экран первые 10 чисел гармонического ряда.
        //Task3();

        //4. Сгенерировать массив целых чисел случайным образом, вывести
        //его на экран, отсортировать его, и снова вывести на экран.
        //Task4();

        //5. Создать метод, вычисляющую факториал числа с помощью
        //цикла, проверить работу метода.
        Task5();
    }

    static void Task1()
    {
        int[] arr = new int[100];
        int i, sum, c=0;
        System.out.println("Введите массив (обозначьте конец массива буквой 'e'): ");
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt())
            arr[c++]=sc.nextInt();
        sc.next(); // пропустить букву 'e'

        // Сумма чисел массива с помощью цикла for
        sum=0;
        for(i=0;i<c;i++)
            sum+=arr[i];
        System.out.println("Sum For: " + sum);

        // Сумма чисел массива с помощью цикла while
        sum=0; i=0;
        while (i<c)
            sum += arr[i++];
        System.out.println("Sum While: " + sum);

        // Сумма чисел массива с помощью цикла do-while
        sum=0; i=0;
        do
            sum += arr[i++];
        while (i<c);
        System.out.println("Sum Do-While: " + sum);
    }

    static void Task2(String[] args)
    {
        for(int i=0;i<args.length;i++)
            System.out.println("Argument " + i + " = " + args[i]);
    }

    static void Task3()
    {
        for(int i=1;i<=10;i++)
        {
            System.out.print("1/"+i+" "+1f/i);
            System.out.print("\n");
        }
    }

    static void Task4()
    {
        Random rnd = new Random();
        int n=10;
        int[] a = new int[n];
        for(int i=0;i<n;i++)
            a[i] = rnd.nextInt(10)+1;
        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
        System.out.print("\n");

        //Bubble Sort
        for(int i=0; i<n-1; i++)
            for (int j=0;j<n-i-1;j++)
            if(a[j] > a[j+1])
            {
                int temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
            }

        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");

    }

    static void Task5()
    {
        int a, f=1;
        System.out.print("Введите число для вычисления его факториала: ");
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        for(int i=1;i<=a;i++)
            f*=i;
        System.out.println("Факториал: " + a +"!" + " = " + f);
    }
}
