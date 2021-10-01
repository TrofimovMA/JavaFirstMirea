package ru.mirea.task6;

class Circle extends Shape{
    protected double radius;

    public Circle() {
        this.color = "blue";
        this.filled = false;
        this.radius = 1;
    }
    public Circle(double radius)
    {
        this.color = "blue";
        this.filled = false;
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled)
    {
        this.radius = radius;
        this.setColor(color);
        this.setFilled(filled);
    }
    public double getRadius() { return this.radius; }
    public void setRadius(double radius) { this.radius = radius; }

    @Override
    public double getArea() { return Math.PI*radius*radius; }
    @Override
    public double getPerimeter() { return 2*Math.PI*radius; }
    @Override
    public String toString()
    {
        return "Shape: circle, radius: "+this.radius+", color: "+this.color;
    }
}
