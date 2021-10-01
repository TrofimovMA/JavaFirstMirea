package ru.mirea.task5;

public class Main {

    // Labrador - лабрадор
    // Dachshund - такса

    public static void main(String[] args)
    {
        //2. Создать абстрактный класс, описывающий собак(Dog). С
        //помощью наследования реализовать различные породы собак.
        //Протестировать работу классов.
        Task2();
    }

    static void Task2()
    {
        Labrador labrador = new Labrador("Labrador1", 10);
        Dachshund dachshund = new Dachshund("Dachshund1", 12);
        labrador.displayInfo();
        dachshund.displayInfo();
    }
}
