package ru.mirea.task6;

public class Planet implements Nameable{
    private String name;

    Planet(String name)
    {
        this.name = name;
    }

    public String getName() { return name; };
    public void setName(String name) { this.name = name; };
}
