package com.dpaula.customer.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Fernando de Lima on 29/07/22
 */
@Component
@AllArgsConstructor
public class FraudClient {

    private final IFraudClient client;

    public FraudCheckRequest getFraudCheckRequest(Integer customerId) {

        return client.getFraudCheckRequest(customerId);
    }
}
