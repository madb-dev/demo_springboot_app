package com.example.demo.application;

import com.example.demo.domain.Product;
import com.example.demo.infrastructure.ProductRepositoryImpl;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
  private static final String OUTPUT_DATE_PATTERN = "yyyy-MM-dd HH.mm.ss";
  @Autowired
  private ProductRepositoryImpl repository;

  public ProductServiceImpl(ProductRepositoryImpl repository) {
    this.repository = repository;
  }

  @Override
  public List<Product> findAll() {
    return repository.findAll();
  }

  @Override
  public ProductResponse getProduct(LocalDateTime localDateTime, Integer productId,
      Integer brandId) {
    String inputDate = localDateTime.format(DateTimeFormatter.ofPattern(OUTPUT_DATE_PATTERN));

    LOGGER.info("Sending request to database...");
    return ProductAdapter.adaptToProductResponse(repository.getProduct(
        LocalDateTime.parse(inputDate, DateTimeFormatter.ofPattern(OUTPUT_DATE_PATTERN)), productId,
        brandId));
  }

}
