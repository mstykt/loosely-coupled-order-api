package com.example.service;

import com.example.client.product.response.ProductClientService;
import com.example.client.product.response.ProductResponse;
import com.example.client.seller.SellerClientService;
import com.example.client.seller.response.SellerResponse;
import com.example.mapper.OrderMapper;
import com.example.model.OrderSummary;
import com.example.model.request.OrderRequest;
import com.example.model.response.OrderResponse;
import com.example.model.response.OrderSummaryResponse;
import com.example.persistence.entity.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderAppService {

    private final OrderService orderService;
    private final ProductClientService productClientService;
    private final SellerClientService sellerClientService;
    private final OrderMapper orderMapper;
    private final OrderNotifyService orderNotifyService;
    private final OrderStoreService orderStoreService;

    public OrderResponse createOrder(OrderRequest request) {
        ProductResponse productResponse = productClientService.getProduct(request.getProductId());
        SellerResponse sellerResponse = sellerClientService.getSeller(request.getSellerId());

        Order order = orderService.create(request, sellerResponse, productResponse);
        orderNotifyService.notifyOrder(order.getId());
        orderStoreService.store(order);
        return orderMapper.toOrderResponse(order);
    }

    public OrderSummaryResponse getOrderSummary(Long id) {
        OrderSummary orderSummary = orderStoreService.get(id);
        return orderMapper.toOrderSummaryResponse(orderSummary);
    }
}
