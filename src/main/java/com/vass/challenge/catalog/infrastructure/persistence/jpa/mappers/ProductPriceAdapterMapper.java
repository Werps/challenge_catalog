package com.vass.challenge.catalog.infrastructure.persistence.jpa.mappers;

import com.vass.challenge.catalog.domain.models.ProductPrice;
import com.vass.challenge.catalog.infrastructure.persistence.jpa.entity.ProductPriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductPriceAdapterMapper {

    List<ProductPrice> toModelList(List<ProductPriceEntity> entityList);

    ProductPrice toModel(ProductPriceEntity entity);

}
