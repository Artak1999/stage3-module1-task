package com.mjc.school.service;

import java.time.LocalDateTime;

public record Response(
        Long id,
        String title,
        String content,
        LocalDateTime createDate,
        LocalDateTime lastUpdatedDate,
        Long authorId
) { }
