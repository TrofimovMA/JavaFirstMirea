package ru.mirea.task7;

public class TestClass {
    public void Test()
    {
        Shape s1 = new Circle(5.5, "RED", false); //Upcast Circle to Shape
        System.out.println(s1); //which version? - over by circle
        System.out.println(s1.getArea()); //which version? - over by circle
        System.out.println(s1.getPerimeter()); //which version? - over by circle
        System.out.println(s1.getColor()); // by shape
        System.out.println(s1.isFilled()); // by shape
        //System.out.println(s1.getRadius()); // by shape -> error
        // ERROR
        // s1 - объект типа Shape, у которого нет метода getRadius()

        Circle c1 = (Circle)s1; //Downcast back to Circle
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());

        //Shape s2 = new Shape(); // -> error
        // ERROR
        // Абстрактный класс не может создавать объекты.

        Shape s3 = new Rectangle(1.0, 2.0, "RED", false); // Upcast
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());
        //System.out.println(s3.getLength()); //by shape -> error
        // ERROR
        // s3 - объект типа Shape, у которого нет метода getLength()

        Rectangle r1 = (Rectangle)s3; // downcast
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColor());
        System.out.println(r1.getLength());

        Shape s4 = new Square(6.6); // Upcast
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
        //System.out.println(s4.getSide()); //by shape -> error
        // ERROR
        // s4 - объект типа Shape, у которого нет метода getSide()

        // Take note that we downcast Shape s4 to Rectangle,
        //   which is a superclass of Square, instead of Square
        Rectangle r2 = (Rectangle)s4;
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());
        //System.out.println(r2.getSide()); //by rectangle -> error
        // ERROR
        // r2 - объект типа Rectangle, у которого нет метода getSide()
        System.out.println(r2.getLength());

        // Downcast Rectangle r2 to Square
        Square sq1 = (Square)r2;
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide());
        System.out.println(sq1.getLength());
    }
}
