package com.vass.challenge.catalog.infrastructure.api.rest.controller;

import com.vass.challenge.catalog.domain.ports.productprice.ProductPriceService;
import com.vass.challenge.catalog.infrastructure.api.rest.mapper.ProductPriceMapper;
import com.vass.challenge.openapi.api.ProductPriceApi;
import com.vass.challenge.openapi.model.ProductPriceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class ProductPriceController implements ProductPriceApi {

    private final ProductPriceMapper productPriceMapper;

    private final ProductPriceService productPriceService;

    @Override
    public ResponseEntity<ProductPriceResponse> getProductPrice(Long brandId,
                                                                Long productId,
                                                                LocalDateTime date){
        return ResponseEntity.ok(productPriceMapper.toResponse(
                productPriceService.getProductPriceByDate(brandId,productId,date)));
    }

}
