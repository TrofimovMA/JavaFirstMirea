package ru.mirea.task13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.AbstractList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 1. Протестировать работу коллекции ArrayList.
        //Task1();

        // 2. Протестировать работу коллекции LinkedList.
        //Task2();

        // 3. Создать свою коллекцию, такую же как и ArrayList.
        Task3();
    }

    static void Task1()
    {
        ArrayList<String> states = new ArrayList<String>();
        // добавим в список ряд элементов
        states.add("Германия");
        states.add("Франция");
        states.add("Великобритания");
        states.add("Испания");
        states.add(1, "Италия"); // добавляем элемент по индексу 1

        System.out.println(states.get(1));// получаем 2-й объект
        states.set(1, "Дания"); // установка нового значения для 2-го объекта

        System.out.printf("В списке %d элементов \n", states.size());
        for(String state : states){

            System.out.println(state);
        }

        if(states.contains("Германия")){

            System.out.println("Список содержит государство Германия");
        }

        // удалим несколько объектов
        states.remove("Германия");
        states.remove(0);

        Object[] countries = states.toArray();
        for(Object country : countries){
            System.out.println(country);
        }
    }

    static void Task2()
    {
        LinkedList<String> states = new LinkedList<String>();

        // добавим в список ряд элементов
        states.add("Германия");
        states.add("Франция");
        states.addLast("Великобритания"); // добавляем на последнее место
        states.addFirst("Испания"); // добавляем на первое место
        states.add(1, "Италия"); // добавляем элемент по индексу 1

        System.out.printf("В списке %d элементов \n", states.size());
        System.out.println(states.get(1));
        states.set(1, "Дания");
        for(String state : states){

            System.out.println(state);
        }
        // проверка на наличие элемента в списке
        if(states.contains("Германия")){

            System.out.println("Список содержит государство Германия");
        }

        states.remove("Германия");
        states.removeFirst(); // удаление первого элемента
        states.removeLast(); // удаление последнего элемента

        LinkedList<Person> people = new LinkedList<Person>();
        people.add(new Person("Mike"));
        people.addFirst(new Person("Tom"));
        people.addLast(new Person("Nick"));
        people.remove(1); // удаление второго элемента

        for(Person p : people){

            System.out.println(p.getName());
        }
        Person first = people.getFirst();
        System.out.println(first.getName()); // вывод первого элемента
    }

    static void Task3()
    {
        MyCollection<Integer> col = new MyCollection<Integer>();

        System.out.println("< Добавление элементов 10, 11, 12 в коллекцию MyCollection >");
        col.add(10);
        col.add(11);
        col.add(12);

        col.print();

        System.out.println("< Удаление элемента 11 (индекс 1) из коллекции MyCollection >");
        col.remove(1);

        col.print();
    }
}
