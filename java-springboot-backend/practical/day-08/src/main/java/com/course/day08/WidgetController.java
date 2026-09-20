package com.course.day08;

import java.net.URI;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/widgets")
public class WidgetController {

    @GetMapping
    public Map<String, String> list() {
        return Map.of("hint", "GET collection → 200");
    }

    @GetMapping("/{id}")
    public Map<String, Object> one(@PathVariable long id) {
        return Map.of("id", id, "hint", "GET resource → 200 or 404");
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> create(@RequestBody Map<String, String> body) {
        return ResponseEntity.created(URI.create("/api/widgets/1")).body(Map.of("status", "created"));
    }

    @PutMapping("/{id}")
    public Map<String, Object> replace(@PathVariable long id, @RequestBody Map<String, String> body) {
        return Map.of("id", id, "mode", "replace");
    }

    @PatchMapping("/{id}")
    public Map<String, Object> patch(@PathVariable long id, @RequestBody Map<String, String> body) {
        return Map.of("id", id, "mode", "partial");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        // 204
    }
}
