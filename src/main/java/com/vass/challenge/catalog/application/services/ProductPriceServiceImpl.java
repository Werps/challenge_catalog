package com.vass.challenge.catalog.application.services;

import com.vass.challenge.catalog.application.exceptions.ErrorCode;
import com.vass.challenge.catalog.application.exceptions.NotFoundException;
import com.vass.challenge.catalog.domain.models.ProductPrice;
import com.vass.challenge.catalog.domain.ports.productPrice.ProductPriceRepository;
import com.vass.challenge.catalog.domain.ports.productPrice.ProductPriceService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;


@RequiredArgsConstructor
public class ProductPriceServiceImpl implements ProductPriceService {

    private final ProductPriceRepository productPriceRepository;

    @Override
    public ProductPrice getProductPriceByDate(Long brandId, Long productId, LocalDateTime date) {
        List<ProductPrice> productPriceList = productPriceRepository.findAllByDate(brandId, productId, date);

        return productPriceList.stream()
                .max(Comparator.comparing(ProductPrice::getPriority))
                .orElseThrow(() -> new NotFoundException(ErrorCode.PRODUCT_PRICE_NOT_FOUND, productId, brandId, date));
    }

}
