package com.course.day01;

import java.util.List;
import java.util.Locale;

/**
 * Business rules live here. The repository is injected — this is dependency
 * injection without Spring. Day 4 is the same idea with a container.
 */
public class UserService {

    private final UserRepository users;

    public UserService(UserRepository users) {
        this.users = users;
    }

    public User create(String name, String email) {
        if (users.existsByEmail(email)) {
            throw new IllegalStateException("Email already registered: " + email);
        }
        return users.save(new User(null, name, email, true));
    }

    public User getById(Long id) {
        return users.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<User> listActive() {
        return users.findAll().stream()
                .filter(User::active)
                .toList();
    }

    public List<User> searchByName(String fragment) {
        String needle = fragment.toLowerCase(Locale.ROOT);
        return users.findAll().stream()
                .filter(u -> u.name().toLowerCase(Locale.ROOT).contains(needle))
                .toList();
    }

    public User updateEmail(Long id, String newEmail) {
        User existing = getById(id);
        boolean takenByOther = users.findAll().stream()
                .anyMatch(u -> !u.id().equals(id) && u.email().equalsIgnoreCase(newEmail));
        if (takenByOther) {
            throw new IllegalStateException("Email already registered: " + newEmail);
        }
        return users.save(existing.withEmail(newEmail));
    }

    public void delete(Long id) {
        getById(id);
        users.deleteById(id);
    }
}
