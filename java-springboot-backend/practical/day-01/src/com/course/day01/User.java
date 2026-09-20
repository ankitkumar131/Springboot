package com.course.day01;

/**
 * Day 1 example — immutable user.
 *
 * Records fit API DTOs. JPA entities (Day 14) usually remain classes because
 * Hibernate needs a no-arg constructor and mutable fields.
 */
public record User(Long id, String name, String email, boolean active) {

    public User {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is required");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("email is invalid");
        }
    }

    public User withId(Long newId) {
        return new User(newId, name, email, active);
    }

    public User withEmail(String newEmail) {
        return new User(id, name, newEmail, active);
    }
}
