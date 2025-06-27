package com.vass.challenge.catalog.application.configuration;

import com.vass.challenge.catalog.domain.ports.productPrice.ProductPricePort;
import com.vass.challenge.catalog.domain.ports.productPrice.ProductPriceService;
import com.vass.challenge.catalog.domain.services.ProductPriceServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ProductPriceService getProductPriceService(final ProductPricePort productPricePort) {
        return new ProductPriceServiceImpl(productPricePort);
    }


}
