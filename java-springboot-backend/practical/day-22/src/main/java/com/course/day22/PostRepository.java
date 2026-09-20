package com.course.day22;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
    Page<Post> findByTags(String tag, Pageable pageable);
    List<Post> findByTitleContainingIgnoreCase(String q);
}
