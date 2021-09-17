package ru.mirea.task2;

import java.util.Scanner;

public class TestCircle {
    public void Test()
    {
        double r;
        Scanner sc = new Scanner(System.in);
        r = sc.nextDouble();
        Circle c = new Circle(r);
        System.out.println(c);
    }
}
