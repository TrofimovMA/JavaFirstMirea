package ru.mirea.task2;
//TEST

public class Main {
    public static void main(String[] args) {
        //1. Создать класс, описывающий модель окружности (Circle). В классе
        //должны быть описаны нужные свойства окружности и методы для
        //получения, изменения этих свойств. Протестировать работу класса в
        //классе CircleTest, содержащим метод статический main(String[] args).
        //Task1();

        //3. Создать класс, описывающий книгу (Book). В классе должны быть
        //описаны нужные свойства книги(автор, название, год написания и т.
        //д.)и методы для получения, изменения этих свойств. Протестировать
        //работу класса в классе BookTest, содержащим метод статический
        //main(String[] args).
        Task3();
    }

    static void Task1()
    {
        TestCircle TC = new TestCircle();
        TC.Test();
    }

    static void Task3()
    {
        TestBook TB = new TestBook();
        TB.Test();
    }
}
