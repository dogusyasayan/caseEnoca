package com.enoca.builder;

import com.enoca.domain.Cart;
import com.enoca.domain.CartItem;
import com.enoca.domain.Order;
import com.enoca.domain.OrderHistory;
import com.enoca.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class OrderHistoryBuilder {
    public OrderHistory build(Product product, Order order, Cart cart) {
        int totalQuantity = cart.getCartItems().stream().mapToInt(CartItem::getQuantity).sum();
        double totalPrice = cart.getCartItems().stream().mapToDouble(CartItem::getTotalPrice).sum();
        return OrderHistory.builder()
                .order(order)
                .product(product)
                .unitPrice(product.getPrice())
                .totalPrice(totalPrice)
                .quantity(totalQuantity)
                .build();

    }
}
