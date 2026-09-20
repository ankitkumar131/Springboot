package com.course.day19;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
public record EmployeeRequest(@NotBlank String name, @NotBlank @Email String email) {}
