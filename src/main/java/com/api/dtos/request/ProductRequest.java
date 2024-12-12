package com.api.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record ProductRequest(
        @NotBlank(message = "Invalid name.") String name
) {
}
