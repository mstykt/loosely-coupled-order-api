package com.example.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderSummaryResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -371825568431674835L;

    private Long id;
    private Long buyerId;
    private String orderField1;
    private String orderField2;
    private int quantity;
}
