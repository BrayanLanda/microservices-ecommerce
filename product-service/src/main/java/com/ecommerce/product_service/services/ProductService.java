package com.ecommerce.product_service.services;

import java.util.List;

import com.ecommerce.product_service.dtos.ProductRequestDTO;
import com.ecommerce.product_service.dtos.ProductResponseDTO;

public interface ProductService {
    ProductResponseDTO createProduct(ProductRequestDTO requestDTO);
    List<ProductResponseDTO> getAllsProducts();
}
