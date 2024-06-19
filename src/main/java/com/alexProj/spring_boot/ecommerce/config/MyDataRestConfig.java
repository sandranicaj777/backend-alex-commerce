package com.alexProj.spring_boot.ecommerce.config;

import com.alexProj.spring_boot.ecommerce.entity.Product;
import com.alexProj.spring_boot.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration

public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[]unsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
        config.getExposureConfiguration().forDomainType(Product.class).withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
        .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));
        //made it read only due to security reasons (credit card credentials)

        config.getExposureConfiguration().forDomainType(ProductCategory.class).withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));

    }
}
