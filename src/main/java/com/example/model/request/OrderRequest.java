package com.example.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Long buyerId;
    private Long productId;
    private Long sellerId;
    private String orderField1;
    private String orderField2;
    private int quantity;

}
