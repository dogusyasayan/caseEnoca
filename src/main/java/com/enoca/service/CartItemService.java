package com.enoca.service;

import com.enoca.domain.CartItem;
import com.enoca.repository.CartItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    @Transactional
    public void deleteProductToCart(Integer productId, Integer cartId) {
        List<CartItem> allCartItems = cartItemRepository.findAllByCartIdAndProductId(cartId, productId);
        if (allCartItems.isEmpty()) {
            return;
        }
        cartItemRepository.deleteAll(allCartItems);
    }
}

