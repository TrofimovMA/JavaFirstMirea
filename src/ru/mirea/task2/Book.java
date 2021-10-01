package ru.mirea.task2;

public class Book {
    private String name;
    private String author;
    private int pages;

    public Book(String n, String a, int p){
        name = n;
        author = a;
        pages = p;
    }
    public void setName(String str) { this.name = str; }
    public void setAuthor(String str) {
        this.author = str;
    }
    public void setPages(int num) { this.pages = num; }
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
    public int getPages() {
        return pages;
    }
    public String toString(){
        return "{ Book : name = "+this.name+" ; author = "+this.author+" ; pages = "+this.pages+" }";
    }
}
