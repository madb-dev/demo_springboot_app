package com.example.demo.application;

import com.example.demo.domain.Product;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductService {

  List<Product> findAll();

  ProductResponse getProduct(LocalDateTime localDateTime, Integer productId, Integer brandId);
}
