package com.vass.challenge.catalog.domain.ports.productprice;

import com.vass.challenge.catalog.domain.models.ProductPrice;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ProductPriceRepository {

    Optional<ProductPrice> findByDate(Long brandId, Long productId, LocalDateTime date);

}
