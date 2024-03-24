package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderSummary {

    private Long id;
    private Long buyerId;
    private String orderField1;
    private String orderField2;
    private int quantity;
}
