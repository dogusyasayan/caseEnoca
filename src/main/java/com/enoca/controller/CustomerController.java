package com.enoca.controller;

import com.enoca.model.request.customer.CreateCustomerRequest;
import com.enoca.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    /**
     * Yeni bir müşteri oluşturmak için kullanılan endpoint.
     *
     * @param createCarRequest Oluşturulacak müşterinin bilgilerini içeren istek nesnesi
     * @return Oluşturulan müşterinin kimliğini temsil eden bir mesaj veya hata durumunda ilgili bilgiyi içeren bir mesaj
     */
    @PostMapping("/create")
    public String addCustomer(@RequestBody CreateCustomerRequest createCarRequest) {
        return customerService.addCustomer(createCarRequest);
    }
}