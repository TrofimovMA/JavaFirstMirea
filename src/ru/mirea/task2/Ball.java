package ru.mirea.task2;

public class Ball {
    private String color;
    private int size;

    public Ball(String c, int s){
        color = c;
        size = s;
    }
    public Ball(String c){
        color = c;
        size = 1;
    }
    public Ball(){
        color = "White";
        size = 5;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public String getColor(){
        return color;
    }
    public int getSize() {
        return size;
    }
    public String toString(){
        return "{ Ball : color = "+this.color+"; size = "+this.size+"}";
    }
    public void plusOneSize(){
        size++;
    }
}
