package com.course.day09;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final Map<Long, User> store = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    @GetMapping
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = store.get(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User incoming) {
        long id = seq.getAndIncrement();
        User saved = new User(id, incoming.getName(), incoming.getEmail());
        store.put(id, saved);
        return ResponseEntity.created(URI.create("/api/users/" + id)).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> replace(@PathVariable Long id, @RequestBody User incoming) {
        if (!store.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        User saved = new User(id, incoming.getName(), incoming.getEmail());
        store.put(id, saved);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (store.remove(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
