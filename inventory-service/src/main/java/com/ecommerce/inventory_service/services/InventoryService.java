package com.ecommerce.inventory_service.services;

import java.util.List;

import com.ecommerce.inventory_service.dtos.InventoryRequest;
import com.ecommerce.inventory_service.dtos.InventoryResponse;

public interface InventoryService {

    boolean isInStock(String sku, Integer quantity);

    InventoryResponse createInventory(InventoryRequest inventoryRequest);

    List<InventoryResponse> getAllinventory();

    InventoryResponse updateInventory(Long id, InventoryRequest inventoryRequest);

    void deleteInventory(Long id);

    void reduceStock(String sku, Integer quantity);
}
