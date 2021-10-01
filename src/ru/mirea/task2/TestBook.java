package ru.mirea.task2;

public class TestBook {
    public void Test()
    {
        Book b1 = new Book("Book1","Author1",100);
        Book b2 = new Book("Book2","Author2",200);
        Book b3 = new Book("Book3","Author3",300);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}
