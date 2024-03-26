package com.enoca.controller;

import com.enoca.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartItemController {

    private final CartItemService cartItemServiceService;

    /**
     * Sepetten belirli bir ürünü silmek için kullanılan endpoint.
     *
     * @param productId Silinecek ürünün kimliği
     * @param cartId    Ürünün bulunduğu sepetin kimliği
     */
    @DeleteMapping("/delete/{productId}/{cartId}")
    public void deleteProductToCart(@PathVariable Integer productId, @PathVariable Integer cartId) {
        cartItemServiceService.deleteProductToCart(productId, cartId);
    }
}