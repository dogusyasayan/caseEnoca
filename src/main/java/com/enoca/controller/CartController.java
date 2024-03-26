package com.enoca.controller;

import com.enoca.model.request.cart.AddCartRequest;
import com.enoca.model.request.cart.UpdateCartItemRequest;
import com.enoca.model.response.cart.CartResponse;
import com.enoca.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    /**
     * Sepete ürün eklemek için kullanılan endpoint.
     *
     * @param addCartRequest Sepete eklenecek ürün bilgilerini içeren istek nesnesi
     */
    @PostMapping("/add")
    public void addProductToCart(@RequestBody AddCartRequest addCartRequest) {
        cartService.addProductToCart(addCartRequest);
    }

    /**
     * Belirli bir sepetin içeriğini getirmek için kullanılan endpoint.
     *
     * @param cartId İstenen sepetin kimliği
     * @return İstenen sepetin içeriğini temsil eden yanıt nesnesi
     */
    @GetMapping("/get/{cartId}")
    public CartResponse getCartList(@PathVariable Integer cartId) {
        return cartService.getCartList(cartId);
    }

    /**
     * Belirli bir sepeti boşaltmak için kullanılan endpoint.
     *
     * @param cartId Boşaltılacak sepetin kimliği
     */
    @DeleteMapping("/empty/{cartId}")
    public void emptyCart(@PathVariable Integer cartId) {
        cartService.emptyCart(cartId);
    }

    /**
     * Sepet içeriğindeki bir öğeyi güncellemek için kullanılan endpoint.
     *
     * @param cartId                Sepetin kimliği
     * @param updateCartItemRequest Güncellenecek öğe ve yeni miktar bilgisini içeren istek nesnesi
     * @return Güncellenmiş öğenin durumunu temsil eden bir mesaj
     */
    @PutMapping("/update-cart/{cartId}")
    public String updateCartItem(@PathVariable Integer cartId, @RequestBody UpdateCartItemRequest updateCartItemRequest) {
        return cartService.updateCartItem(cartId, updateCartItemRequest);
    }
}