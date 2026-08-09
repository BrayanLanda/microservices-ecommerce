package com.ecommerce.product_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ecommerce.product_service.dtos.ProductRequestDTO;
import com.ecommerce.product_service.dtos.ProductResponseDTO;
import com.ecommerce.product_service.models.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "id", ignore = true)
    Product toProduct(ProductRequestDTO requestDTO);

    ProductResponseDTO toResponseDTO(Product product);
}   
