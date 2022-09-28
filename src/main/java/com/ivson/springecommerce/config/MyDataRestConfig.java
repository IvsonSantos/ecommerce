package com.ivson.springecommerce.config;

import com.ivson.springecommerce.model.Product;
import com.ivson.springecommerce.model.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsuportedActions = {
            HttpMethod.DELETE,
            HttpMethod.PUT,
            HttpMethod.POST
        };

        // disable for PRODUCTS
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsuportedActions)))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsuportedActions));

        // disable for PRODUCT_CATEGORY
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsuportedActions)))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsuportedActions));
    }

}
