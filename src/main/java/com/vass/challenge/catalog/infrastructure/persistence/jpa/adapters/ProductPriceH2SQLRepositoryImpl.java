package com.vass.challenge.catalog.infrastructure.persistence.jpa.adapters;

import com.vass.challenge.catalog.domain.models.ProductPrice;
import com.vass.challenge.catalog.domain.ports.productprice.ProductPriceRepository;
import com.vass.challenge.catalog.infrastructure.persistence.jpa.mappers.ProductPriceH2SQLRepositoryMapper;
import com.vass.challenge.catalog.infrastructure.persistence.jpa.repositories.ProductPriceJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductPriceH2SQLRepositoryImpl implements ProductPriceRepository {

    private final ProductPriceH2SQLRepositoryMapper mapper;

    private final ProductPriceJpaRepository productPriceJpaRepository;

    @Override
    public Optional<ProductPrice> findByDate(Long brandId, Long productId, LocalDateTime date) {
        return productPriceJpaRepository.findByDate(brandId, productId, date)
                .map(mapper::toModel);
    }
}
