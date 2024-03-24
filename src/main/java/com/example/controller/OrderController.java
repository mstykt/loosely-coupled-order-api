package com.example.controller;

import com.example.model.request.OrderRequest;
import com.example.model.response.OrderResponse;
import com.example.model.response.OrderSummaryResponse;
import com.example.service.OrderAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderAppService orderAppService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        OrderResponse orderResponse = orderAppService.createOrder(request);

        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/summary")
    public ResponseEntity<OrderSummaryResponse> getOrderSummary(@PathVariable("id") Long id) {
        OrderSummaryResponse orderSummary = orderAppService.getOrderSummary(id);
        return ResponseEntity.ok(orderSummary);
    }
}
