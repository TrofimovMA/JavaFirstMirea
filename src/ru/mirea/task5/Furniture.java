package ru.mirea.task5;

import java.util.Arrays;

// Примечание:
// Sofa - диван
// Table - стол

public abstract class Furniture
{
    private String model;

    public Furniture(String model)
    {
        this.model = model;
    }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public abstract void displayInfo();
}

class Sofa extends Furniture
{
    private int[] size;

    public Sofa(String model, int[] size)
    {
        super(model);
        this.size = size;
    }

    public void displayInfo()
    {
        System.out.println("Furniture -> Sofa : { Model = " + super.getModel() + " ; Size = " + Arrays.toString(size) + " }");
    }
}

class Table extends Furniture
{
    private int[] size;

    public Table(String model, int[] size)
    {
        super(model);
        this.size = size;
    }

    public void displayInfo()
    {
        System.out.println("Furniture -> Table : { Model = " + super.getModel() + " ; Size = " + Arrays.toString(size) + " }");
    }
}






