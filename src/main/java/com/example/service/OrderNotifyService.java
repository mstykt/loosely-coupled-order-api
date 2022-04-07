package com.example.service;

import com.example.model.OrderCreatedMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderNotifyService {

    @Value("${kafka.producer.topic.order-created}")
    private String orderCreatedTopic;

    private final KafkaTemplate<Object, Object> kafkaTemplate;

    public void notifyOrder(Long orderId) {
        OrderCreatedMessage message = new OrderCreatedMessage(orderId);
        kafkaTemplate.send(orderCreatedTopic, message);
    }
}
