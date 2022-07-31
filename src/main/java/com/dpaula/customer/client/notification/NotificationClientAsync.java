package com.dpaula.customer.client.notification;

import com.dpaula.customer.producer.RabbitMQMessageProducer;
import org.springframework.stereotype.Component;

@Component
public record NotificationClientAsync(RabbitMQMessageProducer producer) {

    public void send(NotificationRequest request) {
        producer.publish(request, "internal.exchange", "internal.notification.routing-key");
    }
}
