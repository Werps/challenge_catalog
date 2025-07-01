package com.vass.challenge.catalog.productPrice;

import com.vass.challenge.catalog.domain.models.ProductPrice;
import com.vass.challenge.catalog.infrastructure.persistence.jpa.entity.ProductPriceEntity;
import com.vass.challenge.catalog.infrastructure.persistence.jpa.mappers.ProductPriceH2SQLRepositoryMapper;
import com.vass.challenge.catalog.infrastructure.persistence.jpa.mappers.ProductPriceH2SQLRepositoryMapperImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ProductPriceH2SQLRepositoryMapperImpl.class)
class ProductPriceH2SQLRepositoryMapperTest {

    @Autowired
    private ProductPriceH2SQLRepositoryMapper mapper;

    @Test
    void shouldReturn(){
        //Given
        Long brandId = 1L;
        Long productId = 35455L;
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

        //Then
        ProductPrice productPrice = mapper.toModel(entity);
        assertEquals(expectedProductPrice.getPriceList(), productPrice.getPriceList());
        assertEquals(expectedProductPrice.getBrandId(), productPrice.getBrandId());
        assertEquals(expectedProductPrice.getStartDate(), productPrice.getStartDate());
        assertEquals(expectedProductPrice.getEndDate(), productPrice.getEndDate());
        assertEquals(expectedProductPrice.getProductId(), productPrice.getProductId());
        assertEquals(expectedProductPrice.getPriority(), productPrice.getPriority());
        assertEquals(expectedProductPrice.getPrice(), productPrice.getPrice());
        assertEquals(expectedProductPrice.getCurrency(), productPrice.getCurrency());
    }

}
