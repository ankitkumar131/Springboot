package com.course.day12;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final Map<Long, UserResponse> store = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public UserResponse create(UserRequest request) {
        boolean taken = store.values().stream().anyMatch(u -> u.email().equalsIgnoreCase(request.email()));
        if (taken) throw new ConflictException("Email already registered");
        UserResponse saved = new UserResponse(seq.getAndIncrement(), request.name(), request.email());
        store.put(saved.id(), saved);
        return saved;
    }

    public UserResponse get(Long id) {
        UserResponse user = store.get(id);
        if (user == null) throw new ResourceNotFoundException("User " + id + " not found");
        return user;
    }

    public List<UserResponse> findAll() { return new ArrayList<>(store.values()); }
}
