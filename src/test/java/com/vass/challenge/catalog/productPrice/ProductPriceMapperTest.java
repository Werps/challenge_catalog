package com.vass.challenge.catalog.productPrice;

import com.vass.challenge.catalog.domain.models.ProductPrice;
import com.vass.challenge.catalog.infrastructure.api.rest.mapper.ProductPriceMapper;
import com.vass.challenge.catalog.infrastructure.api.rest.mapper.ProductPriceMapperImpl;
import com.vass.challenge.openapi.model.ProductPriceResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ProductPriceMapperImpl.class)
class ProductPriceMapperTest {


    @Autowired
    private ProductPriceMapper mapper;

    @Test
    void shouldMapToResponse(){
        //Given
        Long brandId = 1L;
        Long productId = 35455L;
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

        //Then
        ProductPriceResponse response = mapper.toResponse(model);
        assertEquals(expectedResponse.getPriceList(), response.getPriceList());
        assertEquals(expectedResponse.getBrandId(), response.getBrandId());
        assertEquals(expectedResponse.getStartDate(), response.getStartDate());
        assertEquals(expectedResponse.getEndDate(), response.getEndDate());
        assertEquals(expectedResponse.getProductId(), response.getProductId());
        assertEquals(expectedResponse.getPrice(), response.getPrice());
    }

}
