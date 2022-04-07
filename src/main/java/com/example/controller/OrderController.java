package com.example.controller;

import com.example.model.request.OrderRequest;
import com.example.model.response.OrderResponse;
import com.example.model.response.OrderSummaryResponse;
import com.example.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        OrderResponse orderResponse = orderService.createOrder(request);

        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }

    @GetMapping("/summary/{id}")
    public ResponseEntity<OrderSummaryResponse> getOrderSummary(@PathVariable("id") Long id) {
        OrderSummaryResponse orderSummary = orderService.getOrderSummary(id);
        return ResponseEntity.ok(orderSummary);
    }
}
