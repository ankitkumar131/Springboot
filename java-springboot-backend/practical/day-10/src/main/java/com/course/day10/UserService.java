package com.course.day10;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private final UserRepository users;

    public UserService(UserRepository users) {
        this.users = users;
    }

    public List<User> findAll() {
        return users.findAll();
    }

    public User getById(Long id) {
        return users.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + id + " not found"));
    }

    public User create(User incoming) {
        if (incoming.getEmail() != null && users.existsByEmail(incoming.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already registered");
        }
        incoming.setId(null);
        return users.save(incoming);
    }

    public User replace(Long id, User incoming) {
        getById(id);
        incoming.setId(id);
        return users.save(incoming);
    }

    public void delete(Long id) {
        getById(id);
        users.deleteById(id);
    }
}
