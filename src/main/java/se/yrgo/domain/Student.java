package se.yrgo.domain;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String name;

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    public String toString() {
        return  "name: "+ name;
    }
}
