package com.enoca.model.response.order;

import com.enoca.domain.Order;
import com.enoca.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderHistoryResponse {

    private Order order;

    private Product product;

    private Integer quantity;

    private Double unitPrice;

    private Double totalPrice;
}
