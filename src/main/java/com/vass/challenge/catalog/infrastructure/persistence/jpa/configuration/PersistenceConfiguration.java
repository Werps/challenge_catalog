package com.vass.challenge.catalog.infrastructure.persistence.jpa.configuration;

import com.vass.challenge.catalog.domain.ports.productPrice.ProductPricePort;
import com.vass.challenge.catalog.infrastructure.persistence.jpa.adapters.ProductPriceAdapter;
import com.vass.challenge.catalog.infrastructure.persistence.jpa.mappers.ProductPriceAdapterMapper;
import com.vass.challenge.catalog.infrastructure.persistence.jpa.repositories.ProductPriceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {

    @Bean
    public ProductPricePort getProductPricePort(final ProductPriceAdapterMapper mapper, final ProductPriceRepository repository){
        return new ProductPriceAdapter(mapper, repository);
    }

}
