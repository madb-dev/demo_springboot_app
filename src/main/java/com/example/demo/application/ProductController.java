package com.example.demo.application;

import com.example.demo.domain.Product;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface ProductController {

  ResponseEntity<List<Product>> getProducts();

  ResponseEntity<ProductResponse> getProduct(LocalDateTime dateTime, Integer productId,
      Integer brandId);
}
