package com.ecommerce.product_service.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequestDTO(
        @NotBlank(message = "Name not empty")
        String name,
        String description,
        @Positive(message = "Price is required")
        @NotNull()
        BigDecimal price) {

}
