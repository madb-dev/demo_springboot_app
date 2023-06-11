package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prices")
@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  @Column(name = "brand_id")
  private Integer brandId;
  @Column(name = "start_date")
  private Date startDate;
  @Column(name = "end_date")
  private Date endDate;
  @Id
  @Column(name = "price_list")
  private Integer priceList;
  @Column(name = "product_id")
  private Integer productId;
  @Column(name = "priority")
  private Integer priority;
  @Column(name = "price")
  private Double price;
  @Column(name = "curr")
  private String currency;

}
