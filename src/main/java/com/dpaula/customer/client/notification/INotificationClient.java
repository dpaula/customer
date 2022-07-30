package com.dpaula.customer.client.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Fernando de Lima on 30/07/22
 */
@FeignClient("notification")
public interface INotificationClient {

    @PostMapping("/api/v1/notification")
    void send(NotificationRequest request);
}
