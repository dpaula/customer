package com.dpaula.customer.client.notification;

import org.springframework.stereotype.Component;

@Component
public record NotificationClient(INotificationClient client) {

    public void send(NotificationRequest request) {
        client.send(request);
    }
}
