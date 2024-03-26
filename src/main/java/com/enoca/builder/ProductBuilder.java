package com.enoca.builder;

import com.enoca.domain.Cart;
import com.enoca.domain.CartItem;
import com.enoca.domain.Product;
import com.enoca.model.request.product.CreateProductRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductBuilder {

    public Product createProduct(CreateProductRequest createCarRequest) {
        return Product.builder()
                .name(createCarRequest.getName())
                .description(createCarRequest.getDescription())
                .price(createCarRequest.getPrice())
                .stock(createCarRequest.getStock())
                .build();
    }

    public Product build(Cart cart) {
        List<Product> productList = cart.getCartItems().stream()
                .map(CartItem::getProduct)
                .collect(Collectors.toList());

        Optional<Product> firstProduct = productList.stream().findFirst();

        if (firstProduct.isPresent()) {
            Product firstItem = firstProduct.get();
            return Product.builder()
                    .name(firstItem.getName())
                    .description(firstItem.getDescription())
                    .stock(firstItem.getStock())
                    .price(firstItem.getPrice())
                    .build();
        } else {
            return null;
        }
    }
}
