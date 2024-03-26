package com.enoca.builder;

import com.enoca.domain.Cart;
import com.enoca.domain.CartItem;
import com.enoca.model.enums.CartStatus;
import com.enoca.model.request.cart.AddCartRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class CartBuilder {

    private final CartItemBuilder cartItemBuilder;

    public Cart buildNewCart(AddCartRequest addCartRequest) {
        ArrayList<CartItem> cartItems = new ArrayList<>();
        CartItem cartItem = cartItemBuilder.buildCartItem(addCartRequest);
        cartItems.add(cartItem);
        return Cart.builder()
                .customerId(addCartRequest.getCustomerId())
                .cartStatus(CartStatus.ACTIVE)
                .cartItems(cartItems)
                .build();
    }
}




