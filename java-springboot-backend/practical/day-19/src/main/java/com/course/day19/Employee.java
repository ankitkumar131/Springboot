package com.course.day19;

import java.util.UUID;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(nullable = false) private String name;
    @Column(nullable = false, unique = true) private String email;
    protected Employee() {}
    public Employee(String name, String email) { this.name = name; this.email = email; }
    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}
