package com.course.day02;

import java.time.Instant;
import java.util.Objects;

public class Product {

    private Long id;
    private final String sku;
    private final String name;
    private final Instant createdAt;

    public Product(Long id, String sku, String name, Instant createdAt) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product product)) {
            return false;
        }
        return sku != null && sku.equals(product.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }

    @Override
    public String toString() {
        return "Product{id=%s, sku=%s, name=%s, createdAt=%s}"
                .formatted(id, sku, name, createdAt);
    }
}
