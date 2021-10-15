package ru.mirea.task6;

public class Main {

    public static void main(String[] args) {
        // 1. Создать интерфейс Nameable, с методом getName(), возвращающим
        //имя объекта, реализующего интерфейс. Проверить работу для
        //различных объектов (например, можно создать классы, описывающие
        //разные сущности, которые могут иметь имя: планеты, машины,
        //животные и т. д.).
        Task1();

        // 2. Реализовать интерфейс Priceable, имеющий метод getPrice(),
        //возвращающий некоторую цену для объекта. Проверить работу для
        //различных классов, сущности которых могут иметь цену.
        //Task2();
    }

    static void Task1() {
        Planet planet = new Planet("Mars");
        Car car = new Car("BMW", 1000000);
        Animal animal = new Animal("Tiger", 80000);

        PrintNameThroughInterface(planet);
        PrintNameThroughInterface(car);
        PrintNameThroughInterface(animal);
    }

    static void PrintNameThroughInterface(Nameable nameable) {
        System.out.println(nameable.getName());
    }

    static void Task2() {
        Car car = new Car("BMW", 1000000);
        Animal animal = new Animal("Tiger", 80000);
        Furniture furniture = new Furniture("Table", 3000);

        PrintPriceThroughInterface(car);
        PrintPriceThroughInterface(animal);
        PrintPriceThroughInterface(furniture);
    }

    static void PrintPriceThroughInterface(Priceable priceable) {
        System.out.println(priceable.getPrice());
    }
}
