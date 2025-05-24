package com.manhnd.finance_trading.api.auth.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserDto {
    private String username;
    private String password;
}
