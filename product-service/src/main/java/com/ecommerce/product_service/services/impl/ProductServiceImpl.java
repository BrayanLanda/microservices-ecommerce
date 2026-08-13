package com.ecommerce.product_service.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.product_service.dtos.ProductRequestDTO;
import com.ecommerce.product_service.dtos.ProductResponseDTO;
import com.ecommerce.product_service.exception.ResourceNotFoundException;
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
        Product savedProduct = repository.save(product);
        return mapper.toProductResponseDTO(savedProduct);
    }

    @Override
    public List<ProductResponseDTO> getAllsProducts() {
        return repository.findAll()
                .stream()
                .map(mapper::toProductResponseDTO)
                .toList();
    }

    @Override
    public ProductResponseDTO getProductById(String id) {
        Product product = repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Product", "id", id)
        );
        return mapper.toProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(String id, ProductRequestDTO productRequest) {
        Product product = repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Product", "id", id)
        );
        mapper.updateProductFromRequest(productRequest, product);
        Product updateProduct = repository.save(product);
        return mapper.toProductResponseDTO(updateProduct);
    }

    @Override
    public void deteleProduct(String id) {
        if(!repository.existsById(id))
            throw new ResourceNotFoundException("Product", "id", id);

        repository.deleteById(id);
    }

}
