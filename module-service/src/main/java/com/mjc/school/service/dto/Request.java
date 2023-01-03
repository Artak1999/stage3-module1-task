package com.mjc.school.service.dto;

public record Request (
        Long id,
        String title,
        String content,
        Long authorId
){ }
