package com.enoca.builder;

import com.enoca.domain.Customer;
import com.enoca.model.request.customer.CreateCustomerRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomerBuilder {
    public Customer createCustomer(CreateCustomerRequest createCustomerRequest) {
        return Customer.builder()
                .name(createCustomerRequest.getName())
                .address(createCustomerRequest.getAddress())
                .email(createCustomerRequest.getEmail())
                .build();
    }
}
