package com.course.day16;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int totalCents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    protected Order() {}
    public Order(int totalCents) { this.totalCents = totalCents; }
    public Long getId() { return id; }
    public int getTotalCents() { return totalCents; }
    public void setUser(User user) { this.user = user; }
}
