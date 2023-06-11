package com.example.demo.infrastructure;

import com.example.demo.domain.Product;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepositoryImpl extends JpaRepository<Product, Integer> {

  @Override
  List<Product> findAll();

  @Query(value = "SELECT * FROM prices WHERE :date >= start_date AND :date <= end_date AND product_id=:productId AND brand_id=:brandId ORDER BY priority DESC LIMIT 1",
      nativeQuery = true)
  Product getProduct(@Param("date") LocalDateTime dateTime, @Param("productId") Integer productId,
      @Param("brandId") Integer brandId);
}
