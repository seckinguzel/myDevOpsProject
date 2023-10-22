package org.seckinguzel.producer;

import jakarta.annotation.PostConstruct;
import org.seckinguzel.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {
    @Value("${sr.rabbit.routing.name}")
    private String routingName;
    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;
    private final RabbitTemplate rabbitTemplate;

    public NotificationProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostConstruct
    public void init() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Notification notification = new Notification();

                    notification.setNotificationId(UUID.randomUUID().toString());
                    notification.setCreatedAt(new Date());
                    notification.setMessage("Welcome to my DevOps Project!");
                    notification.setSeen(Boolean.FALSE);

                    sendToQueue(notification);

                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public void sendToQueue(Notification notification) {
        System.out.println("Notification Sent ID: " + notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName ,routingName, notification);
    }
}
