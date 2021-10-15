package ru.mirea.task5;

public class Main {

    public static void main(String[] args)
    {
        //1. Создать абстрактный класс, описывающий посуду(Dish). С
        //помощью наследования реализовать различные виды посуды,
        //имеющие свои свойства и методы. Протестировать работу классов.
        Task1();
        // Примечание:
        // Glass - стакан
        // Plate - тарелка

        //2. Создать абстрактный класс, описывающий собак(Dog). С
        //помощью наследования реализовать различные породы собак.
        //Протестировать работу классов.
        //Task2();
        // Примечание:
        // Labrador - лабрадор
        // Dachshund - такса

        //3. Создать абстрактный класс, описывающий мебель. С помощью
        //наследования реализовать различные виды мебели. Также создать
        //класс FurnitureShop, моделирующий магазин мебели. Протестировать
        //работу классов.
        //Task3();
        // Примечание:
        // Sofa - диван
        // Table - стол
    }

    static void Task1()
    {
        Glass glass = new Glass("Transparent", 250);
        Plate plate = new Plate("White", 25);
        glass.displayInfo();
        plate.displayInfo();
    }

    static void Task2()
    {
        Labrador labrador = new Labrador("Labrador1", 10);
        Dachshund dachshund = new Dachshund("Dachshund1", 12);
        labrador.displayInfo();
        dachshund.displayInfo();
    }

    static void Task3()
    {
        FurnitureShop furnitureShop = new FurnitureShop("FurnitureShop1", "Moscow");
        Sofa sofa = new Sofa("SofaCompany1 - Model1", new int[]{300,80,200});
        Table table = new Table("TableCompany1 - Model1", new int[]{150,150,150});
        furnitureShop.displayInfo();
        sofa.displayInfo();
        table.displayInfo();
    }
}
