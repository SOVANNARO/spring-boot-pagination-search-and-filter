package org.tutorials.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.tutorials.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.Optional;

public interface ProductService {
    Page<ProductDTO> getProducts(String name, String category, BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);
    ProductDTO createProduct(ProductDTO productDTO);
    Optional<ProductDTO> getProductById(Long id);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    void deleteProduct(Long id);
}