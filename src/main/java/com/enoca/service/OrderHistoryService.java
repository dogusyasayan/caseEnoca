package com.enoca.service;

import com.enoca.converter.OrderHistoryConverter;
import com.enoca.domain.OrderHistory;
import com.enoca.exception.OrderNotFoundException;
import com.enoca.model.response.order.OrderHistoryResponse;
import com.enoca.repository.OrderHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderHistoryService {

    private final OrderHistoryRepository orderHistoryRepository;
    private final OrderHistoryConverter orderHistoryConverter;

    public List<OrderHistoryResponse> getAllOrdersForCustomer(Integer customerId) {
        List<OrderHistory> orderHistories = orderHistoryRepository.findAllByOrderCustomerId(customerId);
        return orderHistoryConverter.apply(orderHistories);
    }

    public OrderHistoryResponse getOrderForCode(Integer orderHistoryId) {
        Optional<OrderHistory> optionalOrderHistory = orderHistoryRepository.findById(orderHistoryId);
        if (optionalOrderHistory.isEmpty()) {
            throw new OrderNotFoundException();
        }
        OrderHistory orderHistory = optionalOrderHistory.get();
        return orderHistoryConverter.apply(orderHistory);
    }
}
