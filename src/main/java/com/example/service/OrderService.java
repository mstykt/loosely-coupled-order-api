package com.example.service;

import com.example.client.product.response.ProductResponse;
import com.example.client.seller.response.SellerResponse;
import com.example.model.request.OrderRequest;
import com.example.persistence.entity.Order;
import com.example.persistence.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo repo;

    public Order create(OrderRequest request,
                        SellerResponse sellerResponse,
                        ProductResponse productResponse) {
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

        return repo.save(order);
    }
}
