package com.enoca.controller;

import com.enoca.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    /**
     * Bir sipariş oluşturmak için kullanılan endpoint.
     *
     * @param cartId Sipariş oluşturulacak sepetin kimliği
     */
    @PostMapping("/place-order/{cartId}")
    public void placeOrder(@PathVariable Integer cartId) {
        orderService.placeOrder(cartId);
    }
}