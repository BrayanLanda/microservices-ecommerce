package com.ecommerce.product_service.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.product_service.models.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
