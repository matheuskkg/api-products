package com.api.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerRequest(
        @NotBlank(message = "Invalid name.") String name,
        @Email(message = "Invalid email.") String email
) {
}
