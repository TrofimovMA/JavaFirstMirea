package ru.mirea.task2;

public class TestBall {
    public void Test()
    {
        Ball b1 = new Ball("Red", 1);
        Ball b2 = new Ball("Green", 2);
        Ball b3 = new Ball("Blue");
        b3.setSize(3);
        b3.plusOneSize();
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}
