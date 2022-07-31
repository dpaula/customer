package com.dpaula.customer.service;

import com.dpaula.customer.Customer;
import com.dpaula.customer.client.fraud.FraudClient;
import com.dpaula.customer.client.notification.NotificationClientAsync;
import com.dpaula.customer.client.notification.NotificationRequest;
import com.dpaula.customer.controller.CustomerRegistrationRequest;
import com.dpaula.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository repository, FraudClient fraudClient, NotificationClientAsync notificationClientAsync) {
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

        final var notificationRequest = NotificationRequest.builder()
                .toCustomerId(customer.getId())
                .toCustomerEmail(customer.getEmail())
                .message(getMessageFormat(customer.getFirstName()))
                .build();

        notificationClientAsync.send(notificationRequest);
    }

    private String getMessageFormat(String firstName) {
        return String.format("Bem-vindo %s, seu cadastro foi realizado com sucesso!", firstName);
    }
}
