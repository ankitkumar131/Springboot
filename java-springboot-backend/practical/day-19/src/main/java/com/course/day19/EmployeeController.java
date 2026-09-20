package com.course.day19;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeRepository employees;
    public EmployeeController(EmployeeRepository employees) { this.employees = employees; }

    @GetMapping
    public Page<EmployeeResponse> list(Pageable pageable) {
        return employees.findAll(pageable).map(e -> new EmployeeResponse(e.getId(), e.getName(), e.getEmail()));
    }

    @GetMapping("/{id}")
    public EmployeeResponse get(@PathVariable UUID id) {
        Employee e = employees.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return new EmployeeResponse(e.getId(), e.getName(), e.getEmail());
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> create(@Valid @RequestBody EmployeeRequest req) {
        if (employees.existsByEmail(req.email())) throw new RuntimeException("conflict");
        Employee saved = employees.save(new Employee(req.name(), req.email()));
        EmployeeResponse body = new EmployeeResponse(saved.getId(), saved.getName(), saved.getEmail());
        return ResponseEntity.created(URI.create("/api/employees/" + saved.getId())).body(body);
    }
}
