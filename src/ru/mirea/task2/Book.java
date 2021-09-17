package ru.mirea.task2;

public class Book {
    String name;
    String author;
    int pages;
    int year;
    public Book(String n, String a, int p, int y)
    {
        name = n;
        author = a;
        pages = p;
        year = y;
    }
    public String toString()
    {
        return "{ name = "+name+" ; author = "+author+
                " ; pages = "+pages+" ; year = "+year+" }";
    }
    public void setName(String str) { name=str; }
    public void setAuthor(String str) { author=str; }
    public void setPages(int num) { pages=num; }
    public void setYear(int num) { year=num; }
    public String getName() { return name; }
    public String getAuthor() { return author; }
    public int getPages() { return pages; }
    public int getYear() { return year; }

}
