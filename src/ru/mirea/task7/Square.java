package ru.mirea.task7;

class Square extends Rectangle{
    public Square() {
        this.color = "green";
        this.filled = false;
        this.width = 10;
        this.length = 10;
    }
    public Square(double side)
    {
        this.color = "green";
        this.filled = false;
        this.width = side;
        this.length = side;
    }
    public Square(double side, String color, boolean filled)
    {
        this.color = color;
        this.filled = filled;
        this.width = side;
        this.length = side;
    }
    public double getSide() { return this.width; }
    public void setSide(double side) {
        this.width = side;
        this.length = side;
    }
    @Override
    public void setWidth(double side) { this.width = side; }
    @Override
    public void setLength(double side) { this.length = side; }
    @Override
    public String toString()
    {
        return "Shape: square, width: "+this.width+
                ", length: "+this.length+", color: "+this.color;
    }
}
