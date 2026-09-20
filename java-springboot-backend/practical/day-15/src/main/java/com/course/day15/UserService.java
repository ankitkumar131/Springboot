package com.course.day15;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository users;
    public UserService(UserRepository users) { this.users = users; }

    @Transactional(readOnly = true)
    public List<UserResponse> findAll() {
        return users.findAll().stream().map(u -> new UserResponse(u.getId(), u.getName(), u.getEmail())).toList();
    }

    @Transactional(readOnly = true)
    public UserResponse get(Long id) {
        User u = users.findById(id).orElseThrow(() -> new ResourceNotFoundException("User " + id + " not found"));
        return new UserResponse(u.getId(), u.getName(), u.getEmail());
    }

    @Transactional
    public UserResponse create(UserRequest req) {
        if (users.existsByEmail(req.email())) throw new ConflictException("Email already registered");
        User saved = users.save(new User(req.name(), req.email()));
        return new UserResponse(saved.getId(), saved.getName(), saved.getEmail());
    }

    @Transactional
    public UserResponse update(Long id, UserRequest req) {
        User u = users.findById(id).orElseThrow(() -> new ResourceNotFoundException("User " + id + " not found"));
        u.setName(req.name());
        u.setEmail(req.email());
        return new UserResponse(u.getId(), u.getName(), u.getEmail());
    }

    @Transactional
    public void delete(Long id) {
        if (!users.existsById(id)) throw new ResourceNotFoundException("User " + id + " not found");
        users.deleteById(id);
    }
}
