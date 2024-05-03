package se.yrgo.domain;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany
    @JoinColumn(name="TUTOR_FK")
    private List<Student> students;

    public Tutor() {}

    public Tutor(String name) {
        this.name= name;
        this.students = new ArrayList<>();
    }

    public String toString() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void addStudentToStudents(Student newStudent) {
        this.students.add(newStudent);
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(this.students);
    }
}
