package com.ecommerce.inventory_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InventoryResponse {
    private Long id;
    private String sku;
    private Integer quantity;
    private boolean inStock;
}
