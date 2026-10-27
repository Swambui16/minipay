package com.sere.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomersController {

    public record CreateCustomerRequest(String name, String phone) {
    }

    public record CustomerResponse(long id, String name, String phone) {
    }

    @PostMapping("/api/customers")
    @ResponseStatus(HttpStatus.CREATED)   // sends 201 instead of 200
    public CustomerResponse createCustomer(@RequestBody CreateCustomerRequest request) {
          return new CustomerResponse(1, request.name(), request.phone());
    }
}
