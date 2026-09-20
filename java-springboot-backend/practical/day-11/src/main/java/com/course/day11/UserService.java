package com.course.day11;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private final InMemoryUserRepository users;
    public UserService(InMemoryUserRepository users) { this.users = users; }

    public List<UserResponse> findAll() {
        return users.findAll().stream().map(UserMapper::toResponse).toList();
    }
    public UserResponse get(Long id) {
        User user = users.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return UserMapper.toResponse(user);
    }
    public UserResponse create(UserRequest request) {
        User saved = users.save(UserMapper.toEntity(request));
        return UserMapper.toResponse(saved);
    }
}
