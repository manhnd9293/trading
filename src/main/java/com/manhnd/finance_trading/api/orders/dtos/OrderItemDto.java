package com.manhnd.finance_trading.api.orders.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderItemDto {
    private UUID productId;

    private Integer quantity;
}
