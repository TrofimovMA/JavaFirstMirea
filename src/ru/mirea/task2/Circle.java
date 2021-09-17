package ru.mirea.task2;

public class Circle {
    double radius;
    double diameter;
    double length;

    public Circle(double r)
    {
        radius = r;
        diameter = r * 2;
        length = 2f * Math.PI * r;
    }
    public void setRadius(double r)
    {
        this.radius = r;
        this.diameter = r * 2;
        this.length = 2f * Math.PI * r;
    }
    public void setDiameter(double d)
    {
        this.diameter = d;
        this.radius = d/2;
        this.length = 2f * Math.PI * (d/2);
    }
    public void setLength(double l)
    {
        this.length = l;
        this.radius = l /2f /Math.PI;
        this.diameter = l/Math.PI;
    }
    public double getRadius()
    {
        return radius;
    }
    public double getDiameter()
    {
        return diameter;
    }
    public double getLength()
    {
        return length;
    }
    public String toString()
    {
        return "{ radius = "+radius+" ; diameter = "+diameter+" ; length = "+length+" }";
    }
}
