package com.manhnd.finance_trading.api.products.dtos;

import lombok.Data;

@Data
public class CreateProductDto {
    private String name;

    private Double price;
}
