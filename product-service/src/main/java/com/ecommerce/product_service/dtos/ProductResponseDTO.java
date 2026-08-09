package com.ecommerce.product_service.dtos;

import java.math.BigDecimal;

public record ProductResponseDTO(
        String id,
        String name,
        String description,
        BigDecimal price) {

}
