package com.enoca.service;

import com.enoca.builder.OrderHistoryBuilder;
import com.enoca.builder.ProductBuilder;
import com.enoca.converter.OrderConverter;
import com.enoca.domain.Cart;
import com.enoca.domain.Order;
import com.enoca.domain.OrderHistory;
import com.enoca.domain.Product;
import com.enoca.exception.CartNotFoundException;
import com.enoca.model.enums.CartStatus;
import com.enoca.repository.CartRepository;
import com.enoca.repository.OrderHistoryRepository;
import com.enoca.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderHistoryRepository orderHistoryRepository;

    private final CartRepository cartRepository;

    private final OrderConverter orderConverter;

    private final OrderHistoryBuilder orderHistoryBuilder;

    private final ProductBuilder productBuilder;

    public void placeOrder(Integer cartId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        if (optionalCart.isEmpty()) {
            throw new CartNotFoundException();
        }
        Cart cart = optionalCart.get();
        cart.setCartStatus(CartStatus.COMPLETED);
        Order order = orderConverter.apply(cart);
        Product product = productBuilder.build(cart);
        OrderHistory orderHistory = orderHistoryBuilder.build(product, order, cart);
        cartRepository.save(cart);
        orderRepository.save(order);
        orderHistoryRepository.save(orderHistory);
    }
}
