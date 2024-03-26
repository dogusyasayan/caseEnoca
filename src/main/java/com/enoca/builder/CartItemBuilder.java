package com.enoca.builder;

import com.enoca.domain.Cart;
import com.enoca.domain.CartItem;
import com.enoca.domain.Product;
import com.enoca.model.request.cart.AddCartRequest;
import com.enoca.service.ProductService;
import com.enoca.util.MathUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CartItemBuilder {

    private final ProductService productService;

    public CartItem buildCartItem(AddCartRequest addCartRequest) {
        Product product = productService.getProductById(addCartRequest.getProductId());
        Double totalPrice = MathUtils.calculateTotalPrice(product.getPrice(), addCartRequest.getQuantity());
        return CartItem.builder()
                .product(product)
                .quantity(addCartRequest.getQuantity())
                .unitPrice(product.getPrice())
                .totalPrice(totalPrice)
                .build();
    }

    public void increaseStockForProduct(CartItem cartItem) {
        Integer productId = cartItem.getProduct().getId();
        Integer quantity = cartItem.getQuantity();
        Product product = productService.getProductById(productId);
        Integer currentStock = product.getStock();
        Integer newStock = MathUtils.increaseStock(currentStock, quantity);
        product.setStock(newStock);
        productService.saveProduct(product);
    }

    public List<CartItem> getCartItems(Cart cart) {
        return cart.getCartItems();
    }
}
