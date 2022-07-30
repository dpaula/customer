package com.dpaula.customer.service;

import com.dpaula.customer.Customer;
import com.dpaula.customer.client.FraudCheckRequest;
import com.dpaula.customer.client.FraudClient;
import com.dpaula.customer.controller.CustomerRegistrationRequest;
import com.dpaula.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository repository, FraudClient fraudClient) {
    public void register(CustomerRegistrationRequest request) {

        final var customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        repository.saveAndFlush(customer);

        final var fraudCheckRequest = fraudClient.getFraudCheckRequest(customer.getId());

        if(fraudCheckRequest.isFraudster()) {
            throw new IllegalStateException("Customer is a fraudster");
        }
    }
}
