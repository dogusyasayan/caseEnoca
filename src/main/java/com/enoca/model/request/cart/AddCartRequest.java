package com.enoca.model.request.cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddCartRequest implements Serializable {
    private Integer customerId;
    private Integer productId;
    private Integer quantity;
}
