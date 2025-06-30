package com.vass.challenge.catalog.application.services;

import com.vass.challenge.catalog.application.exceptions.ErrorCode;
import com.vass.challenge.catalog.application.exceptions.NotFoundException;
import com.vass.challenge.catalog.domain.models.ProductPrice;
import com.vass.challenge.catalog.domain.ports.productPrice.ProductPriceRepository;
import com.vass.challenge.catalog.domain.ports.productPrice.ProductPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductPriceServiceImpl implements ProductPriceService {

    private final ProductPriceRepository productPriceRepository;

    @Override
    public ProductPrice getProductPriceByDate(Long brandId, Long productId, LocalDateTime date) {
        return productPriceRepository.findByDate(brandId, productId, date)
                .orElseThrow(() -> new NotFoundException(ErrorCode.PRODUCT_PRICE_NOT_FOUND, productId, brandId, date));
    }

}
