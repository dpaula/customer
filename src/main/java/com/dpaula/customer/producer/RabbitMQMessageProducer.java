package com.dpaula.customer.producer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Fernando de Lima on 30/07/22
 */
@Slf4j
@Component
@AllArgsConstructor
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(final Object payload, final String exchange, final String routingKey) {
        log.info("Publishing message to exchange: {} with routing key: {}, payload: {}", exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("Published message to exchange: {} with routing key: {}, payload: {}", exchange, routingKey, payload);
    }
}
