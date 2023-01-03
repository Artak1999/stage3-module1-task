package com.mjc.school.service;

public record Request (
        Long id,
        String title,
        String content,
        Long authorId
){ }
