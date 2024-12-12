package com.api.dtos.response;

import java.util.List;

public record OrderResponse(
        Integer id,
        CustomerResponse customer,
        List<ProductResponse> products
) {
}
