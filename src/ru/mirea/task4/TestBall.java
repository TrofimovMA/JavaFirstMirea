package ru.mirea.task4;

public class TestBall {
    public void Test()
    {
        Ball b1 = new Ball(100, 100);
        System.out.println(b1);
        b1.move(30,15);
        System.out.println(b1);
    }
}
