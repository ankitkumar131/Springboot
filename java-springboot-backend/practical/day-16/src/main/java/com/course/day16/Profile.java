package com.course.day16;

import jakarta.persistence.*;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bio;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    protected Profile() {}
    public Profile(String bio) { this.bio = bio; }
    public Long getId() { return id; }
    public String getBio() { return bio; }
    public void setUser(User user) { this.user = user; }
}
