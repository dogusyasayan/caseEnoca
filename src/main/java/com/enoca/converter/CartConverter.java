package com.enoca.converter;

import com.enoca.domain.Cart;
import com.enoca.domain.CartItem;
import com.enoca.model.request.cart.UpdateCartItemRequest;
import com.enoca.model.response.cart.CartItemResponse;
import com.enoca.model.response.cart.CartResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartConverter {

    public CartResponse apply(Cart cart) {
        List<CartItemResponse> cartItemResponses = new ArrayList<>();
        for (CartItem cartItem : cart.getCartItems()) {
            CartItemResponse cartItemResponse = CartItemResponse.builder()
                    .productId(cartItem.getProduct().getId())
                    .productName(cartItem.getProduct().getName())
                    .quantity(cartItem.getQuantity())
                    .unitPrice(cartItem.getUnitPrice())
                    .totalPrice(cartItem.getTotalPrice())
                    .build();
            cartItemResponses.add(cartItemResponse);
        }
        return CartResponse.builder()
                .cartItems(cartItemResponses)
                .build();
    }

    public Cart applyUpdate(Cart cart, UpdateCartItemRequest updateCartItemRequest) {
        List<CartItem> updatedCartItems = new ArrayList<>();
        for (CartItem cartItem : cart.getCartItems()) {
            cartItem.setQuantity(updateCartItemRequest.getQuantity());
            cartItem.setUnitPrice(updateCartItemRequest.getUnitPrice());
            cartItem.setTotalPrice(updateCartItemRequest.getTotalPrice());
            updatedCartItems.add(cartItem);
        }
        cart.setCartItems(updatedCartItems);
        return cart;
    }
}