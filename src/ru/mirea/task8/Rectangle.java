package ru.mirea.task8;

import java.awt.*;

class Rectangle extends Shape{
    protected Dimension size;

    public Rectangle() {
        this.setPos(new Point(0, 0));
        this.setColor(Color.black);
        this.size = new Dimension(100, 50);
    }
    public Rectangle(Point pos, Color color, Dimension size)
    {
        this.setPos(pos);
        this.setColor(color);
        this.size = size;
    }
    public Rectangle(int posX, int posY, int colR, int colG, int colB, int width, int height)
    {
        this.setPos(new Point(posX, posY));
        this.setColor(new Color(colR, colG, colB));
        this.size = new Dimension(width, height);
    }

    public Dimension getSize() {
        return this.size;
    }
    public void setSize(Dimension size) {
        this.size = size;
    }

    @Override
    public void addToGraphics(Graphics g) {
        g.setColor(color);
        g.fillRect(pos.x, pos.y, size.width, size.height);
    }
}
