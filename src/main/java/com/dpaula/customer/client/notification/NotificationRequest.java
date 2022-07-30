package com.dpaula.customer.client.notification;

import lombok.Builder;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerEmail,
        String message
) {
    @Builder
    public NotificationRequest {}
}
