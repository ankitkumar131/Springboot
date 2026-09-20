package com.course.day11;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryUserRepository {
    private final Map<Long, User> store = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public User save(User user) {
        if (user.getId() == null) user.setId(seq.getAndIncrement());
        store.put(user.getId(), user);
        return user;
    }
    public Optional<User> findById(Long id) { return Optional.ofNullable(store.get(id)); }
    public List<User> findAll() { return new ArrayList<>(store.values()); }
}
