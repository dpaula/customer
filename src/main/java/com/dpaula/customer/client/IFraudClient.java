package com.dpaula.customer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Fernando de Lima on 29/07/22
 */
@FeignClient("fraud")
public interface IFraudClient {

    @GetMapping("/api/v1/fraud-check/{customerId}")
    FraudCheckRequest getFraudCheckRequest(@PathVariable Integer customerId);
}
