package com.course.day17;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository products;
    public ProductController(ProductRepository products) { this.products = products; }

    @GetMapping
    public Page<Product> list(@RequestParam(required = false) String category,
                              @RequestParam(required = false) String q,
                              @PageableDefault(size = 10, sort = "name") Pageable pageable) {
        if (q != null && !q.isBlank()) return products.search(q, pageable);
        if (category != null) return products.findByCategory(category, pageable);
        return products.findAll(pageable);
    }

    @PostMapping
    public Product create(@RequestBody Product p) { return products.save(p); }
}
