package com.ecommerce.inventory_service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ecommerce.inventory_service.dtos.InventoryRequest;
import com.ecommerce.inventory_service.dtos.InventoryResponse;
import com.ecommerce.inventory_service.models.Inventory;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
    Inventory toModel(InventoryRequest inventoryRequest);

    @Mapping(target = "inStock", expression = "java(inventory.getQuantity() > 0)")
    InventoryResponse toResponse(Inventory inventory);
}
