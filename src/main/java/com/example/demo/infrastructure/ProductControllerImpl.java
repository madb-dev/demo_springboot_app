package com.example.demo.infrastructure;

import com.example.demo.application.ProductController;
import com.example.demo.application.ProductResponse;
import com.example.demo.application.ProductService;
import com.example.demo.domain.Product;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/product")
public class ProductControllerImpl implements ProductController {

  private final Logger LOGGER = LoggerFactory.getLogger(ProductControllerImpl.class);
  private static final String INPUT_DATE_PATTERN = "yyyy-MM-dd-HH:mm";
  @Autowired
  private ProductService service;

  public ProductControllerImpl(ProductService service) {
    this.service = service;
  }


  @Override
  @GetMapping("/products")
  public ResponseEntity<List<Product>> getProducts() {
    ResponseEntity<List<Product>> products = null;
    List<Product> productList = service.findAll();
    products = new ResponseEntity<>(productList, HttpStatusCode.valueOf(200));
    return products;
  }

  @Override
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProductResponse> getProduct(
      @RequestParam(name = "date") @DateTimeFormat(pattern = INPUT_DATE_PATTERN) LocalDateTime dateTime,
      @RequestParam(name = "productId") Integer productId,
      @RequestParam(name = "brandId") Integer brandId) {

    LOGGER.info(
        "Receiving call with date: " + dateTime + " , product id: " + productId + " , brand id: "
            + brandId);
    ProductResponse product = service.getProduct(LocalDateTime.from(dateTime), productId, brandId);
    return (product != null) ? new ResponseEntity<>(product, HttpStatus.OK)
        : new ResponseEntity<>(product,
            HttpStatus.NOT_FOUND);
  }
}
