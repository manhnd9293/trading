package com.manhnd.finance_trading.api.orders.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderDto {
    private List<OrderItemDto> items;
}

