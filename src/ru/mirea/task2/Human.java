package ru.mirea.task2;

public class Human {
    String name;
    int age;
    Head head;
    Leg leg;
    Hand hand;
    public Human(String n, int a, int sizeHead, int sizeHand, int sizeLeg)
    {
        name = n;
        age = a;
        head = new Head(sizeHead);
        hand = new Hand(sizeHand);
        leg = new Leg(sizeLeg);
    }
    public String toString()
    {
        return "{ Human : name = "+name+" ; age = " + age +" ; { Head : size = " + head.getSize() + " } ; " +
                "{ Hand : size = "+hand.getSize()+" } ; { Leg : size = " + leg.getSize() +" } }";
    }
    public void setName(String str) { name=str; }
    public void setAge(int num) { age=num; }
    public String getName() { return name; }
    public int getAge() { return age; }
}

