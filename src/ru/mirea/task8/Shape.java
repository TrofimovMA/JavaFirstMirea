package ru.mirea.task8;

import javax.swing.*;
import java.awt.*;

public abstract class Shape {
    protected Point pos;
    protected Color color;

    public Shape() {
        this.pos = new Point(0,0);
        this.color = new Color(0,0,0);
    }
    public Shape(Point pos, Color color) {
        this.pos = pos;
        this.color = color;
    }
    public Shape(int posX, int posY, int colR, int colG, int colB) {
        this.pos = new Point(posX, posY);
        this.color = new Color(colR, colG, colB);
    }

    public Point getPos() {
        return this.pos;
    }
    public void setPos(Point pos) {
        this.pos = pos;
    }
    public Color getColor() {
        return this.color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void addToGraphics(Graphics g);
    //public abstract double getArea();

    //public abstract double getPerimeter();

    //public abstract String toString();
}
