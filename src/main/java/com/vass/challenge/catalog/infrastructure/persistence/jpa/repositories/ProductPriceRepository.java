package com.vass.challenge.catalog.infrastructure.persistence.jpa.repositories;

import com.vass.challenge.catalog.infrastructure.persistence.jpa.entity.ProductPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPriceEntity, Long> {

    @Query("SELECT pce FROM ProductPriceEntity pce " +
            "WHERE pce.brandId = :brandId " +
            "AND pce.productId = :productId " +
            "AND (:date BETWEEN pce.startDate AND pce.endDate)")
    List<ProductPriceEntity> findAllByDate(@Param("brandId") Long brandId,
                                           @Param("productId") Long productId,
                                           @Param("date") LocalDateTime date);

}
