package ru.mirea.task6;

class Rectangle extends Shape{
    protected double width;
    protected double length;

    public Rectangle() {
        this.color = "red";
        this.filled = false;
        this.width = 10;
        this.length = 20;
    }
    public Rectangle(double width, double length)
    {
        this.color = "red";
        this.filled = false;
        this.width = width;
        this.length = length;
    }
    public Rectangle(double width, double length, String color, boolean filled)
    {
        this.color = color;
        this.filled = filled;
        this.width = width;
        this.length = length;
    }
    public double getWidth() { return this.width; }
    public void setWidth(double width) { this.width = width; }
    public double getLength() { return this.length; }
    public void setLength(double length) { this.length = length; }

    @Override
    public double getArea() { return width*length; }
    @Override
    public double getPerimeter() { return 2*(width+length); }
    @Override
    public String toString()
    {
        return "Shape: rectangle, width: "+this.width+
                ", length: "+this.length+", color: "+this.color;
    }
}
