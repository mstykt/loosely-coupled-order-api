package com.example.service;

import com.example.mapper.OrderMapper;
import com.example.model.OrderSummary;
import com.example.persistence.entity.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderStoreService {

    private final RedisTemplate<Long, String> redisTemplate;
    private final OrderMapper orderMapper;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void store(Order order) {
        OrderSummary orderSummary = orderMapper.toOrderSummary(order);
        String orderSummaryStr;
        orderSummaryStr = objectMapper.writeValueAsString(orderSummary);

        redisTemplate.opsForValue()
                .set(order.getId(), orderSummaryStr, 2L, TimeUnit.HOURS);
    }

    @SneakyThrows
    public OrderSummary get(Long id) {
        String orderSummerStr = redisTemplate.opsForValue().get(id);

        OrderSummary orderSummary = objectMapper.readValue(orderSummerStr, OrderSummary.class);

        log.info("order summer found for orderId: {}", orderSummary.getId());
        return orderSummary;
    }
}
