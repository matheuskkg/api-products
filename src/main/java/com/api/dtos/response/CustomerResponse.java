package com.api.dtos.response;

public record CustomerResponse(
        Integer id,
        String name,
        String email
) {
}
