package com.enoca.converter;

import com.enoca.domain.Cart;
import com.enoca.domain.Customer;
import com.enoca.domain.Order;
import com.enoca.exception.CustomerNotFoundException;
import com.enoca.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderConverter {
    private final CustomerRepository customerRepository;

    public Order apply(Cart cart) {
        Integer customerId = cart.getCustomerId();
        Optional<Customer> customerOptional = customerRepository.findById(Long.valueOf(customerId));
        Customer customer = customerOptional.orElseThrow(CustomerNotFoundException::new);
        return Order.builder()
                .customer(customer)
                .carts(Collections.singletonList(cart))
                .build();
    }
}
