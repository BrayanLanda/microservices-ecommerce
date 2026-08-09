package com.ecommerce.product_service.dataloader;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecommerce.product_service.models.Product;
import com.ecommerce.product_service.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TestDataLoader implements CommandLineRunner{
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Product product = Product.builder()
                .name("Samsung 24")
                .description("Smartphone con IA")
                .price(BigDecimal.valueOf(1100000))
                .build();

        productRepository.save(product);
        System.out.println(product);
    }
}
