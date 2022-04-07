package com.example.mapper;

import com.example.model.response.OrderResponse;
import com.example.model.response.OrderSummaryResponse;
import com.example.persistence.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderResponse toOrderResponse(Order order);

    OrderSummaryResponse toOrderSummaryResponse(Order order);
}
