package com.vass.challenge.catalog.productPrice;

import com.vass.challenge.catalog.domain.models.ProductPrice;
import com.vass.challenge.catalog.domain.ports.productprice.ProductPriceService;
import com.vass.challenge.catalog.infrastructure.api.rest.controller.ProductPriceController;
import com.vass.challenge.catalog.infrastructure.api.rest.mapper.ProductPriceMapper;
import com.vass.challenge.openapi.api.ProductPriceApi;
import com.vass.challenge.openapi.model.ProductPriceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProductPriceControllerTest {

    private ProductPriceMapper mapper;

    private ProductPriceService service;

    private ProductPriceApi api;

    @BeforeEach
    void setUp(){
        mapper = mock(ProductPriceMapper.class);
        service = mock(ProductPriceService.class);
        api = new ProductPriceController(mapper, service);
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
        BigDecimal price = new BigDecimal("10.50");
        String currency = "EUR";
        String priceResponse = "10.50 EUR";

        ProductPrice model = ProductPrice.builder()
                .priceList(priceList)
                .brandId(brandId)
                .startDate(startDate)
                .endDate(endDate)
                .productId(productId)
                .priority(priority)
                .price(price)
                .currency(currency)
                .build();

        ProductPriceResponse expectedResponse = new ProductPriceResponse()
                .productId(productId)
                .brandId(brandId)
                .startDate(startDate)
                .endDate(endDate)
                .priceList(priceList)
                .price(priceResponse);

        //When
        when(service.getProductPriceByDate(brandId,productId,date)).thenReturn(model);
        when(mapper.toResponse(model)).thenReturn(expectedResponse);

        //Then
        ProductPriceResponse response = api.getProductPrice(brandId,productId,date).getBody();
        verify(service).getProductPriceByDate(brandId,productId,date);
        verify(mapper).toResponse(model);
        assertEquals(expectedResponse, response);
    }

}
