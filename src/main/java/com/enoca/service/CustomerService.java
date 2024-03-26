package com.enoca.service;

import com.enoca.builder.CustomerBuilder;
import com.enoca.domain.Customer;
import com.enoca.model.request.customer.CreateCustomerRequest;
import com.enoca.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerBuilder customerBuilder;

    public String addCustomer(CreateCustomerRequest createCarRequest) {
        if (customerRepository.existsByEmail(createCarRequest.getEmail())) {
            return "Email already exists";
        }
        Customer customer = customerBuilder.createCustomer(createCarRequest);
        customerRepository.save(customer);
        return "Customer added";
    }
}
