package com.vass.challenge.catalog.infrastructure.persistence.jpa.adapters;

import com.vass.challenge.catalog.domain.models.ProductPrice;
import com.vass.challenge.catalog.domain.ports.productPrice.ProductPricePort;
import com.vass.challenge.catalog.infrastructure.persistence.jpa.mappers.ProductPriceAdapterMapper;
import com.vass.challenge.catalog.infrastructure.persistence.jpa.repositories.ProductPriceRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class ProductPriceAdapter implements ProductPricePort {

    private final ProductPriceAdapterMapper mapper;

    private final ProductPriceRepository productPriceRepository;

    @Override
    public List<ProductPrice> findAllByDate(Long brandId, Long productId, LocalDateTime date) {
        return mapper.toModelList(productPriceRepository.findAllByDate(brandId, productId, date));
    }
}
