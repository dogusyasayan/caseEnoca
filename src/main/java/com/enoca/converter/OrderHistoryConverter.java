package com.enoca.converter;

import com.enoca.domain.OrderHistory;
import com.enoca.model.response.order.OrderHistoryResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderHistoryConverter {
    public List<OrderHistoryResponse> apply(List<OrderHistory> orderHistories) {
        List<OrderHistoryResponse> orderHistoryResponses = new ArrayList<>();
        for (OrderHistory orderHistory : orderHistories) {
            OrderHistoryResponse response = OrderHistoryResponse.builder()
                    .order(orderHistory.getOrder())
                    .product(orderHistory.getProduct())
                    .quantity(orderHistory.getQuantity())
                    .unitPrice(orderHistory.getUnitPrice())
                    .totalPrice(orderHistory.getTotalPrice())
                    .build();
            orderHistoryResponses.add(response);
        }
        return orderHistoryResponses;
    }

    public OrderHistoryResponse apply(OrderHistory orderHistory) {
        return OrderHistoryResponse.builder()
                .order(orderHistory.getOrder())
                .product(orderHistory.getProduct())
                .quantity(orderHistory.getQuantity())
                .unitPrice(orderHistory.getUnitPrice())
                .totalPrice(orderHistory.getTotalPrice())
                .build();
    }
}