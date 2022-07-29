package com.dpaula.customer.controller;

import com.dpaula.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fernando de Lima on 28/07/22
 */
@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService service) {

    @PostMapping
    public void register(@RequestBody CustomerRegistrationRequest request) {
        log.info("Registering customer: {}", request);

        service.register(request);
    }
}
