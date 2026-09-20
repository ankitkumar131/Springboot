package com.course.day07;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/users/{id}")
    public String user(@PathVariable Long id,
                       @RequestParam(defaultValue = "short") String view) {
        return "user=" + id + ", view=" + view;
    }

    @GetMapping("/who")
    public ResponseEntity<String> who(@RequestHeader(value = "X-Request-Id", required = false) String rid) {
        return ResponseEntity.ok("requestId=" + rid);
    }
}
