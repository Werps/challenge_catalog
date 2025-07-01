package com.vass.challenge.catalog.productPrice;

import com.vass.challenge.catalog.domain.models.ProductPrice;
import com.vass.challenge.catalog.domain.ports.productprice.ProductPriceRepository;
import com.vass.challenge.catalog.infrastructure.persistence.jpa.adapters.ProductPriceH2SQLRepositoryImpl;
import com.vass.challenge.catalog.infrastructure.persistence.jpa.entity.ProductPriceEntity;
import com.vass.challenge.catalog.infrastructure.persistence.jpa.mappers.ProductPriceH2SQLRepositoryMapper;
import com.vass.challenge.catalog.infrastructure.persistence.jpa.repositories.ProductPriceJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProductPriceH2SQLRepositoryImplTest {

    private ProductPriceRepository repository;

    private ProductPriceJpaRepository jpaRepository;

    private ProductPriceH2SQLRepositoryMapper mapper;

    @BeforeEach
    void setUp(){
        mapper = mock(ProductPriceH2SQLRepositoryMapper.class);
        jpaRepository = mock(ProductPriceJpaRepository.class);

        repository = new ProductPriceH2SQLRepositoryImpl(mapper, jpaRepository);
    }

    @Test
    void shouldFind(){
        //Given
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime date = LocalDateTime.now();
        LocalDateTime startDate = LocalDateTime.now().minusDays(1);
        LocalDateTime endDate = LocalDateTime.now().plusDays(2);
        Long priceList = 1L;
        Integer priority = 1;
        BigDecimal price = BigDecimal.TEN;
        String currency = "EUR";

        ProductPriceEntity entity = new ProductPriceEntity(
                priceList,
                brandId,
                startDate,
                endDate,
                productId,
                priority,
                price,
                currency
        );

        ProductPrice expectedProductPrice = ProductPrice.builder()
                .priceList(priceList)
                .brandId(brandId)
                .startDate(startDate)
                .endDate(endDate)
                .productId(productId)
                .priority(priority)
                .price(price)
                .currency(currency)
                .build();

        //When
        when(jpaRepository.findByDate(brandId,productId,date)).thenReturn(Optional.of(entity));
        when(mapper.toModel(entity)).thenReturn(expectedProductPrice);

        //Then
        Optional<ProductPrice> result = repository.findByDate(brandId,productId,date);
        assertEquals(result.orElseThrow(),expectedProductPrice);
        verify(jpaRepository).findByDate(brandId,productId,date);
        verify(mapper).toModel(entity);
    }

}
