package com.course.day19;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    boolean existsByEmail(String email);
}
