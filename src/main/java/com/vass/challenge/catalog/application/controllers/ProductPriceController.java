package com.vass.challenge.catalog.application.controllers;

import com.vass.challenge.catalog.application.mappers.ProductPriceMapper;
import com.vass.challenge.catalog.application.responses.ProductPriceResponse;
import com.vass.challenge.catalog.domain.ports.productPrice.ProductPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/price")
@RequiredArgsConstructor
public class ProductPriceController {

    private final ProductPriceMapper productPriceMapper;

    private final ProductPriceService productPriceService;

    @GetMapping("/{brandId}/{productId}/{date}")
    public ResponseEntity<ProductPriceResponse> getProductPrice(@PathVariable(name = "brandId") Long brandId,
                                                                @PathVariable(name = "productId") Long productId,
                                                                @PathVariable(name = "date") LocalDateTime date){
        return ResponseEntity.ok(productPriceMapper.toRecord(
                productPriceService.getProductPriceByDate(brandId,productId,date)));
    }


}
