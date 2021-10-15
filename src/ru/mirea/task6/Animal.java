package ru.mirea.task6;

public class Animal implements Nameable, Priceable {
    private String name;
    private int price;

    public Animal(String name, int price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; };
    public void setName(String name) { this.name = name; };
    public int getPrice() { return price; };
    public void setPrice(int price) { this.price = price; };
}
