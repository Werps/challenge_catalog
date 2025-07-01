package com.vass.challenge.catalog.domain.ports.productprice;

import com.vass.challenge.catalog.domain.models.ProductPrice;

import java.time.LocalDateTime;

public interface ProductPriceService {

    ProductPrice getProductPriceByDate(Long brandId, Long productId, LocalDateTime date);

}
