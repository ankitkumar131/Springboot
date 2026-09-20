package com.course.day22;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostRepository posts;
    public PostController(PostRepository posts) { this.posts = posts; }

    @GetMapping
    public Page<Post> list(Pageable pageable) { return posts.findAll(pageable); }

    @GetMapping("/{id}")
    public Post get(@PathVariable String id) {
        return posts.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }

    @PostMapping
    public Post create(@RequestBody Post post) { return posts.save(post); }

    @GetMapping("/search")
    public List<Post> search(@RequestParam String q) {
        return posts.findByTitleContainingIgnoreCase(q);
    }
}
