package ru.mirea.task5;

public class FurnitureShop
{
    private String name;
    private String address;

    public FurnitureShop(String name, String address)
    {
        this.name = name;
        this.address = address;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public void displayInfo()
    {
        System.out.println("FurnitureShop { Name = " + name + " ; Address = " + address + " }");
    }
}