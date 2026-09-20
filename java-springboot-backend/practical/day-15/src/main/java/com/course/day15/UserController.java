package com.course.day15;

import java.net.URI;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService users;
    public UserController(UserService users) { this.users = users; }

    @GetMapping public List<UserResponse> findAll() { return users.findAll(); }
    @GetMapping("/{id}") public UserResponse get(@PathVariable Long id) { return users.get(id); }

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest req) {
        UserResponse saved = users.create(req);
        return ResponseEntity.created(URI.create("/api/users/" + saved.id())).body(saved);
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Long id, @Valid @RequestBody UserRequest req) {
        return users.update(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        users.delete(id);
        return ResponseEntity.noContent().build();
    }
}
