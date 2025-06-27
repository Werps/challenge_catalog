package com.vass.challenge.catalog.application.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductPriceResponse(Long priceList,
                                   Long brandId,
                                   Long productId,
                                   LocalDateTime startDate,
                                   LocalDateTime endDate,
                                   String price) {
}
