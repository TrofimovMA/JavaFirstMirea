package ru.mirea.task5;

// Примечание:
// Glass - стакан
// Plate - тарелка

public abstract class Dish
{
    private String color;

    public Dish(String color)
    {
        this.color = color;
    }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public abstract void displayInfo();
}

class Glass extends Dish
{
    private int capacity;

    public Glass(String color, int capacity)
    {
        super(color);
        this.capacity=capacity;
    }

    public void displayInfo()
    {
        System.out.println("Dish -> Glass : { Color = " + super.getColor() + " ; Capacity = " + capacity + " }");
    }
}

class Plate extends Dish
{
    private int diameter;

    public Plate(String color, int diameter)
    {
        super(color);
        this.diameter=diameter;
    }

    public void displayInfo()
    {
        System.out.println("Dish -> Plate : { Color = " + super.getColor() + " ; Diameter = " + diameter + " }");
    }
}


