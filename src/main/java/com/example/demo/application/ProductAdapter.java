package com.example.demo.application;

import com.example.demo.domain.Product;

public class ProductAdapter {

  public static ProductResponse adaptToProductResponse(Product product) {
    return ProductResponse.builder().productId(product.getProductId()).brandId(product.getBrandId())
        .priceList(product.getPriceList()).startDate(product.getStartDate())
        .endDate(product.getEndDate()).price(product.getPrice()).currency(product.getCurrency())
        .build();
  }
}
