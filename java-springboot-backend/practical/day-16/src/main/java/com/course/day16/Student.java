package com.course.day16;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses = new HashSet<>();

    protected Student() {}
    public Student(String name) { this.name = name; }
    public Long getId() { return id; }
    public String getName() { return name; }
}
