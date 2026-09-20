package com.course.day12;

import java.time.Instant;

public record ApiError(Instant timestamp, int status, String error, String message, String path) {}
