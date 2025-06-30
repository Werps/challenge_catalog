package com.vass.challenge.catalog.infrastructure.persistence.jpa.mappers;

import com.vass.challenge.catalog.domain.models.ProductPrice;
import com.vass.challenge.catalog.infrastructure.persistence.jpa.entity.ProductPriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductPriceAdapterMapper {

    ProductPrice toModel(ProductPriceEntity entity);

}
