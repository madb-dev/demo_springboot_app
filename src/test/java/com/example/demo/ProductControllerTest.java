package com.example.demo;

import com.example.config.FileUtils;
import com.example.demo.application.ProductResponse;
import com.example.demo.application.ProductServiceImpl;
import com.example.demo.infrastructure.ProductControllerImpl;
import com.example.demo.infrastructure.ProductRepositoryImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class ProductControllerTest {

  private static final String DATE_DUMMY_CASE_1 = "2020-06-14-10:00";
  private static final String DATE_DUMMY_CASE_2 = "2020-06-14-16:00";
  private static final String DATE_DUMMY_CASE_3 = "2020-06-14-21:00";
  private static final String DATE_DUMMY_CASE_4 = "2020-06-15-10:00";
  private static final String DATE_DUMMY_CASE_5 = "2020-06-16-21:00";
  private static final Integer BRAND_ID_DUMMY = 1;
  private static final Integer PRODUCT_ID_DUMMY = 35455;
  @InjectMocks
  private ProductControllerImpl controller;
  @Mock
  private ProductServiceImpl service;
  @Autowired
  private ProductRepositoryImpl repository;

  @BeforeEach
  public void setup() {
    service = new ProductServiceImpl(repository);
    controller = new ProductControllerImpl(service);
  }

  @Test
  public void getProductByParamsCase1() throws IOException {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(DATE_DUMMY_CASE_1, formatter);
    ResponseEntity<ProductResponse> givenResponse = controller.getProduct(
        dateTime,
        PRODUCT_ID_DUMMY, BRAND_ID_DUMMY);
    String response = FileUtils.mapFromObject(givenResponse.getBody());
    String expected = Files.readString(Path.of(
            "src\\test\\resources\\files\\response_case1_expected.json")).replaceAll("\r", "")
        .replaceAll("\n", "")
        .replaceAll(" ", "");
    Assertions.assertThat(response).isEqualTo(expected);
  }

  @Test
  public void getProductByParamsCase2() throws IOException {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(DATE_DUMMY_CASE_2, formatter);
    ResponseEntity<ProductResponse> givenResponse = controller.getProduct(
        dateTime,
        PRODUCT_ID_DUMMY, BRAND_ID_DUMMY);
    String response = FileUtils.mapFromObject(givenResponse.getBody());
    String expected = Files.readString(Path.of(
            "src\\test\\resources\\files\\response_case2_expected.json")).replaceAll("\r", "")
        .replaceAll("\n", "")
        .replaceAll(" ", "");
    Assertions.assertThat(response).isEqualTo(expected);
  }

  @Test
  public void getProductByParamsCase3() throws IOException {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(DATE_DUMMY_CASE_3, formatter);
    ResponseEntity<ProductResponse> givenResponse = controller.getProduct(
        dateTime,
        PRODUCT_ID_DUMMY, BRAND_ID_DUMMY);
    String response = FileUtils.mapFromObject(givenResponse.getBody());
    String expected = Files.readString(Path.of(
            "src\\test\\resources\\files\\response_case3_expected.json")).replaceAll("\r", "")
        .replaceAll("\n", "")
        .replaceAll(" ", "");
    Assertions.assertThat(response).isEqualTo(expected);
  }

  @Test
  public void getProductByParamsCase4() throws IOException {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(DATE_DUMMY_CASE_4, formatter);
    ResponseEntity<ProductResponse> givenResponse = controller.getProduct(
        dateTime,
        PRODUCT_ID_DUMMY, BRAND_ID_DUMMY);
    String response = FileUtils.mapFromObject(givenResponse.getBody());
    String expected = Files.readString(Path.of(
            "src\\test\\resources\\files\\response_case4_expected.json")).replaceAll("\r", "")
        .replaceAll("\n", "")
        .replaceAll(" ", "");
    Assertions.assertThat(response).isEqualTo(expected);
  }

  @Test
  public void getProductByParamsCase5() throws IOException {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(DATE_DUMMY_CASE_5, formatter);
    ResponseEntity<ProductResponse> givenResponse = controller.getProduct(
        dateTime,
        PRODUCT_ID_DUMMY, BRAND_ID_DUMMY);
    String response = FileUtils.mapFromObject(givenResponse.getBody());
    String expected = Files.readString(Path.of(
            "src\\test\\resources\\files\\response_case5_expected.json")).replaceAll("\r", "")
        .replaceAll("\n", "")
        .replaceAll(" ", "");
    Assertions.assertThat(response).isEqualTo(expected);
  }
}
