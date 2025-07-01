package com.vass.challenge.catalog.productPrice;

import com.vass.challenge.catalog.application.exceptions.ErrorCode;
import com.vass.challenge.catalog.application.exceptions.NotFoundException;
import com.vass.challenge.catalog.application.services.ProductPriceServiceImpl;
import com.vass.challenge.catalog.domain.models.ProductPrice;
import com.vass.challenge.catalog.domain.ports.productprice.ProductPriceRepository;
import com.vass.challenge.catalog.domain.ports.productprice.ProductPriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductPriceServiceImplTest {

    private final Long brandId = 1L;

    private final Long productId = 35455L;

    private final LocalDateTime date = LocalDateTime.now();

    private ProductPriceRepository repository;

    private ProductPriceService service;

    @BeforeEach
    void setUp(){
        repository = mock(ProductPriceRepository.class);
        service = new ProductPriceServiceImpl(repository);
    }

    @Test
    void shouldFind(){
        //Given
        ProductPrice productPriceExpected = ProductPrice.builder()
                        .brandId(brandId)
                        .productId(productId)
                        .priceList(1L)
                        .price(BigDecimal.TEN)
                        .priority(1)
                        .build();

        //When
        when(repository.findByDate(brandId, productId, date)).thenReturn(Optional.of(productPriceExpected));

        //Then
        ProductPrice productPriceResponse = service.getProductPriceByDate(brandId,productId,date);
        assertEquals(productPriceExpected,productPriceResponse);
    }

    @Test
    void shouldFail(){
        //Given
        NotFoundException exception = new NotFoundException(ErrorCode.PRODUCT_PRICE_NOT_FOUND, productId, brandId, date);

        //When
        when(repository.findByDate(brandId, productId, date)).thenThrow(exception);

        //Then
        assertThrows(NotFoundException.class, () -> service.getProductPriceByDate(brandId,productId,date));
    }

}
