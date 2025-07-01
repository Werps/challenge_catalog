package com.vass.challenge.catalog.productPrice;


import com.vass.challenge.catalog.infrastructure.api.rest.controller.ProductPriceController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductPriceIntegrationTest {

    @Autowired
    private ProductPriceController controller;

    private final Long brandId = 1L;

    private final Long productId = 35455L;

    @Test
    void shouldReturnValueCase1(){
        //Given
        LocalDateTime date1 = LocalDateTime.of(2020,6,14,10,0);

        String expectedPrice1 = "35.50 EUR";

        //When
        String price1 = controller.getProductPrice(brandId, productId,date1).getBody().getPrice();

        //Then
        assertEquals(price1,expectedPrice1);
    }

    @Test
    void shouldReturnValueCase2(){
        //Given
        LocalDateTime date2 = LocalDateTime.of(2020,6,14,16,0);

        String expectedPrice2 = "25.45 EUR";

        //When
        String price2 = controller.getProductPrice(brandId, productId,date2).getBody().getPrice();

        //Then
        assertEquals(price2,expectedPrice2);
    }

    @Test
    void shouldReturnValueCase3(){
        //Given
        LocalDateTime date3 = LocalDateTime.of(2020,6,14,21,0);

        String expectedPrice3 = "35.50 EUR";

        //When
        String price3 = controller.getProductPrice(brandId, productId,date3).getBody().getPrice();


        //Then
        assertEquals(price3,expectedPrice3);
    }

    @Test
    void shouldReturnValueCase4(){
        //Given
        LocalDateTime date4 = LocalDateTime.of(2020,6,15,10,0);

        String expectedPrice4 = "30.50 EUR";

        //When
        String price4 = controller.getProductPrice(brandId, productId,date4).getBody().getPrice();

        //Then
        assertEquals(price4,expectedPrice4);
    }

    @Test
    void shouldReturnValueCase5(){
        //Given
        LocalDateTime date5 = LocalDateTime.of(2020,6,16,21,0);
        String expectedPrice5 = "38.95 EUR";

        //When
        String price5 = controller.getProductPrice(brandId, productId,date5).getBody().getPrice();

        //Then
        assertEquals(price5,expectedPrice5);
    }


}
