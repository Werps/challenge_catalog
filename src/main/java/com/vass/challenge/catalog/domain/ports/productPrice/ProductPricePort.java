package com.vass.challenge.catalog.domain.ports.productPrice;

import com.vass.challenge.catalog.domain.models.ProductPrice;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductPricePort {

    List<ProductPrice> findAllByDate(Long brandId, Long productId, LocalDateTime date);

}
