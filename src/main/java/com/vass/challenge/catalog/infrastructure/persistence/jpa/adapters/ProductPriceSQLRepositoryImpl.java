package com.vass.challenge.catalog.infrastructure.persistence.jpa.adapters;

import com.vass.challenge.catalog.domain.models.ProductPrice;
import com.vass.challenge.catalog.domain.ports.productPrice.ProductPriceRepository;
import com.vass.challenge.catalog.infrastructure.persistence.jpa.mappers.ProductPriceAdapterMapper;
import com.vass.challenge.catalog.infrastructure.persistence.jpa.repositories.ProductPriceJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductPriceSQLRepositoryImpl implements ProductPriceRepository {

    private final ProductPriceAdapterMapper mapper;

    private final ProductPriceJpaRepository productPriceJpaRepository;

    @Override
    public List<ProductPrice> findAllByDate(Long brandId, Long productId, LocalDateTime date) {
        return mapper.toModelList(productPriceJpaRepository.findAllByDate(brandId, productId, date));
    }
}
