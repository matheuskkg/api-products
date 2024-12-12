package com.api.dtos.request;

import com.api.entities.Customer;
import com.api.entities.Product;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderRequest(
        @NotNull Customer customer,
        @NotEmpty List<Product> products
) {
}
