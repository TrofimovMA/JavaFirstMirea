package ru.mirea.task7;

public class Main {

    public static void main(String[] args) {
        // 1. Создайте абстрактный родительский суперкласс Shape и его дочерние
        //классы (подклассы).
        // 2. Перепишите суперкласс Shape и его подклассы, так как это представлено
        //на диаграмме Circle, Rectangle and Square.
        // 3. Вам нужно написать тестовый класс, чтобы самостоятельно это проверить,
        //необходимо объяснить полученные результаты и связать их с понятием ООП -
        //полиморфизм. Некоторые объявления могут вызвать ошибки компиляции.
        //Объясните полученные ошибки, если таковые имеются.
        Task123();

        // 4. Напишите два класса MovablePoint и MovableCircle - которые реализуют
        //интерфейс Movable.
        //Task4();

        // 5. Напишите новый класс MovableRectangle (движущийся прямоугольник). Его
        //можно представить как две движущиеся точки MovablePoints (представляющих
        //верхняя левая и нижняя правая точки) и реализующие интерфейс Movable.
        //Убедитесь, что две точки имеет одну и ту же скорость (нужен метод это
        //проверяющий).
        //Task5();
    }

    public static void Task123()
    {
        TestClass TC = new TestClass();
        TC.Test();
    }

    public static void Task4()
    {
        MovableCircle MC = new MovableCircle(0,0,1,1,1);
        System.out.println(MC.toString());
        System.out.println("Call moveUp()");
        MC.moveUp();
        System.out.println(MC.toString());
        System.out.println("Call moveDown()");
        MC.moveDown();
        System.out.println(MC.toString());
        System.out.println("Call moveRight()");
        MC.moveRight();
        System.out.println(MC.toString());
        System.out.println("Call moveLeft()");
        MC.moveLeft();
        System.out.println(MC.toString());
    }

    public static void Task5() {
        MovableRectangle MR = new MovableRectangle(0,0,2,1,1, 1);
         if(MR.checkIfSpeedsAreEqual())
            System.out.println("Две точки имеют одну и ту же скорость");
        System.out.println(MR.toString());
        System.out.println("Call moveUp()");
        MR.moveUp();
        System.out.println(MR.toString());
        System.out.println("Call moveDown()");
        MR.moveDown();
        System.out.println(MR.toString());
        System.out.println("Call moveRight()");
        MR.moveRight();
        System.out.println(MR.toString());
        System.out.println("Call moveLeft()");
        MR.moveLeft();
        System.out.println(MR.toString());
    }
}
