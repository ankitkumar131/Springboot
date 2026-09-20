package com.course.day11;

public final class UserMapper {
    private UserMapper() {}

    public static User toEntity(UserRequest request) {
        return new User(null, request.name(), request.email(), "hash(" + request.password() + ")");
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }
}
