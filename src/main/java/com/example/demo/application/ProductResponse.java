package com.example.demo.application;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

  private Integer brandId;
  private Date startDate;
  private Date endDate;
  private Integer priceList;
  private Integer productId;
  private Double price;
  private String currency;
}
