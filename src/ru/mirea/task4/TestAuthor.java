package ru.mirea.task4;

public class TestAuthor {
    public void Test()
    {
        Author a1 = new Author("Author1", "a@a.ru", 'M');
        System.out.println(a1);
        a1.setEmail("b@b.ru");
        System.out.println(a1);
    }
}
