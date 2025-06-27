package com.vass.challenge.catalog.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPrice {

    private Long brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Long priceList;

    private Long productId;

    private Integer priority;

    private BigDecimal price;

    private String currency;

}
