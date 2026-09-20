package com.course.day16;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    protected User() {}
    public User(String email) { this.email = email; }
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public Profile getProfile() { return profile; }
    public List<Order> getOrders() { return orders; }
    public void setProfile(Profile profile) {
        this.profile = profile;
        profile.setUser(this);
    }
    public void addOrder(Order order) {
        orders.add(order);
        order.setUser(this);
    }
}
