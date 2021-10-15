package ru.mirea.task2;

public class Main {

    public static void main(String[] args) {
        //1. Реализуйте простейший класс «Cобака».
        Task1();

        //2. Реализуйте простейший класс «Мяч».
        //Task2();

        //3. Реализуйте простейший класс «Книга».
        //Task3();
    }

    static void Task1()
    {
        TestDog TD = new TestDog();
        TD.Test();
    }

    static void Task2()
    {
        TestBall TB = new TestBall();
        TB.Test();
    }

    static void Task3()
    {
        TestBook TB = new TestBook();
        TB.Test();
    }
}
