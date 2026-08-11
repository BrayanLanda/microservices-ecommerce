package com.ecommerce.product_service.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.product_service.dtos.ProductRequestDTO;
import com.ecommerce.product_service.dtos.ProductResponseDTO;
import com.ecommerce.product_service.mapper.ProductMapper;
import com.ecommerce.product_service.models.Product;
import com.ecommerce.product_service.repositories.ProductRepository;
import com.ecommerce.product_service.services.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO requestDTO) {
        Product product = mapper.toProduct(requestDTO);
        repository.save(product);
        return mapper.toProductResponseDTO(product);
    }

    @Override
    public List<ProductResponseDTO> getAllsProducts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllsProducts'");
    }

}
