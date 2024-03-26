package com.enoca.controller;

import com.enoca.model.response.order.OrderHistoryResponse;
import com.enoca.service.OrderHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order-history")
@RequiredArgsConstructor
public class OrderHistoryController {

    private final OrderHistoryService orderHistoryService;

    /**
     * Belirli bir müşterinin tüm siparişlerini getirmek için kullanılan endpoint.
     *
     * @param customerId Sipariş geçmişi alınacak müşterinin kimliği
     * @return Belirli müşterinin tüm siparişlerini temsil eden bir liste
     */
    @GetMapping("/get-orders/{customerId}")
    public List<OrderHistoryResponse> getAllOrdersForCustomer(@PathVariable Integer customerId) {
        return orderHistoryService.getAllOrdersForCustomer(customerId);
    }

    /**
     * Belirli bir siparişin detaylarını getirmek için kullanılan endpoint.
     *
     * @param orderHistoryId Getirilecek siparişin kimliği
     * @return Belirli siparişin detaylarını temsil eden bir yanıt nesnesi
     */
    @GetMapping("/get/{orderHistoryId}")
    public OrderHistoryResponse getOrderForCode(@PathVariable Integer orderHistoryId) {
        return orderHistoryService.getOrderForCode(orderHistoryId);
    }
}
