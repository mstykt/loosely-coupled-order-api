package com.example.service;

import com.example.client.product.response.ProductClientService;
import com.example.client.product.response.ProductResponse;
import com.example.client.seller.SellerClientService;
import com.example.client.seller.response.SellerResponse;
import com.example.mapper.OrderMapper;
import com.example.model.request.OrderRequest;
import com.example.model.response.OrderResponse;
import com.example.model.response.OrderSummaryResponse;
import com.example.persistence.entity.Order;
import com.example.persistence.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;
    private final ProductClientService productClientService;
    private final SellerClientService sellerClientService;
    private final OrderMapper orderMapper;
    private final OrderNotifyService orderNotifyService;

    public OrderResponse createOrder(OrderRequest request) {
        ProductResponse productResponse = productClientService.getProduct(request.getProductId());
        SellerResponse sellerResponse = sellerClientService.getSeller(request.getSellerId());
        Order order = Order.builder()
                .buyerId(request.getBuyerId())
                .sellerId(request.getSellerId())
                .sellerField1(sellerResponse.getSellerField1())
                .sellerField2(sellerResponse.getSellerField2())
                .productId(request.getProductId())
                .productField1(productResponse.getProductField1())
                .productField2(productResponse.getProductField2())
                .orderField1(request.getOrderField1())
                .orderField2(request.getOrderField2())
                .quantity(request.getQuantity())
                .build();
        Order savedOrder = orderRepo.save(order);
        orderNotifyService.notifyOrder(savedOrder.getId());
        return orderMapper.toOrderResponse(savedOrder);
    }

    @Cacheable(value= "Orders", key="#id")
    public OrderSummaryResponse getOrderSummary(Long id) {
        log.info("get order summary by id: " + id);
        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("cannot find order with given id: " + id));
        return orderMapper.toOrderSummaryResponse(order);
    }
}
