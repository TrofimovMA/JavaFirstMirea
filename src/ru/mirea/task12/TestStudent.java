package ru.mirea.task12;

public class TestStudent {
    public void Test()
    {
        Student[] array = new Student[3];
        array[0] = new Student("Сидоров", 3, 100);
        array[1] = new Student("Петров", 2, 90);
        array[2] = new Student("Иванов", 1, 80);

        System.out.print("Исходный массив: \n");
        for (int i = 0; i < array.length; i++)
            System.out.print(i + ". " + array[i].getName() + " (ID: " + array[i].getId() + ")\n");

        System.out.print("< Сортировка Вставками >\n");
        Sorting.insertionSort(array);

        System.out.print("Конечный массив: \n");
        for (int i = 0; i < array.length; i++)
            System.out.print(i + ". " + array[i].getName() + " (ID: " + array[i].getId() + ")\n");
    }
}
