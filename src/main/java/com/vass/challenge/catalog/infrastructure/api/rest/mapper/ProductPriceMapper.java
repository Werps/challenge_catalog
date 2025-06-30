package com.vass.challenge.catalog.infrastructure.api.rest.mapper;

import com.vass.challenge.catalog.domain.models.ProductPrice;
import com.vass.challenge.openapi.model.ProductPriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductPriceMapper {

    @Mapping(source = ".", target = "price", qualifiedByName = "formatPrice")
    ProductPriceResponse toRecord(ProductPrice model);

    @Named("formatPrice")
    default String formatPrice(ProductPrice productPrice){
        return String.format("%s %s", productPrice.getPrice().toString(), productPrice.getCurrency());
    }

}
