package com.dpaula.customer.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Fernando de Lima on 29/07/22
 */
@Configuration
public class CustomerConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
