package org.seckinguzel.listener;

import org.seckinguzel.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {
    @RabbitListener(queues = "seckinguzel-queue")
    public void handleMessage(Notification notification) {
        System.out.println("Message Received!");
        System.out.println(notification.toString());
    }
}
