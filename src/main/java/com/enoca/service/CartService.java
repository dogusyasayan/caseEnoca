package com.enoca.service;

import com.enoca.builder.CartBuilder;
import com.enoca.builder.CartItemBuilder;
import com.enoca.converter.CartConverter;
import com.enoca.domain.Cart;
import com.enoca.domain.CartItem;
import com.enoca.exception.CartNotFoundException;
import com.enoca.exception.StockNotFoundException;
import com.enoca.model.enums.CartStatus;
import com.enoca.model.request.cart.AddCartRequest;
import com.enoca.model.request.cart.UpdateCartItemRequest;
import com.enoca.model.response.cart.CartResponse;
import com.enoca.repository.CartRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartBuilder cartBuilder;

    private final CartItemBuilder cartItemBuilder;

    private final CartConverter cartConverter;

    private final CartRepository cartRepository;

    private final StockTrackingService stockTrackingService;


    @Transactional
    public void addProductToCart(AddCartRequest addCartRequest) {
        boolean productAvailableInStock = stockTrackingService.isProductAvailableInStock(addCartRequest.getProductId());
        if (!productAvailableInStock) {
            throw new StockNotFoundException();
        }
        stockTrackingService.decreaseStockForProduct(addCartRequest.getProductId(), addCartRequest.getQuantity());

        Optional<Cart> optionalCart = cartRepository.findByCustomerIdAndCartStatus(addCartRequest.getCustomerId(), CartStatus.ACTIVE);
        if (optionalCart.isEmpty()) {
            Cart cart = cartBuilder.buildNewCart(addCartRequest);
            cartRepository.save(cart);
            return;
        }
        Cart cart = optionalCart.get();
        CartItem cartItem = cartItemBuilder.buildCartItem(addCartRequest);
        cart.getCartItems().add(cartItem);
        cartRepository.save(cart);
    }

    public CartResponse getCartList(Integer cartId) {
        Cart cart = findById(cartId);
        return cartConverter.apply(cart);
    }

    @Transactional
    public void emptyCart(Integer cartId) {
        Cart cart = findById(cartId);
        for (CartItem cartItem : cart.getCartItems()) {
            cartItemBuilder.increaseStockForProduct(cartItem);
        }
        cartRepository.delete(cart);
    }

    public String updateCartItem(Integer cartId, UpdateCartItemRequest updateCartItemRequest) {
        Cart cart = findById(cartId);
        Cart updatedCart = cartConverter.applyUpdate(cart, updateCartItemRequest);
        cartRepository.save(updatedCart);
        return "Cart updated";
    }

    private Cart findById(Integer cartId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        if (optionalCart.isEmpty()) {
            throw new CartNotFoundException();
        }
        return optionalCart.get();
    }
}

