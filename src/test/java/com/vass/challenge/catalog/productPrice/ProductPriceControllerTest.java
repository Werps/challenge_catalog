package com.vass.challenge.catalog.productPrice;


import com.vass.challenge.catalog.application.controllers.ProductPriceController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductPriceControllerTest {

    @Autowired
    private ProductPriceController controller;

    @Test
    void shouldReturnValue(){
        //Given
        Long brandId = 1L;
        Long productId = 35455L;

        LocalDateTime date1 = LocalDateTime.of(2020,6,14,10,0);
        LocalDateTime date2 = LocalDateTime.of(2020,6,14,16,0);
        LocalDateTime date3 = LocalDateTime.of(2020,6,14,21,0);
        LocalDateTime date4 = LocalDateTime.of(2020,6,15,10,0);
        LocalDateTime date5 = LocalDateTime.of(2020,6,16,21,0);

        String expectedPrice1 = "35.50 EUR";
        String expectedPrice2 = "25.45 EUR";
        String expectedPrice3 = "35.50 EUR";
        String expectedPrice4 = "30.50 EUR";
        String expectedPrice5 = "38.95 EUR";

        //When
        String price1 = controller.getProductPrice(brandId, productId,date1).getBody().price();
        String price2 = controller.getProductPrice(brandId, productId,date2).getBody().price();
        String price3 = controller.getProductPrice(brandId, productId,date3).getBody().price();
        String price4 = controller.getProductPrice(brandId, productId,date4).getBody().price();
        String price5 = controller.getProductPrice(brandId, productId,date5).getBody().price();


        //Then
        assertEquals(price1,expectedPrice1);
        assertEquals(price2,expectedPrice2);
        assertEquals(price3,expectedPrice3);
        assertEquals(price4,expectedPrice4);
        assertEquals(price5,expectedPrice5);
    }


}
