package ru.mirea.task12;

import java.util.Comparator;

public class Student implements Comparable<Student>{

    private String name;
    private int id;
    private int score;

    Student(String name, int id, int score){
        this.name=name;
        this.id=id;
        this.score=score;
    }

    public int compareTo(Student p){
        if(id>p.id)
            return 1;
        if(id<p.id)
            return -1;
        return 0;
    }

    void setName(String name) { this.name = name; }
    void setId(int id) { this.id = id; }
    void setScore(int score) { this.score = score; }
    int getId() { return id; }
    int getScore() { return score; }
    String getName() { return name; }
}
