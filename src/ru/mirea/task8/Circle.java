package ru.mirea.task8;

import java.awt.*;

class Circle extends Shape{
    protected int radius;

    public Circle() {
        this.setPos(new Point(0, 0));
        this.setColor(Color.black);
        this.radius = 1;
    }
    public Circle(Point pos, Color color, int radius)
    {
        this.setPos(pos);
        this.setColor(color);
        this.radius = radius;
    }
    public Circle(int posX, int posY, int colR, int colG, int colB, int radius)
    {
        this.setPos(new Point(posX, posY));
        this.setColor(new Color(colR, colG, colB));
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void addToGraphics(Graphics g) {
        g.setColor(color);
        g.fillOval(pos.x, pos.y, (int)radius*2, (int)radius*2);
    }
}
