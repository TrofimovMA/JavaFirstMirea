package ru.mirea.task5;

// Labrador - лабрадор
// Dachshund - такса

public abstract class Dog
{
    private String name;

    public Dog(String name)
    {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public abstract void displayInfo();
}

class Labrador extends Dog
{
    private int weight;

    public Labrador(String name, int weight)
    {
        super(name);
        this.weight=weight;
    }

    public void displayInfo()
    {
        System.out.println("Labrador { Name: " + super.getName() + " Weight = " + weight + " }");
    }
}

class Dachshund extends Dog
{
    private int length;

    public Dachshund(String name, int length)
    {
        super(name);
        this.length=length;
    }

    public void displayInfo()
    {
        System.out.println("Dachshund { Name: " + super.getName() + " ; Length = " + length + " }");
    }
}





