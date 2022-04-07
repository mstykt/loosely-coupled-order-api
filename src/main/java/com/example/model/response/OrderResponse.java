package com.example.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long id;
    private Long buyerId;
    private Long productId;
    private String productField1;
    private String productField2;
    private Long sellerId;
    private String sellerField1;
    private String sellerField2;
    private String orderField1;
    private String orderField2;
    private int quantity;
}
