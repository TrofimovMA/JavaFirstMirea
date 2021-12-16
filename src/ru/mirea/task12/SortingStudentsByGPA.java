package ru.mirea.task12;

import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {
    public int compare(Student a, Student b){
        if(a.getScore()>b.getScore())
            return 1;
        if(a.getScore()<b.getScore())
            return -1;
        return 0;
    }
}