package com.enoca.converter;

import com.enoca.domain.Product;
import com.enoca.model.request.product.UpdateProductRequest;
import com.enoca.model.response.product.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductResponse apply(Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }

    public void apply(UpdateProductRequest updateProductRequest, Product product) {
        product.setPrice(updateProductRequest.getPrice());
    }
}
